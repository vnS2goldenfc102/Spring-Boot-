package com.example.demo.service.GiaoVien;

import com.example.demo.mapper.GiaoVienMapper;
import com.example.demo.model.entity.GiaoVienEntity;
import com.example.demo.model.in.GiaoVienIn;
import com.example.demo.model.response.ResponseMessage;
import com.example.demo.repository.GiaoVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GiaoVienService implements IGiaoVienService {
    @Autowired
    GiaoVienRepository giaoVienRepository;
    @Override
    public ResponseMessage get() {
        List<GiaoVienEntity> list = giaoVienRepository.findAll();
        return new ResponseMessage("da ve", list);
    }

    @Override
    public ResponseMessage add(GiaoVienIn input) {
        GiaoVienEntity giaoVienEntity = GiaoVienMapper.MapIn(input);
        giaoVienRepository.save(giaoVienEntity);
        return new ResponseMessage("Add Success");
    }

    @Override
    public ResponseMessage update(GiaoVienIn input, Integer Id) {
        GiaoVienEntity giaoVienEntity = giaoVienRepository.getById(Id);
        giaoVienEntity.setNameGv(input.getNameGv());
        giaoVienEntity.setAgeGv(input.getAgeGv());
        giaoVienRepository.save(giaoVienEntity);
        return new ResponseMessage("Update Success");
    }

    @Override
    public ResponseMessage delete(Integer Id) {
        GiaoVienEntity giaoVienEntity = giaoVienRepository.getById(Id);
        giaoVienRepository.delete(giaoVienEntity);
        return new ResponseMessage("Delete Success");
    }
}
