package com.example.demo.repository;

import com.example.demo.model.entity.SinhVienEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface SinhVienRepository extends JpaRepository<SinhVienEntity, Integer> {
    @Query(value = "SELECT * FROM sinh_vien ", nativeQuery = true)
    List<SinhVienEntity> getAll() ;

    @Modifying
    @Query(value = "INSERT INTO sinh_vien(name, age, id_gv) VALUES (:name, :age, :id_gv)",nativeQuery = true)
    @Transactional
    void createStudent(@Param("name") String name, @Param("age") Integer age, @Param("id_gv") Integer id_gv);

    @Modifying
    @Query(value = "UPDATE sinh_vien SET name =:name, age = :age, id_gv = :id_gv WHERE id = :id", nativeQuery = true)
    @Transactional
    void updateStudent(@Param("name") String name, @Param("age") Integer age, @Param("id_gv") Integer id_gv, @Param("id") Integer id);

    @Modifying
    @Query(value = "DELETE FROM sinh_vien WHERE id = :id", nativeQuery = true)
    @Transactional
    void deleteStudent(@Param("id") Integer id);
    Page<SinhVienEntity> getAllBy(Pageable pageable);
    Page<SinhVienEntity> findAllByNameContaining(Pageable pageable, String textSearch);

}
