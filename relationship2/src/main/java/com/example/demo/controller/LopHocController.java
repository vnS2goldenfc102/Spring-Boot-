package com.example.demo.controller;

import com.example.demo.model.in.GiaoVienIn;
import com.example.demo.model.in.LopHocIn;
import com.example.demo.model.in.SinhVienIn;
import com.example.demo.service.GiaoVien.GiaoVienService;
import com.example.demo.service.LopHoc.LopHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("classroom")
public class LopHocController {
    @Autowired
    LopHocService lopHocService;
    @GetMapping("")
    ResponseEntity<?> get() { return new ResponseEntity<>(lopHocService.get(), HttpStatus.OK);}
    @PostMapping("")
    ResponseEntity<?> add(@RequestBody LopHocIn input) { return new ResponseEntity<>(lopHocService.add(input), HttpStatus.OK);}
    @PutMapping("/{Id}")
    ResponseEntity<?> update(@RequestBody LopHocIn input,@PathVariable Integer Id) {
        return new ResponseEntity<>(lopHocService.update(input, Id), HttpStatus.OK);
    }
    @DeleteMapping("/{Id}")
    ResponseEntity<?> delete(@PathVariable Integer Id) {
        return new ResponseEntity<>(lopHocService.delete(Id), HttpStatus.OK);
    }

    @PostMapping("/{Id}")
    ResponseEntity<?> addSV(@RequestBody List<Integer> input, @PathVariable Integer Id) { return new ResponseEntity<>(lopHocService.addSV(input, Id), HttpStatus.OK);}
    @PutMapping("/update_gv")
    ResponseEntity<?> updateGV(@RequestParam Integer id_lop, @RequestParam Integer id_gv) {
        return new ResponseEntity<>(lopHocService.updateGV(id_lop, id_gv), HttpStatus.OK);
    }
}
