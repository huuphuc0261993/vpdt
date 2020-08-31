package com.example.demo.controller.admin;

import com.example.demo.model.PhongBan;
import com.example.demo.service.PhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/phongban")
public class PhongBanController {

    @Autowired
    private PhongBanService phongBanService;

    @GetMapping("")
    public ModelAndView getView() {
        Iterable<PhongBan> phongBans = phongBanService.findAllByIsDeletedEquals(0);
        ModelAndView modelAndView = new ModelAndView("admin/phongBan/PhongBan");
        modelAndView.addObject("phongBans", phongBans);
        modelAndView.addObject("phongBan", new PhongBan());
        return modelAndView;
    }

    @PostMapping(value = "", produces = "application/json;charset=UTF-8")
    public ModelAndView create(@ModelAttribute("phongBan") PhongBan phongBan) {
        phongBanService.save(phongBan);
        return new ModelAndView("redirect:/admin/phongban");
    }

}
