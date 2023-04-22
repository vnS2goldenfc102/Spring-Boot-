package com.example.demo.mapper;

import com.example.demo.model.dto.GiaoVienDto;
import com.example.demo.model.dto.SinhVienDto;
import com.example.demo.model.entity.GiaoVienEntity;
import com.example.demo.model.entity.SinhVienEntity;
import com.example.demo.model.in.GiaoVienIn;

import java.util.stream.Collectors;

public class GiaoVienMapper {
    public static GiaoVienEntity MapIn (GiaoVienIn input) {
        GiaoVienEntity giaoVienEntity = new GiaoVienEntity();
        giaoVienEntity.setId_gv(input.getId_gv());
        giaoVienEntity.setName_gv(input.getName_gv());
        giaoVienEntity.setAge_gv(input.getAge_gv());
        return giaoVienEntity;
    }

    public static GiaoVienDto MapEntity (GiaoVienEntity input) {
        GiaoVienDto giaoVienDto = new GiaoVienDto();
        giaoVienDto.setId_gv(input.getId_gv());
        giaoVienDto.setName_gv(input.getName_gv());
        giaoVienDto.setAge_gv(input.getAge_gv());
        if(input.getLophoc() == null){
            giaoVienDto.setId_lop(null);
        } else {
            giaoVienDto.setId_lop(input.getLophoc().getId_lop());
        }
        giaoVienDto.setSinhvien(input.getSinhvien().stream().map(SinhVienMapper::MapEntity).collect(Collectors.toList()));
        return giaoVienDto;
    }
}
