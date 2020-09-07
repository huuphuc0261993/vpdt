package com.example.demo.controller.admin;

import com.example.demo.model.NhanVien;
import com.example.demo.model.PhongBan;
import com.example.demo.model.ThongBao;
import com.example.demo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/nhanvien")
public class NhanVienResController {
    @Autowired
    private NhanVienService nhanVienService;

    @RequestMapping(value = "/view/{id}",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<NhanVien> showView(@PathVariable("id")Long id){
        List<NhanVien>nhanViens=nhanVienService.listNhanVien(id);
        return nhanViens;
    }
    @RequestMapping(value = "/{idPhongBan}/{idNhanVien}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<NhanVien> getListNhanVien(@PathVariable("idPhongBan") long idPhongBan,@PathVariable("idNhanVien") long idNhanVien) {
        List<NhanVien> listNhanVien = nhanVienService.nhanVienThucHien(idPhongBan,idNhanVien);
        return listNhanVien;
    }
}
