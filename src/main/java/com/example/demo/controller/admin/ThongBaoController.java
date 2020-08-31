package com.example.demo.controller.admin;

import com.example.demo.model.ThongBao;
import com.example.demo.service.ThongBaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/thongbao")
public class ThongBaoController {

    @Autowired
    private ThongBaoService thongBaoService;

    @GetMapping("")
    public ModelAndView getView() {
        Iterable<ThongBao> thongBaos = thongBaoService.findAllByIsDeletedEquals(0);
        ModelAndView modelAndView = new ModelAndView("admin/thongBao/ThongBao");
        modelAndView.addObject("thongBaos", thongBaos);
        modelAndView.addObject("thongBao", new ThongBao());
        return modelAndView;
    }

    @PostMapping(value = "", produces = "application/json;charset=UTF-8")
    public ModelAndView create(@ModelAttribute("thongBao") ThongBao thongBao) {
        thongBaoService.save(thongBao);
        return new ModelAndView("redirect:/admin/thongbao");
    }

}
