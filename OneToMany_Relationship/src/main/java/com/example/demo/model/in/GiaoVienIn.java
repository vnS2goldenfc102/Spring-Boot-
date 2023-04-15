package com.example.demo.model.in;

import jakarta.persistence.Column;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GiaoVienIn {
    private Integer id_gv;
    private String nameGv;
    private Integer ageGv;
}
