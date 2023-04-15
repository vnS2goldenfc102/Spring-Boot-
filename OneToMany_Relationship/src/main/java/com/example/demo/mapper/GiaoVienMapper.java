package com.example.demo.mapper;

import com.example.demo.model.entity.GiaoVienEntity;
import com.example.demo.model.entity.SinhVienEntity;
import com.example.demo.model.in.GiaoVienIn;
import com.example.demo.model.in.SinhVienIn;

public class GiaoVienMapper {
        public static GiaoVienEntity MapIn (GiaoVienIn input) {
            GiaoVienEntity giaoVienEntity = new GiaoVienEntity();
            giaoVienEntity.setId_gv(input.getId_gv());
            giaoVienEntity.setNameGv(input.getNameGv());
            giaoVienEntity.setAgeGv(input.getAgeGv());
            return giaoVienEntity;
        }


}
