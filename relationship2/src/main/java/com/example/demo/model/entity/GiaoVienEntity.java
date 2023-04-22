package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "giao_vien")
public class GiaoVienEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_gv;
    @Column(name = "name_gv")
    private String name_gv;
    @Column(name = "age_gv")
    private Integer age_gv;
    @JsonIgnore
    @OneToMany(mappedBy = "giaovien", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<SinhVienEntity> sinhvien;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_lop")
    private LopHocEntity lophoc;
//    @Override
//    public String toString() {
//        return "giaovien{" +
//                "id_gv=" + id_gv +
//                ", name_gv='" + name_gv + '\'' +
//                "}";
//    }
}
