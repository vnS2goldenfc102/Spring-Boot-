package com.example.demo.controller;

import com.example.demo.model.in.SinhVienIn;
import com.example.demo.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("student")
public class SinhVienController {
    @Autowired
    SinhVienService sinhVienService;
    @GetMapping("")
    ResponseEntity<?> getSV() { return new ResponseEntity<>(sinhVienService.get(), HttpStatus.OK);}
    @PostMapping("")
    ResponseEntity<?> addSV(@RequestBody SinhVienIn input) { return new ResponseEntity<>(sinhVienService.add(input), HttpStatus.OK);}
    @PutMapping("/{Id}")
    ResponseEntity<?> updateSV(@RequestBody SinhVienIn input,@PathVariable Integer Id) {
        return new ResponseEntity<>(sinhVienService.update(input, Id), HttpStatus.OK);
    }
    @DeleteMapping("/{Id}")
    ResponseEntity<?> deleteSV(@PathVariable Integer Id) {
        return new ResponseEntity<>(sinhVienService.delete(Id), HttpStatus.OK);
    }
    @GetMapping("/paginate")
    ResponseEntity<?> paginate(@RequestParam Integer activePage, @RequestParam Integer limit){
        return new ResponseEntity<>(sinhVienService.paginate(activePage, limit), HttpStatus.OK);
    }
    @GetMapping("/search")
    ResponseEntity<?> search(@RequestParam Integer activePage, @RequestParam Integer limit, @RequestParam String textSearch){
        return new ResponseEntity<>(sinhVienService.search(activePage, limit, textSearch), HttpStatus.OK);
    }
}
