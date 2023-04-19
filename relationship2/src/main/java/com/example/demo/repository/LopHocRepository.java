package com.example.demo.repository;

import com.example.demo.model.entity.GiaoVienEntity;
import com.example.demo.model.entity.LopHocEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LopHocRepository extends JpaRepository<LopHocEntity, Integer> {
    @Query(value = "SELECT * FROM lop_hoc ", nativeQuery = true)
    List<LopHocEntity> getAll() ;

    @Modifying
    @Query(value = "INSERT INTO lop_hoc(name) VALUES (:name)",nativeQuery = true)
    @Transactional
    void createClass(@Param("name") String name);

    @Modifying
    @Query(value = "UPDATE lop_hoc SET name =:name WHERE id_lop = :id", nativeQuery = true)
    @Transactional
    void updateClass(@Param("name") String name, @Param("id") Integer id);

    @Modifying
    @Query(value = "DELETE FROM lop_hoc WHERE id_lop = :id", nativeQuery = true)
    @Transactional
    void deleteClass(@Param("id") Integer id);


}
