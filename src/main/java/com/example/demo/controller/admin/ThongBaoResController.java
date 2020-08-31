package com.example.demo.controller.admin;

import com.example.demo.model.ThongBao;
import com.example.demo.service.ThongBaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Pageable;

@RestController
@RequestMapping("/adminJS/thongbao")
public class ThongBaoResController {
    @Autowired
    ThongBaoService thongBaoService;

    @RequestMapping(value = "/text", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Iterable<ThongBao>> showView() {
        Iterable<ThongBao> thongBaos = thongBaoService.findAllByIsDeletedEquals(0);
        if (thongBaos == null) {
            return new ResponseEntity<Iterable<ThongBao>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Iterable<ThongBao>>(thongBaos, HttpStatus.OK);
    }

}
