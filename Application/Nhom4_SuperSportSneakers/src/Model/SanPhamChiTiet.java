/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.math.BigDecimal;

public class SanPhamChiTiet {

    private String maSPCT;
    private String tenSP;
    private String tenTH;
    private float size;
    private String mauSac;
    private int soLuongTon;
    private BigDecimal giaBan;
    private BigDecimal giaNiemYet;
    private String moTa;
    private String anh;
    private int trangThai;

    public SanPhamChiTiet() {
    }

    public SanPhamChiTiet(String maSPCT, String tenSP, String tenTH, float size, String mauSac, int soLuongTon, BigDecimal giaBan, BigDecimal giaNiemYet, String moTa, String anh, int trangThai) {
        this.maSPCT = maSPCT;
        this.tenSP = tenSP;
        this.tenTH = tenTH;
        this.size = size;
        this.mauSac = mauSac;
        this.soLuongTon = soLuongTon;
        this.giaBan = giaBan;
        this.giaNiemYet = giaNiemYet;
        this.moTa = moTa;
        this.anh = anh;
        this.trangThai = trangThai;
    }

    public String getMaSPCT() {
        return maSPCT;
    }

    public void setMaSPCT(String maSPCT) {
        this.maSPCT = maSPCT;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getTenTH() {
        return tenTH;
    }

    public void setTenTH(String tenTH) {
        this.tenTH = tenTH;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
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

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    
}
