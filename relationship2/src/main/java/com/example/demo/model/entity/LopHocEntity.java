package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lop_hoc")
public class LopHocEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_lop;
    @Column(name = "name")
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "lophoc",cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<SinhVienEntity> sinhvien;

}
