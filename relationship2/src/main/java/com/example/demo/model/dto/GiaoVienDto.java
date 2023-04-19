package com.example.demo.model.dto;

import com.example.demo.model.entity.GiaoVienEntity;
import com.example.demo.model.entity.SinhVienEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GiaoVienDto {
    private Integer id_gv;
    private String name_gv;
    private Integer age_gv;
    private List<SinhVienDto> sinhvien;
}
