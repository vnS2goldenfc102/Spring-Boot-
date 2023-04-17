package com.example.demo.service;

import com.example.demo.mapper.GiaoVienMapper;
import com.example.demo.mapper.SinhVienMapper;
import com.example.demo.model.dto.GiaoVienDto;
import com.example.demo.model.entity.GiaoVienEntity;
import com.example.demo.model.entity.SinhVienEntity;
import com.example.demo.model.in.GiaoVienIn;
import com.example.demo.model.in.SinhVienIn;
import com.example.demo.model.response.ResponseMessage;
import com.example.demo.repository.GiaoVienRepository;
import com.example.demo.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GiaoVienService implements IGiaoVienService{
    @Autowired
    GiaoVienRepository giaoVienRepository;
    @Override
    public ResponseMessage get() {
        List<GiaoVienEntity> list = giaoVienRepository.getAll();
        List<GiaoVienDto> listDto = list.stream().map(GiaoVienMapper::MapEntity).collect(Collectors.toList());
        return new ResponseMessage(listDto, "da ve", null);
    }

    @Override
    public ResponseMessage add(GiaoVienIn input) {
        giaoVienRepository.createTeacher(input.getName_gv(), input.getAge_gv());
//        sinhVienRepository.save(sinhVienEntity);
        return new ResponseMessage("Add Success");
    }

    @Override
    public ResponseMessage update(GiaoVienIn input, Integer Id) {
        GiaoVienEntity giaoVienEntity = giaoVienRepository.getById(Id);
        giaoVienEntity.setName_gv(input.getName_gv());
        giaoVienEntity.setAge_gv(input.getAge_gv());
        giaoVienRepository.updateTeacher(giaoVienEntity.getName_gv(), giaoVienEntity.getAge_gv(), giaoVienEntity.getId_gv());
        return new ResponseMessage("Update Success");
//        return null;
    }

    @Override
    public ResponseMessage delete(Integer Id) {
        GiaoVienEntity giaoVienEntity = giaoVienRepository.getById(Id);
        giaoVienRepository.deleteTeacher(giaoVienEntity.getId_gv());
        return new ResponseMessage("Delete Success");
    }
}
