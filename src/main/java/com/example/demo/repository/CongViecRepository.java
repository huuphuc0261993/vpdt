package com.example.demo.repository;

import com.example.demo.model.CongViec;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CongViecRepository extends PagingAndSortingRepository<CongViec,Long> {
    Iterable<CongViec> findByIsDeletedEquals(Long id);
}
