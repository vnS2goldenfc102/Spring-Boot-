package com.example.demo.service.SinhVien;

import com.example.demo.mapper.SinhVienMapper;
import com.example.demo.model.dto.SinhVienDto;
import com.example.demo.model.entity.GiaoVienEntity;
import com.example.demo.model.entity.LopHocEntity;
import com.example.demo.model.entity.SinhVienEntity;
import com.example.demo.model.in.SinhVienIn;
import com.example.demo.model.response.ResponseMessage;
import com.example.demo.repository.GiaoVienRepository;
import com.example.demo.repository.LopHocRepository;
import com.example.demo.repository.SinhVienRepository;
import com.example.demo.service.ConstantsService.ConstantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SinhVienService implements ISinhVienService {
    @Autowired
    SinhVienRepository sinhVienRepository;
    @Autowired
    GiaoVienRepository giaoVienRepository;
    @Autowired
    LopHocRepository lopHocRepository;
    @Override
    public ResponseMessage get() {
        List<SinhVienEntity> list = sinhVienRepository.getAll();
        return new ResponseMessage(list, "da ve", null);
    }

    @Override
    public ResponseMessage add(SinhVienIn input) {
       LopHocEntity lopHocEntity = lopHocRepository.getById(input.getId_lop());
//       Khi add 1 sinh viên phải kiểm tra xem lớp đó đã đủ sinh viên chưa, nếu chưa thì mới cho add
//        (update tương tự)
       if(lopHocEntity.getSinhvien().size() < ConstantsService.MAX_STUDENT){
           sinhVienRepository.createStudent(input.getStudent_code(), input.getName(), input.getAge(), input.getId_gv(), input.getId_lop());
           return new ResponseMessage("Add Success");
       }
       else {
           return new ResponseMessage("The number of students has exceeded " + ConstantsService.MAX_STUDENT);
       }
    }

    @Override
    public ResponseMessage update(SinhVienIn input, Integer Id) {
        LopHocEntity lopHocEntity = lopHocRepository.getById(input.getId_lop());
        if (lopHocEntity.getSinhvien().size() < ConstantsService.MAX_STUDENT) {
            SinhVienEntity sinhVienEntity = sinhVienRepository.getById(Id);
            LopHocEntity lopHocEntity2 = lopHocRepository.getById(input.getId_lop());
            sinhVienEntity.setName(input.getName());
            sinhVienEntity.setAge(input.getAge());
            sinhVienEntity.setLophoc(lopHocEntity2);
            sinhVienRepository.updateStudent(sinhVienEntity.getStudent_code(), sinhVienEntity.getName(), sinhVienEntity.getAge(), input.getId_gv(), sinhVienEntity.getLophoc().getId_lop(), sinhVienEntity.getId());
            return new ResponseMessage("Update Success");
        }else {
            return new ResponseMessage("The number of students has exceeded 3");
        }
    }

    @Override
    public ResponseMessage delete(Integer Id) {
        SinhVienEntity sinhVienEntity = sinhVienRepository.getById(Id);
//        sinhVienRepository.delete(sinhVienEntity);
        sinhVienRepository.deleteStudent(sinhVienEntity.getId());
        return new ResponseMessage("Delete Success");
    }

    @Override
    public ResponseMessage paginate(Integer activePage, Integer limit) {
        Pageable pageable = PageRequest.of(activePage, limit);
        Page<SinhVienEntity> list = sinhVienRepository.getAllBy(pageable);
        List<SinhVienDto> listDto = list.stream().map(SinhVienMapper::MapEntity).collect(Collectors.toList());
        return new ResponseMessage(listDto, "Da ve", list.getTotalPages());
    }

    @Override
    public ResponseMessage search(Integer activePage, Integer limit, String textSearch) {
        Pageable pageable = PageRequest.of(activePage, limit);
        Page<SinhVienEntity> list = sinhVienRepository.findAllByNameContaining(pageable, textSearch);
        List<SinhVienDto> listDto = list.stream().map(SinhVienMapper::MapEntity).collect(Collectors.toList());
        return new ResponseMessage(listDto, "Da ve", list.getTotalPages());
    }
}
