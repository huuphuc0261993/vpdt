package com.example.demo.service;

import com.example.demo.model.CongViec;
import org.springframework.stereotype.Service;

@Service
public interface CongViecService {
    Iterable<CongViec> findByIsDeletedEquals(Long id);
}
