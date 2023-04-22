package com.example.demo.service.GiaoVien;

import com.example.demo.mapper.GiaoVienMapper;
import com.example.demo.model.dto.GiaoVienDto;
import com.example.demo.model.entity.GiaoVienEntity;
import com.example.demo.model.entity.LopHocEntity;
import com.example.demo.model.in.GiaoVienIn;
import com.example.demo.model.response.ResponseMessage;
import com.example.demo.repository.GiaoVienRepository;
import com.example.demo.repository.LopHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class GiaoVienService implements IGiaoVienService{
    @Autowired
    GiaoVienRepository giaoVienRepository;
    @Autowired
    LopHocRepository lopHocRepository;
    @Override
    public ResponseMessage get() {
        List<GiaoVienEntity> list = giaoVienRepository.getAll();
        List<GiaoVienDto> listDto = list.stream().map(GiaoVienMapper::MapEntity).collect(Collectors.toList());
        return new ResponseMessage(listDto, "da ve", null);
    }

    @Override
    public ResponseMessage add(GiaoVienIn input) {
        LopHocEntity lopHocEntity = lopHocRepository.getById(input.getId_lop());
//      Trước khi add giáo viên, cần kiểm tra xem lớp học mà mình định thêm giáo viên vào đã
//        có giáo viên nào chưa, nếu chưa có thì mình sẽ thêm giáo viên này vào lớp, còn có rồi
//        mình để giá trị là null (update tương tự)
        if(lopHocEntity.getGiaovien() != null) {
            if(lopHocEntity.getGiaovien().getId_gv() != null){
                giaoVienRepository.createTeacher(input.getName_gv(), input.getAge_gv(), null);
            }
        } else {
            giaoVienRepository.createTeacher(input.getName_gv(), input.getAge_gv(), input.getId_lop());
        }
        return new ResponseMessage("Add Success");
    }

    @Override
    public ResponseMessage update(GiaoVienIn input, Integer Id) {
        LopHocEntity lopHocEntity = lopHocRepository.getById(input.getId_lop());
        GiaoVienEntity giaoVienEntity = giaoVienRepository.getById(Id);
        giaoVienEntity.setName_gv(input.getName_gv());
        giaoVienEntity.setAge_gv(input.getAge_gv());
//
        if(lopHocEntity.getGiaovien() != null) {
            giaoVienRepository.updateTeacher(giaoVienEntity.getName_gv(), giaoVienEntity.getAge_gv(), null, giaoVienEntity.getId_gv());
        } else {
            giaoVienRepository.updateTeacher(giaoVienEntity.getName_gv(), giaoVienEntity.getAge_gv(), input.getId_lop(), giaoVienEntity.getId_gv());
        }
        return new ResponseMessage("Update Success");
    }

    @Override
    public ResponseMessage delete(Integer Id) {
        GiaoVienEntity giaoVienEntity = giaoVienRepository.getById(Id);
        giaoVienRepository.deleteTeacher(giaoVienEntity.getId_gv());
        return new ResponseMessage("Delete Success");
    }



}
