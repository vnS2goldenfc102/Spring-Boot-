package com.example.demo.service.SinhVien;

import com.example.demo.model.response.ResponseMessage;
import com.example.demo.model.entity.SinhVienEntity;
import com.example.demo.model.in.SinhVienIn;
import org.springframework.stereotype.Service;

@Service
public interface ISinhVienService {
    ResponseMessage get();
    ResponseMessage add(SinhVienIn input);
    ResponseMessage update(SinhVienIn input, Integer Id);
    ResponseMessage delete(Integer Id);
}
