package com.example.demo.service.impl;

import com.example.demo.model.CongViec;
import com.example.demo.repository.CongViecRepository;
import com.example.demo.service.CongViecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CongViecServiceImpl implements CongViecService {
    @Autowired
    private CongViecRepository congViecRepository;
    @Override
    public Iterable<CongViec> findByIsDeletedEquals(Long id) {
        return congViecRepository.findByIsDeletedEquals(id);
    }
}
