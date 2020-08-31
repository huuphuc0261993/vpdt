package com.example.demo.service;

import com.example.demo.model.PhongBan;
import org.springframework.stereotype.Service;

@Service
public interface PhongBanService {
    Iterable<PhongBan>findAllByIsDeletedEquals(int isDeleted);
    void save(PhongBan phongBan);
}
