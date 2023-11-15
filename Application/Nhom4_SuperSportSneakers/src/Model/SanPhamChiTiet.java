/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.math.BigDecimal;

public class SanPhamChiTiet {

    private Long idSPCT;
    private String maSPCT;
    private int soLuong;
    private BigDecimal giaBan;
    private BigDecimal giaNiemYet;
    private int TrangThai;
    private String moTa;
    private MauSac idMau;
    private KichThuoc idKichThuoc;
    private ThuongHieu idThuongHieu;
    private SanPham idSanPham;

    public SanPhamChiTiet() {
    }

    public SanPhamChiTiet(Long idSPCT, String maSPCT, int soLuong, BigDecimal giaBan, BigDecimal giaNiemYet, int TrangThai, String moTa, MauSac idMau, KichThuoc idKichThuoc, ThuongHieu idThuongHieu, SanPham idSanPham) {
        this.idSPCT = idSPCT;
        this.maSPCT = maSPCT;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.giaNiemYet = giaNiemYet;
        this.TrangThai = TrangThai;
        this.moTa = moTa;
        this.idMau = idMau;
        this.idKichThuoc = idKichThuoc;
        this.idThuongHieu = idThuongHieu;
        this.idSanPham = idSanPham;
    }

    public SanPhamChiTiet(String maSPCT, int soLuong, BigDecimal giaBan, BigDecimal giaNiemYet, int TrangThai, String moTa, MauSac idMau, KichThuoc idKichThuoc, ThuongHieu idThuongHieu, SanPham idSanPham) {
        this.maSPCT = maSPCT;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.giaNiemYet = giaNiemYet;
        this.TrangThai = TrangThai;
        this.moTa = moTa;
        this.idMau = idMau;
        this.idKichThuoc = idKichThuoc;
        this.idThuongHieu = idThuongHieu;
        this.idSanPham = idSanPham;
    }
    

    public Long getIdSPCT() {
        return idSPCT;
    }

    public void setIdSPCT(Long idSPCT) {
        this.idSPCT = idSPCT;
    }

    public String getMaSPCT() {
        return maSPCT;
    }

    public void setMaSPCT(String maSPCT) {
        this.maSPCT = maSPCT;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    public BigDecimal getGiaNiemYet() {
        return giaNiemYet;
    }

    public void setGiaNiemYet(BigDecimal giaNiemYet) {
        this.giaNiemYet = giaNiemYet;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public MauSac getIdMau() {
        return idMau;
    }

    public void setIdMau(MauSac idMau) {
        this.idMau = idMau;
    }

    public KichThuoc getIdKichThuoc() {
        return idKichThuoc;
    }

    public void setIdKichThuoc(KichThuoc idKichThuoc) {
        this.idKichThuoc = idKichThuoc;
    }

    public ThuongHieu getIdThuongHieu() {
        return idThuongHieu;
    }

    public void setIdThuongHieu(ThuongHieu idThuongHieu) {
        this.idThuongHieu = idThuongHieu;
    }

    public SanPham getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(SanPham idSanPham) {
        this.idSanPham = idSanPham;
    }

}
