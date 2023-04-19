package com.example.demo.service.LopHoc;

import com.example.demo.model.in.GiaoVienIn;
import com.example.demo.model.in.LopHocIn;
import com.example.demo.model.in.SinhVienIn;
import com.example.demo.model.response.ResponseMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILopHocService {
    ResponseMessage get();
    ResponseMessage add(LopHocIn input);
    ResponseMessage update(LopHocIn input, Integer Id);
    ResponseMessage delete(Integer Id);
//    ResponseMessage addSV(SinhVienIn input, Integer Id);
    ResponseMessage addSV(List<Integer> input, Integer Id);
}
