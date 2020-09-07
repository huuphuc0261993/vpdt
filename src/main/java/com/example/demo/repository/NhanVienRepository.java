package com.example.demo.repository;

import com.example.demo.model.NhanVien;
import com.example.demo.model.PhongBan;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface NhanVienRepository extends PagingAndSortingRepository<NhanVien,Long> {
    Iterable<NhanVien>findAllByIsDeletedEquals(int isDeleted);

    @Transactional
    @Modifying
    @Query(value = "select nhan_viens.* from phong_bans inner join nhan_viens on phong_bans.mpb = nhan_viens.phong_ban_id  WHERE mpb = :mpb", nativeQuery = true)
    List<NhanVien> listNhanVien(@Param("mpb")Long mpb);

    @Transactional
    @Modifying
    @Query(value = "select nhan_viens.* from phong_bans inner join nhan_viens on phong_bans.mpb = nhan_viens.phong_ban_id where mnv =: mnv and phong_ban_id =: phong_ban_id", nativeQuery = true)
    List<NhanVien> nhanVienThucHien(@Param("mnv")Long mnv,@Param("phong_ban_id")Long phong_ban_id);
}
