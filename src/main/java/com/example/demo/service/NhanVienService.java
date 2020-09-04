package com.example.demo.service;

import com.example.demo.model.NhanVien;
import com.example.demo.model.PhongBan;
import com.example.demo.model.ThongBao;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface NhanVienService {
    Iterable<NhanVien>findAllByIsDeletedEquals(int isDeleted);
    void listNhanVien(@Param("phongBan_id")Long phongBan_id);
    NhanVien findById(Long id);
}
