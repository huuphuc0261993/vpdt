package com.example.demo.repository;

import com.example.demo.model.CongViec;
import com.example.demo.model.NhanVien;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CongViecRepository extends PagingAndSortingRepository<CongViec,Long> {
    Iterable<CongViec> findByIsDeletedEquals(Long id);

}
