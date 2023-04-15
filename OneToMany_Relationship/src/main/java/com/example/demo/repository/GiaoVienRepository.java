package com.example.demo.repository;

import com.example.demo.model.entity.GiaoVienEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiaoVienRepository extends JpaRepository<GiaoVienEntity, Integer> {
}
