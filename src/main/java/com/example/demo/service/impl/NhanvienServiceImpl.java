package com.example.demo.service.impl;

import com.example.demo.model.NhanVien;
import com.example.demo.model.PhongBan;
import com.example.demo.repository.NhanVienRepository;
import com.example.demo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NhanvienServiceImpl implements NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Override
    public Iterable<NhanVien> findAllByIsDeletedEquals(int isDeleted) {
        return nhanVienRepository.findAllByIsDeletedEquals(0);
    }

    @Override
    public void listNhanVien(Long phongBan_id) {
        nhanVienRepository.listNhanVien(phongBan_id);
    }

    @Override
    public NhanVien findById(Long id) {
        return nhanVienRepository.findById(id).orElse(null);
    }

}
