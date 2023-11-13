/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SanPham_Repository {

    Connection connect = DBConnection.getConnect();

    public ArrayList<SanPham> getToAllSanPham() {
        ArrayList<SanPham> listSanPham = new ArrayList<>();
        String query = "Select MaSP, TenSP From SANPHAM";
        try {
            PreparedStatement ps = connect.prepareCall(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listSanPham.add(new SanPham(rs.getString(1), rs.getString(2)));
            }
        } catch (Exception e) {
            System.out.println("Error at get to all sanPham");
        }
        return listSanPham;
    }

    public void addSanPham(SanPham sp) {
        Connection con = DBConnection.getConnect();
        String sql = "INSERT INTO SANPHAM (MaSP, TenSP) VALUES (?,?)";
        try {
            PreparedStatement ps = connect.prepareCall(sql);
            ps.setString(1, sp.getMaSanPham());
            ps.setString(2, sp.getTenSanpham());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<SanPham> search_SanPham(String text) {
        ArrayList<SanPham> listSearch = new ArrayList<>();
        String query = "SELECT MaSP, TenSP FROM SANPHAM WHERE MaSP = ? OR TenSP = ?";
        try {
            PreparedStatement ps = connect.prepareCall(query);
            ps.setString(1, text);
            ps.setString(2, text);
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listSearch;
    }

     public Boolean check(String ma){
       String sql = "Select * From SANPHAM Where MaSP = ?";
        try {
            PreparedStatement pstm = connect.prepareCall(sql);
            pstm.setString(1,ma);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {                
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error at check");
            return false;
        }
        return false;
   }
}
