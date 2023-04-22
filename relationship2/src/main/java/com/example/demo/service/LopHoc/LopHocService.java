package com.example.demo.service.LopHoc;

import com.example.demo.mapper.GiaoVienMapper;
import com.example.demo.mapper.LopHocMapper;
import com.example.demo.model.dto.GiaoVienDto;
import com.example.demo.model.dto.LopHocDto;
import com.example.demo.model.entity.GiaoVienEntity;
import com.example.demo.model.entity.LopHocEntity;
import com.example.demo.model.entity.SinhVienEntity;
import com.example.demo.model.in.GiaoVienIn;
import com.example.demo.model.in.LopHocIn;
import com.example.demo.model.in.SinhVienIn;
import com.example.demo.model.response.ResponseMessage;
import com.example.demo.repository.GiaoVienRepository;
import com.example.demo.repository.LopHocRepository;
import com.example.demo.repository.SinhVienRepository;
import com.example.demo.service.ConstantsService.ConstantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LopHocService implements ILopHocService{
    @Autowired
    LopHocRepository lopHocRepository;
    @Autowired
    SinhVienRepository sinhVienRepository;
    @Autowired
    GiaoVienRepository giaoVienRepository;
    @Override
    public ResponseMessage get() {
        List<LopHocEntity> list = lopHocRepository.getAll();
        List<LopHocDto> listDto = list.stream().map(LopHocMapper::MapEntity).collect(Collectors.toList());
        return new ResponseMessage(listDto, "da ve", null);
    }

    @Override
    public ResponseMessage add(LopHocIn input) {
        lopHocRepository.createClass(input.getName());
        return new ResponseMessage("Add Success");
    }

    @Override
    public ResponseMessage update(LopHocIn input, Integer Id) {
        LopHocEntity lopHocEntity = lopHocRepository.getById(Id);
        lopHocEntity.setName(input.getName());
        lopHocRepository.updateClass(lopHocEntity.getName(), lopHocEntity.getId_lop());
        return new ResponseMessage("Update Success");
    }

    @Override
    public ResponseMessage delete(Integer Id) {
        LopHocEntity lopHocEntity = lopHocRepository.getById(Id);
        lopHocRepository.deleteClass(lopHocEntity.getId_lop());
        return new ResponseMessage("Delete Success");
    }


    @Override
    public ResponseMessage addSV(List<Integer> input, Integer Id){
        LopHocEntity lopHocEntity = lopHocRepository.getById(Id);
//      Kiểm tra xem lớp đã đủ sinh viên chưa, nếu chưa thì sẽ được add
        if(lopHocEntity.getSinhvien().size() < ConstantsService.MAX_STUDENT) {
//            Add nhiều sinh viên vào lớp cùng lúc, truyền 1 list đầu vào bao gồm các mã sinh viên,
//            sau đó sẽ xét lần lượt cập nhật id_lop cho từng sinh viên đó ứng với id lớp học đang add
//            sinh viên vào
            for(int i = 0; i < input.size(); i++){
                SinhVienEntity sinhVienEntity = sinhVienRepository.getByStudentCode(input.get(i));
                sinhVienEntity.setLophoc(lopHocEntity);
                sinhVienRepository.save(sinhVienEntity);
            }
            return new ResponseMessage("Gòy nha em");
        }
        else {
            return new ResponseMessage("The number of students has exceeded 3");
        }
    }

//    Task 2: 1 lớp có 1 gvcn
    @Override
    public ResponseMessage updateGV(Integer id_lop, Integer id_gv) {
//        Cập nhật lại id_lop trong giao vien
        GiaoVienEntity giaoVienEntity = giaoVienRepository.getById(id_gv);
        LopHocEntity lopHocEntity = lopHocRepository.getById(id_lop);
        giaoVienEntity.setLophoc(lopHocEntity);
        giaoVienRepository.save(giaoVienEntity);

        return new ResponseMessage("Update homeroom teacher successfully");
    }

}
