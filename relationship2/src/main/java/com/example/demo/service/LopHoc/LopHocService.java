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

//    @Override
//    public ResponseMessage addSV(List<SinhVienIn> input, Integer Id){
////           LopHocEntity lopHocEntity = lopHocRepository.getById(Id);
////           SinhVienEntity sinhVienEntity = sinhVienRepository.getByStudentCode(input.getStudent_code());
////           sinhVienEntity.setLophoc(lopHocEntity);
////           sinhVienRepository.save(sinhVienEntity);
//
//        return new ResponseMessage("Gòi nha em");
//    }

    @Override
    public ResponseMessage addSV(List<Integer> input, Integer Id){
           LopHocEntity lopHocEntity = lopHocRepository.getById(Id);
           for(int i = 0; i < input.size(); i++){
               SinhVienEntity sinhVienEntity = sinhVienRepository.getByStudentCode(input.get(i));
               sinhVienEntity.setLophoc(lopHocEntity);
               sinhVienRepository.save(sinhVienEntity);
           }
        return new ResponseMessage("Gòi nha em");
    }
}
