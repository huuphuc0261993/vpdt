package com.example.demo.service;

import com.example.demo.model.NhanVien;
import com.example.demo.model.PhongBan;
import com.example.demo.model.ThongBao;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NhanVienService {
    Iterable<NhanVien>findAllByIsDeletedEquals(int isDeleted);
    List<NhanVien> listNhanVien(@Param("mpb")Long mpb);
    NhanVien findById(Long id);
    List<NhanVien> nhanVienThucHien(@Param("mnv")Long mnv,@Param("phong_ban_id")Long phong_ban_id);
}
