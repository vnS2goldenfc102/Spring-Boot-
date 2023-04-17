package com.example.demo.service;

import com.example.demo.mapper.SinhVienMapper;
import com.example.demo.model.dto.SinhVienDto;
import com.example.demo.model.entity.GiaoVienEntity;
import com.example.demo.model.entity.SinhVienEntity;
import com.example.demo.model.in.SinhVienIn;
import com.example.demo.model.response.ResponseMessage;
import com.example.demo.repository.GiaoVienRepository;
import com.example.demo.repository.SinhVienRepository;
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
    @Override
    public ResponseMessage get() {
        List<SinhVienEntity> list = sinhVienRepository.getAll();
        return new ResponseMessage(list, "da ve", null);
    }

    @Override
    public ResponseMessage add(SinhVienIn input) {
        SinhVienEntity sinhVienEntity = SinhVienMapper.MapIn(input);
        sinhVienRepository.createStudent(input.getName(), input.getAge(), input.getId_gv());
//        sinhVienRepository.save(sinhVienEntity);
        return new ResponseMessage("Add Success");
    }

    @Override
    public ResponseMessage update(SinhVienIn input, Integer Id) {
        SinhVienEntity sinhVienEntity = sinhVienRepository.getById(Id);
        GiaoVienEntity giaoVienEntity = giaoVienRepository.getById(input.getId_gv());
        sinhVienEntity.setName(input.getName());
        sinhVienEntity.setAge(input.getAge());
        sinhVienEntity.setGiaovien(giaoVienEntity);
        sinhVienRepository.updateStudent(sinhVienEntity.getName(), sinhVienEntity.getAge(), sinhVienEntity.getGiaovien().getId_gv(), sinhVienEntity.getId());
        return new ResponseMessage("Update Success");
//        return null;
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
