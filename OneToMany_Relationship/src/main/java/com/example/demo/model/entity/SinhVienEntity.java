package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sinhvien")
public class SinhVienEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(name = "name")
    private String Name;
    @Column(name = "age")
    private Integer Age;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_gv")
    private GiaoVienEntity giaovien;

}
