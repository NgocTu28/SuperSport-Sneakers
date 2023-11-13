/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.KichThuoc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author vutu8
 */
public class KichThuoc_Repository {
     Connection connect = DBConnection.getConnect();

    public ArrayList<KichThuoc> getToAllKichThuoc() {
        ArrayList<KichThuoc> listKichThuoc = new ArrayList<>();
        String query = "Select MaSize, TenSize From SIZE";
        try {
            PreparedStatement ps = connect.prepareCall(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
               listKichThuoc.add(new KichThuoc(rs.getString(1), rs.getString(2)));
            }
        } catch (Exception e) {
            System.out.println("Error at get to all sanPham");
        }
        return listKichThuoc;
    }

    public String MaTuDong() {
        String ma = "KT";
        int newTotal = 0;

        try {
            PreparedStatement ps = connect.prepareCall("SELECT COUNT(*) FROM KICHTHUOC");
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

    public void addKichThuoc (KichThuoc kt) {
        
        String sql = "INSERT INTO SIZE(MaSize, TenSize) VALUES (?,?)";
        try {
            PreparedStatement ps = connect.prepareCall(sql);
            ps.setString(1, kt.getMaSize());
            ps.setString(2, kt.getTenSize());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateMauSac(KichThuoc kt, String ma) {
       
        String sql = "UPDATE SIZE set TenSize = ? where MaSize = ?";
        try {
            PreparedStatement ps = connect.prepareCall(sql);
            ps.setString(1, kt.getTenSize());
            ps.setString(2, ma);
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
