package com.example.demo.mapper;

import com.example.demo.model.dto.SinhVienDto;
import com.example.demo.model.entity.SinhVienEntity;
import com.example.demo.model.in.SinhVienIn;

public class SinhVienMapper {
    public static SinhVienEntity MapIn (SinhVienIn input) {
        SinhVienEntity sinhVienEntity = new SinhVienEntity();
        sinhVienEntity.setId(input.getId());
        sinhVienEntity.setName(input.getName());
        sinhVienEntity.setAge(input.getAge());
        return sinhVienEntity;
    }
    public static SinhVienDto MapEntity (SinhVienEntity input) {
        SinhVienDto sinhVienDto = new SinhVienDto();
        sinhVienDto.setId(input.getId());
        sinhVienDto.setName(input.getName());
        sinhVienDto.setAge(input.getAge());
        return sinhVienDto;
    }
}
