package com.example.demo.controller.user.rest;

import com.example.demo.model.NhanVien;
import com.example.demo.service.DuocGiaoService;
import com.example.demo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/duocgiao")
public class DuocGiaoResController {
    @Autowired
    private DuocGiaoService duocGiaoService;

//    @RequestMapping(value = "/view/{id}",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
//    public ResponseEntity<List<NhanVien>> showView(@PathVariable("id")Long id){
//
//        }
//        return new ResponseEntity<List<NhanVien>>(nhanVienList, HttpStatus.OK);
//    }

}
