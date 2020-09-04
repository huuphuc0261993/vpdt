package com.example.demo.repository;

import com.example.demo.model.NhanVien;
import com.example.demo.model.PhongBan;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface NhanVienRepository extends PagingAndSortingRepository<NhanVien,Long> {
    Iterable<NhanVien>findAllByIsDeletedEquals(int isDeleted);
    @Transactional
    @Modifying
    @Query(value = "select fullName from NhanViens WHERE phongBan_id = :phongBan_id", nativeQuery = true)
    void listNhanVien(@Param("phongBan_id")Long phongBan_id);
}
