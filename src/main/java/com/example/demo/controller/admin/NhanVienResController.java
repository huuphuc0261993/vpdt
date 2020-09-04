package com.example.demo.controller.admin;

import com.example.demo.model.NhanVien;
import com.example.demo.model.PhongBan;
import com.example.demo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nhanvien")
public class NhanVienResController {
    @Autowired
    private NhanVienService nhanVienService;

    @RequestMapping(value = "/view/{id}",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<NhanVien>showView(@PathVariable("id")Long id){
        nhanVienService.listNhanVien(id);
        NhanVien nhanViens = nhanVienService.findById(id);
        if(nhanViens==null){
            return new ResponseEntity<NhanVien>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<NhanVien>(nhanViens,HttpStatus.OK);
        }
    }

}
