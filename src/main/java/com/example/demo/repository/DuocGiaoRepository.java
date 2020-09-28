package com.example.demo.repository;

import com.example.demo.model.CongViec;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuocGiaoRepository extends PagingAndSortingRepository<CongViec,Long> {
}
