/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author vutu8
 */
public class SanPham {

    private Long idSanPham;
    private String maSanPham;
    private String tenSanpham;

    public SanPham() {
    }

    public SanPham(String maSanPham, String tenSanpham) {
        this.maSanPham = maSanPham;
        this.tenSanpham = tenSanpham;
    }

    public SanPham(String tenSanpham) {
        this.tenSanpham = tenSanpham;
    }

    public SanPham(Long idSanPham, String maSanPham, String tenSanpham) {
        this.idSanPham = idSanPham;
        this.maSanPham = maSanPham;
        this.tenSanpham = tenSanpham;
    }

    public SanPham(Long idSanPham) {
        this.idSanPham = idSanPham;   
    }
    
    public Long getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(Long idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanpham() {
        return tenSanpham;
    }

    public void setTenSanpham(String tenSanpham) {
        this.tenSanpham = tenSanpham;
    }

    @Override
    public String toString() {
        return  tenSanpham ;
    }

    
}
