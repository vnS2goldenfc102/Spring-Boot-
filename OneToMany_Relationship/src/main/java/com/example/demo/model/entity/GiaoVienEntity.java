package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "giaoviens")
public class GiaoVienEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_gv;
    @Column(name = "name_gv")
    private String nameGv;
    @Column(name = "age_gv")
    private Integer ageGv;

    @OneToMany(mappedBy = "giaovien", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<SinhVienEntity> sinhvien;

}
