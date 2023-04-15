package com.example.demo.repository;

import com.example.demo.model.entity.SinhVienEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVienEntity, Integer> {
    @Query("SELECT e FROM SinhVienEntity e")
    List<SinhVienEntity> findStudent();

    @Modifying
    @Query(value = "insert into sinhvien(name, age, id_gv) VALUES (:name, :age, id_gv)", nativeQuery = true)
    @Transactional
    void insertStudent(@Param("name") String name, @Param("age") int age, @Param("id_gv") int id_gv);

    @Modifying
    @Query(value = "update sinhvien set name = :name, age = :age where id = :id", nativeQuery = true)
    @Transactional
    void updateStudent(@Param("name") String name, @Param("age") int age, @Param("id") int id);

    @Modifying
    @Query(value = "delete from sinhvien where id = :id", nativeQuery = true)
    @Transactional
    void deleteStudent(@Param("id") int id);
}
