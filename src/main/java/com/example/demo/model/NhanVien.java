package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "NhanViens")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mnv;
    private String fullName;
    private String email;
    private int phone;
    private String avatar;

    @OneToMany (mappedBy = "nhanVien")
    @JsonIgnore
    private List<HoSo> hoSos;

    @OneToMany (mappedBy = "nhanVien")
    @JsonIgnore
    private List<ChiTiet> chiTiets;

    @OneToMany(mappedBy = "nhanVien")
    @JsonIgnore
    private List<VanBan>vanBans;

    @ManyToOne
    @JoinColumn(name = "phongBan_id")
    private PhongBan phongBan;

    @JsonIgnore
    private int isDeleted=0;
    @JsonIgnore
    private LocalDate deleted_at;
    @JsonIgnore
    private String deleted_by;
    @JsonIgnore
    private LocalDate  updated_at;
    @JsonIgnore
    private String updated_by;
    @JsonIgnore
    private LocalDate created_at;
    @JsonIgnore
    private String created_by;

    public NhanVien() {
    }

    public NhanVien(Long mnv, String fullName, String email, int phone, String avatar) {
        this.mnv = mnv;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.avatar = avatar;
    }

    public Long getMnv() {
        return mnv;
    }

    public void setMnv(Long mnv) {
        this.mnv = mnv;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<HoSo> getHoSos() {
        return hoSos;
    }

    public void setHoSos(List<HoSo> hoSos) {
        this.hoSos = hoSos;
    }

    public List<ChiTiet> getChiTietCongViecs() {
        return chiTiets;
    }

    public void setChiTietCongViecs(List<ChiTiet> chiTiets) {
        this.chiTiets = chiTiets;
    }

    public List<VanBan> getVanBans() {
        return vanBans;
    }

    public void setVanBans(List<VanBan> vanBans) {
        this.vanBans = vanBans;
    }

    public PhongBan getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PhongBan phongBan) {
        this.phongBan = phongBan;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public LocalDate getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(LocalDate deleted_at) {
        this.deleted_at = deleted_at;
    }

    public String getDeleted_by() {
        return deleted_by;
    }

    public void setDeleted_by(String deleted_by) {
        this.deleted_by = deleted_by;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
}
