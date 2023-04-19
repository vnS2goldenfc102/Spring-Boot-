package com.example.demo.controller;

import com.example.demo.model.in.GiaoVienIn;
import com.example.demo.service.GiaoVien.GiaoVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("teacher")
public class GiaoVienController {
    @Autowired
    GiaoVienService giaoVienService;
    @GetMapping("")
    ResponseEntity<?> getGV() { return new ResponseEntity<>(giaoVienService.get(), HttpStatus.OK);}
    @PostMapping("")
    ResponseEntity<?> addGV(@RequestBody GiaoVienIn input) { return new ResponseEntity<>(giaoVienService.add(input), HttpStatus.OK);}
    @PutMapping("/{Id}")
    ResponseEntity<?> updateGV(@RequestBody GiaoVienIn input,@PathVariable Integer Id) {
        return new ResponseEntity<>(giaoVienService.update(input, Id), HttpStatus.OK);
    }
    @DeleteMapping("/{Id}")
    ResponseEntity<?> deleteGV(@PathVariable Integer Id) {
        return new ResponseEntity<>(giaoVienService.delete(Id), HttpStatus.OK);
    }
}
