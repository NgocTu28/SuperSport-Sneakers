/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.ThuongHieu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author vutu8
 */
public class ThuongHieu_Repository {

    Connection connect = DBConnection.getConnect();

    public ArrayList<ThuongHieu> getToAll() {
        ArrayList<ThuongHieu> list = new ArrayList<>();
        String query = "Select MaThuongHieu, TenThuongHieu From THUONGHIEU";
        try {
            PreparedStatement ps = connect.prepareCall(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new ThuongHieu(rs.getString(1), rs.getString(2)));
            }
        } catch (Exception e) {
            System.out.println("Error at get to all sanPham");
        }
        return list;
    }

    public String MaTuDong() {
        String ma = "TH";
        int newTotal = 0;

        try {
            PreparedStatement ps = connect.prepareCall("SELECT COUNT(*) FROM THUONGHIEU");
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

    public void addKichThuoc(ThuongHieu th) {
        
        String sql = "INSERT INTO SIZE(MaThuongHieu, TenThuongHieu) VALUES (?,?)";
        try {
            PreparedStatement ps = connect.prepareCall(sql);
            ps.setString(1, th.getMaThuongHieu());
            ps.setString(2, th.getTenThuongHieu());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateMauSac(ThuongHieu th, String ma) {
        
        String sql = "UPDATE THUONGHIEU set TenThuongHieu = ? where MaThuongHieu = ?";
        try {
            PreparedStatement ps = connect.prepareCall(sql);
            ps.setString(1, th.getTenThuongHieu());
            ps.setString(2, ma);
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
