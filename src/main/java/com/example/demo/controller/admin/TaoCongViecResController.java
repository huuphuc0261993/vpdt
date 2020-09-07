package com.example.demo.controller.admin;

import com.example.demo.model.NhanVien;
import com.example.demo.model.ThongBao;
import com.example.demo.service.CongViecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/taocongviec")
public class TaoCongViecResController {
    @Autowired
    private CongViecService congViecService;



}
