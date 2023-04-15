package com.example.demo.service.SinhVien;

import com.example.demo.model.response.ResponseMessage;
import com.example.demo.model.entity.SinhVienEntity;
import com.example.demo.model.in.SinhVienIn;
import com.example.demo.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SinhVienService implements ISinhVienService {
    @Autowired
    SinhVienRepository sinhVienRepository;
    @Override
    public ResponseMessage get() {
        List<SinhVienEntity> list = sinhVienRepository.findStudent();
        return new ResponseMessage("da ve", list);
    }

    @Override
    public ResponseMessage add(SinhVienIn input) {
//        SinhVienEntity sinhVienEntity = SinhVienMapper.MapIn(input);
        sinhVienRepository.insertStudent(input.getName(), input.getAge(), input.getId_gv());
        return new ResponseMessage("Add Success");
    }

    @Override
    public ResponseMessage update(SinhVienIn input, Integer Id) {
        SinhVienEntity sinhVienEntity = sinhVienRepository.getById(Id);
        sinhVienEntity.setName(input.getName());
        sinhVienEntity.setAge(input.getAge());
        sinhVienRepository.updateStudent(sinhVienEntity.getName(), sinhVienEntity.getAge(), sinhVienEntity.getId());
        return new ResponseMessage("Update Success");
    }

    @Override
    public ResponseMessage delete(Integer Id) {
//        SinhVienEntity sinhVienEntity = sinhVienRepository.getById(Id);
        sinhVienRepository.deleteStudent(Id);
        return new ResponseMessage("Delete Success");
    }
}
