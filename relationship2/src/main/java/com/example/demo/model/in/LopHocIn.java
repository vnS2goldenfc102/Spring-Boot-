package com.example.demo.model.in;

import com.example.demo.model.dto.SinhVienDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LopHocIn {
    private Integer id_lop;
    private String name;
    private List<SinhVienDto> sinhvien;
}
