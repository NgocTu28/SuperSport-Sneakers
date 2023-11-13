/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.SanPham;
import Model.SanPhamChiTiet;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SanPhamCT_Repository {

    Connection connect = DBConnection.getConnect();

    public List<SanPhamChiTiet> getToAll() {
        List<SanPhamChiTiet> listSanPhamChiTiet = new ArrayList<>();
        String query = "SELECT CTSP.MaCTSP, SP.TenSP,TH.TenThuongHieu,S.TenSize,M.TenMau,CTSP.SoLuongTon, CTSP.GiaBan, CTSP.GiaNiemYet, CTSP.MoTa, CTSP.Anh, CTSP.TrangThai FROM \n"
                + "    CHI_TIET_SAN_PHAM CTSP\n"
                + "JOIN \n"
                + "    SANPHAM SP ON CTSP.IdSP = SP.ID\n"
                + "JOIN \n"
                + "    THUONGHIEU TH ON CTSP.IdThuongHieu = TH.ID\n"
                + "JOIN \n"
                + "    MAU M ON CTSP.IdMau = M.ID\n"
                + "JOIN \n"
                + "    SIZE S ON CTSP.IdSize = S.ID ";

        try {
            PreparedStatement ps = connect.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listSanPhamChiTiet.add(new SanPhamChiTiet(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5), rs.getInt(6), rs.getBigDecimal(7), rs.getBigDecimal(8), rs.getString(9), rs.getString(10), rs.getInt(11)));
            }
        } catch (Exception e) {
            System.out.println("Error at get to all sanPhamCT");
        }
        System.out.println(listSanPhamChiTiet);
        return listSanPhamChiTiet;
    }

}
