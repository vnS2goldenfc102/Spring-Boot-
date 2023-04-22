package com.example.demo.mapper;

import com.example.demo.model.dto.GiaoVienDto;
import com.example.demo.model.dto.LopHocDto;
import com.example.demo.model.entity.GiaoVienEntity;
import com.example.demo.model.entity.LopHocEntity;
import com.example.demo.model.in.GiaoVienIn;
import com.example.demo.model.in.LopHocIn;

import java.util.List;
import java.util.stream.Collectors;

public class LopHocMapper {
    public static LopHocEntity MapIn (LopHocIn input) {
        LopHocEntity lopHocEntity = new LopHocEntity();
        lopHocEntity.setName(input.getName());
        return lopHocEntity;
    }
    public static LopHocDto MapEntity (LopHocEntity input) {
        LopHocDto lopHocDto = new LopHocDto();
        lopHocDto.setId_lop(input.getId_lop());
        lopHocDto.setName(input.getName());
        lopHocDto.setSinhvien(input.getSinhvien().stream().map(SinhVienMapper::MapEntity).collect(Collectors.toList()));
        if(input.getGiaovien() == null){
            lopHocDto.setId_gv(null);
            lopHocDto.setName_gv(null);
        }else {
            lopHocDto.setId_gv(input.getGiaovien().getId_gv());
            lopHocDto.setName_gv(input.getGiaovien().getName_gv());
        }

        return lopHocDto;
    }
}
