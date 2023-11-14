/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author vutu8
 */
public class MauSac {

    private Long idMau;
    private String maMau;
    private String tenMau;

    public MauSac() {
    }

    public MauSac(Long idMau) {
        this.idMau = idMau;   
    }
    
    public MauSac(Long idMau, String maMau, String tenMau) {
        this.idMau = idMau;
        this.maMau = maMau;
        this.tenMau = tenMau;
    }

    public MauSac(String tenMau) {
        this.tenMau = tenMau;
    }

    public Long getIdMau() {
        return idMau;
    }

    public void setIdMau(Long idMau) {
        this.idMau = idMau;
    }

    public String getMaMau() {
        return maMau;
    }

    public void setMaMau(String maMau) {
        this.maMau = maMau;
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
    }

    @Override
    public String toString() {
        return tenMau;
    }

    
}
