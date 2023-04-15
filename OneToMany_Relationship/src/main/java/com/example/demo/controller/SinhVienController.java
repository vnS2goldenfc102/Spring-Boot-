package com.example.demo.controller;

import com.example.demo.model.entity.SinhVienEntity;
import com.example.demo.model.in.SinhVienIn;
import com.example.demo.service.SinhVien.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("sinhvien")
public class SinhVienController {
    @Autowired
    SinhVienService sinhVienService;
    @GetMapping("")
    ResponseEntity<?> getSV() { return new ResponseEntity<>(sinhVienService.get(), HttpStatus.OK);}
    @PostMapping("")
    ResponseEntity<?> addSV(@RequestBody SinhVienIn input) { return new ResponseEntity<>(sinhVienService.add(input), HttpStatus.OK);}
    @PutMapping("/{Id}")
    ResponseEntity<?> updateSV(@RequestBody SinhVienIn input, @PathVariable Integer Id){
        return new ResponseEntity<>(sinhVienService.update(input, Id), HttpStatus.OK);
    }
    @DeleteMapping("/{Id}")
    ResponseEntity<?> deleteSV(@PathVariable Integer Id) {
        return new ResponseEntity<>(sinhVienService.delete(Id), HttpStatus.OK);
    }
}
