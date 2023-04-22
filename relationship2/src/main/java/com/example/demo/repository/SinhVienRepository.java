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

//    @Query(value = "SELECT * FROM sinh_vien WHERE student_code = :student_code", nativeQuery = true)
//    SinhVienEntity getByStudentCode(Integer student_code);

    @Query(value = "SELECT * FROM sinh_vien WHERE student_code = :student_code", nativeQuery = true)
    SinhVienEntity getByStudentCode(Integer student_code);
    @Modifying
    @Query(value = "INSERT INTO sinh_vien(student_code, name, age, id_gv, id_lop) " + "VALUES (:student_code, :name, :age, :id_gv, :id_lop)" ,nativeQuery = true)
    @Transactional
    void createStudent(@Param("student_code") Integer student_code, @Param("name") String name, @Param("age") Integer age, @Param("id_gv") Integer id_gv, @Param("id_lop") Integer id_lop);

    @Modifying
    @Query(value = "UPDATE sinh_vien SET student_code =:student_code, name =:name, age = :age, id_gv = :id_gv, id_lop = :id_lop WHERE sinh_vien.id = :id", nativeQuery = true)
    @Transactional
    void updateStudent(@Param("student_code") Integer student_code, @Param("name") String name, @Param("age") Integer age, @Param("id_gv") Integer id_gv, @Param("id_lop") Integer id_lop, @Param("id") Integer id);

    @Modifying
    @Query(value = "DELETE FROM sinh_vien WHERE id = :id", nativeQuery = true)
    @Transactional
    void deleteStudent(@Param("id") Integer id);
    Page<SinhVienEntity> getAllBy(Pageable pageable);
    Page<SinhVienEntity> findAllByNameContaining(Pageable pageable, String textSearch);

}
