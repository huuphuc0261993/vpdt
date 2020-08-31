package com.example.demo.controller.admin;

import com.example.demo.model.PhongBan;
import com.example.demo.model.ThongBao;
import com.example.demo.service.PhongBanService;
import com.example.demo.service.ThongBaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Pageable;

@RestController
@RequestMapping("/adminJS/phongban")
public class PhongBanResController {
    @Autowired
    PhongBanService phongBanService;

    @RequestMapping(value = "/text", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Iterable<PhongBan>> showView() {
        Iterable<PhongBan> phongBans = phongBanService.findAllByIsDeletedEquals(0);
        if (phongBans == null) {
            return new ResponseEntity<Iterable<PhongBan>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Iterable<PhongBan>>(phongBans, HttpStatus.OK);
    }

}
