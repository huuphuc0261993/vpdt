package com.example.demo.repository;

import com.example.demo.model.ThongBao;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface ThongBaoRepository extends PagingAndSortingRepository<ThongBao,Long> {
    Iterable<ThongBao>findAllByIsDeletedEquals(int isDeleted);

}
