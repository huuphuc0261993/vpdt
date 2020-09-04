package com.example.demo.controller.admin;

import com.example.demo.service.CongViecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/taocongviec")
public class TaoCongViecResController {
    @Autowired
    private CongViecService congViecService;


}
