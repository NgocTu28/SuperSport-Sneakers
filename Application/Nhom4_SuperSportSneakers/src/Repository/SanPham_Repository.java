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

    public String MaTuDongSanPham() {
        String ma = "SP";
        int newTotal = 0;

        try {
            PreparedStatement ps = connect.prepareCall("SELECT COUNT(*) FROM SANPHAM");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                newTotal = rs.getInt(1) + 1;
            }

            // Sử dụng vòng lặp for để tạo mã sản phẩm tự động
            String[] prefixes = {"0000", "000", "00", "0"};
            int index = 0;

            for (int limit : new int[]{10, 100, Integer.MAX_VALUE}) {
                if (newTotal < limit) {
                    ma = ma + prefixes[index] + newTotal;
                    break;
                }
                index++;
            }

        } catch (Exception e) {
            System.out.println("Error at Key");
        }

        return ma;
    }

    public void addSanPham(SanPham sp) {

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

    public void updateSanPham(SanPham sp, String ma) {

        String sql = "UPDATE SANPHAM set TenSP = ? where MaSP = ?";
        try {
            PreparedStatement ps = connect.prepareCall(sql);
            ps.setString(1, sp.getTenSanpham());
            ps.setString(2, ma);
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<SanPham> search_SanPham(String text) {
        List<SanPham> listSearch = new ArrayList<>();
        String query = "SELECT MaSP, TenSP FROM SANPHAM WHERE MaSP LIKE ? OR TenSP LIKE ?";
        try {
            PreparedStatement ps = connect.prepareCall(query);
            ps.setString(1, "%" + text + "%");
            ps.setString(2, "%" + text + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listSearch.add(new SanPham(rs.getString(1), rs.getString(2)));
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while searching for SanPham", e);
        }
        return listSearch;
    }

    public Boolean check(String ma) {
        String sql = "Select * From SANPHAM Where MaSP = ?";
        try {
            PreparedStatement pstm = connect.prepareCall(sql);
            pstm.setString(1, ma);
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
