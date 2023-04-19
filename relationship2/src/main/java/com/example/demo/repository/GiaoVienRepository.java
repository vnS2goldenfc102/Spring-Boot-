package com.example.demo.repository;

import com.example.demo.model.entity.GiaoVienEntity;
import com.example.demo.model.entity.SinhVienEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GiaoVienRepository extends JpaRepository<GiaoVienEntity, Integer> {
    @Query(value = "SELECT * FROM giao_vien ", nativeQuery = true)
    List<GiaoVienEntity> getAll() ;

    @Modifying
    @Query(value = "INSERT INTO giao_vien(name_gv, age_gv) VALUES (:name, :age)",nativeQuery = true)
    @Transactional
    void createTeacher(@Param("name") String name, @Param("age") Integer age);

    @Modifying
    @Query(value = "UPDATE giao_vien SET name_gv =:name, age_gv = :age WHERE id_gv = :id", nativeQuery = true)
    @Transactional
    void updateTeacher(@Param("name") String name, @Param("age") Integer age, @Param("id") Integer id);

    @Modifying
    @Query(value = "DELETE FROM giao_vien WHERE id_gv = :id", nativeQuery = true)
    @Transactional
    void deleteTeacher(@Param("id") Integer id);
}
