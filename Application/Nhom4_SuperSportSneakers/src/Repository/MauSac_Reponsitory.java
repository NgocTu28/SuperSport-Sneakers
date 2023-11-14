/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.MauSac;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author vutu8
 */
public class MauSac_Reponsitory {

    Connection connect = DBConnection.getConnect();

    public ArrayList<MauSac> getToAllSanPham() {
        ArrayList<MauSac> listMauSac = new ArrayList<>();
        String query = "Select ID,MaMau, TenMau From MAU";
        try {
            PreparedStatement ps = connect.prepareCall(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listMauSac.add(new MauSac(rs.getLong(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listMauSac;
    }

    public String MaTuDong() {
        String ma = "MAU";
        int newTotal = 0;

        try {
            PreparedStatement ps = connect.prepareCall("SELECT COUNT(*) FROM MAU");
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

    public void addMauSac(MauSac ms) {
        
        String sql = "INSERT INTO MAU(MaMau, TenMau) VALUES (?,?)";
        try {
            PreparedStatement ps = connect.prepareCall(sql);
            ps.setString(1, ms.getMaMau());
            ps.setString(2, ms.getTenMau());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateMauSac(MauSac ms, String ma) {
        
        String sql = "UPDATE SANPHAM set TenMau = ? where MaMau = ?";
        try {
            PreparedStatement ps = connect.prepareCall(sql);
            ps.setString(1, ms.getTenMau());
            ps.setString(2, ma);
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
