/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author vutu8
 */
public class KichThuoc {

    private Long idSize;
    private String maSize;
    private String tenSize;
    private int trangThai;

    public KichThuoc() {
    }

    public KichThuoc(Long idSize, String maSize, String tenSize, int trangThai) {
        this.idSize = idSize;
        this.maSize = maSize;
        this.tenSize = tenSize;
        this.trangThai = trangThai;
    }

    public KichThuoc(String maSize, String tenSize, int trangThai) {
        this.maSize = maSize;
        this.tenSize = tenSize;
        this.trangThai = trangThai;
    }

    public KichThuoc(Long idSize) {
        this.idSize = idSize;
    }

    public KichThuoc(Long idSize, String maSize, String tenSize) {
        this.idSize = idSize;
        this.maSize = maSize;
        this.tenSize = tenSize;
    }

    public KichThuoc(String tenSize) {
        this.tenSize = tenSize;
    }

    public Long getIdSize() {
        return idSize;
    }

    public void setIdSize(Long idSize) {
        this.idSize = idSize;
    }

    public String getMaSize() {
        return maSize;
    }

    public void setMaSize(String maSize) {
        this.maSize = maSize;
    }

    public String getTenSize() {
        return tenSize;
    }

    public void setTenSize(String tenSize) {
        this.tenSize = tenSize;
    }

    @Override
    public String toString() {
        return tenSize + "";
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

}
