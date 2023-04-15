package com.example.demo.service.GiaoVien;

import com.example.demo.model.in.GiaoVienIn;
import com.example.demo.model.response.ResponseMessage;
import com.example.demo.model.entity.GiaoVienEntity;
import com.example.demo.model.in.SinhVienIn;
import org.springframework.stereotype.Service;

@Service
public interface IGiaoVienService {
    ResponseMessage get();
    ResponseMessage add(GiaoVienIn input);
    ResponseMessage update(GiaoVienIn input, Integer Id);
    ResponseMessage delete(Integer Id);
}
