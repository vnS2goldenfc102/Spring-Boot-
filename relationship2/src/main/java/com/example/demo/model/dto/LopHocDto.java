package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LopHocDto {
    private Integer id_lop;
    private String name;
    private List<SinhVienDto> sinhvien;

}
