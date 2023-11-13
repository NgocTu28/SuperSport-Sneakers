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
    private String maSanPham;
    private String tenSanpham;

    public SanPham() {
    }

    public SanPham(String maSanPham, String tenSanpham) {
        this.maSanPham = maSanPham;
        this.tenSanpham = tenSanpham;
    }

    public String getTenSanpham() {
        return tenSanpham;
    }

    public void setTenSanpham(String tenSanpham) {
        this.tenSanpham = tenSanpham;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }
    
  
}
