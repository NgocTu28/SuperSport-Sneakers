/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.KichThuoc;
import Model.MauSac;
import Model.SanPham;
import Model.SanPhamChiTiet;
import Model.ThuongHieu;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SanPhamCT_Repository {

    Connection connect = DBConnection.getConnect();

    public List<SanPhamChiTiet> getToAll() {
        List<SanPhamChiTiet> list = new ArrayList<>();
        String sql = "select  CTSP.ID,CTSP.MaCTSP,SP.TenSP,TH.TenThuongHieu,S.TenSize,M.TenMau,CTSP.SoLuongTon, CTSP.GiaBan, CTSP.GiaNiemYet, CTSP.MoTa, CTSP.TrangThai , CTSP.ID as ID from CHI_TIET_SAN_PHAM as CTSP\n"
                + "join MAU as M on M.ID = CTSP.IdMau\n"
                + "join SIZE as S on S.ID = CTSP.IdSize\n"
                + "join THUONGHIEU as TH on TH.ID = CTSP.IdThuongHieu\n"
                + "join SANPHAM as SP on SP.ID = CTSP.IdSP\n";

        try {
            PreparedStatement pstm = connect.prepareCall(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham(rs.getString("TenSP"));
                MauSac mauSac = new MauSac(rs.getString("TenMau"));
                ThuongHieu thuongHieu = new ThuongHieu(rs.getString("TenThuongHieu"));
                KichThuoc kichThuoc = new KichThuoc(rs.getString("TenSize"));

                SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet(rs.getLong("ID"), rs.getString("MaCTSP"), rs.getInt("SoLuongTon"), rs.getBigDecimal("GiaBan"), rs.getBigDecimal("GiaNiemYet"), rs.getInt("TrangThai"), rs.getString("MoTa"), mauSac, kichThuoc, thuongHieu, sanPham);
                list.add(sanPhamChiTiet);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<SanPhamChiTiet> search_SanPhamChiTiet(String text) {
        List<SanPhamChiTiet> listSearch = new ArrayList<>();
        String query = "select  CTSP.ID,CTSP.MaCTSP,SP.TenSP,TH.TenThuongHieu,S.TenSize,M.TenMau,CTSP.SoLuongTon, CTSP.GiaBan, CTSP.GiaNiemYet, CTSP.MoTa, CTSP.TrangThai , CTSP.ID as ID from CHI_TIET_SAN_PHAM as CTSP\n"
                + "join MAU as M on M.ID = CTSP.IdMau\n"
                + "join SIZE as S on S.ID = CTSP.IdSize\n"
                + "join THUONGHIEU as TH on TH.ID = CTSP.IdThuongHieu\n"
                + "join SANPHAM as SP on SP.ID = CTSP.IdSP\n"
                + "WHERE MACTSP like ? OR TenSP like ? OR TenThuongHieu like ?";
        try {
            PreparedStatement ps = connect.prepareCall(query);
            ps.setString(1, "%" + text + "%");
            ps.setString(2, "%" + text + "%");
            ps.setString(3, "%" + text + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham(rs.getString("TenSP"));
                MauSac mauSac = new MauSac(rs.getString("TenMau"));
                ThuongHieu thuongHieu = new ThuongHieu(rs.getString("TenThuongHieu"));
                KichThuoc kichThuoc = new KichThuoc(rs.getString("TenSize"));

                SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet(rs.getLong("ID"), rs.getString("MaCTSP"), rs.getInt("SoLuongTon"), rs.getBigDecimal("GiaBan"), rs.getBigDecimal("GiaNiemYet"), rs.getInt("TrangThai"), rs.getString("MoTa"), mauSac, kichThuoc, thuongHieu, sanPham);
                listSearch.add(sanPhamChiTiet);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listSearch;
    }

    public List<SanPhamChiTiet> searchTrangThai_SanPhamChiTiet(int n) {
        List<SanPhamChiTiet> listSearch = new ArrayList<>();
        String query = "select  CTSP.ID,CTSP.MaCTSP,SP.TenSP,TH.TenThuongHieu,S.TenSize,M.TenMau,CTSP.SoLuongTon, CTSP.GiaBan, CTSP.GiaNiemYet, CTSP.MoTa, CTSP.TrangThai , CTSP.ID as ID from CHI_TIET_SAN_PHAM as CTSP\n"
                + "join MAU as M on M.ID = CTSP.IdMau\n"
                + "join SIZE as S on S.ID = CTSP.IdSize\n"
                + "join THUONGHIEU as TH on TH.ID = CTSP.IdThuongHieu\n"
                + "join SANPHAM as SP on SP.ID = CTSP.IdSP\n"
                + "WHERE CTSP.TrangThai = ?";
        try {
            PreparedStatement ps = connect.prepareCall(query);
            ps.setInt(1, n);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham(rs.getString("TenSP"));
                MauSac mauSac = new MauSac(rs.getString("TenMau"));
                ThuongHieu thuongHieu = new ThuongHieu(rs.getString("TenThuongHieu"));
                KichThuoc kichThuoc = new KichThuoc(rs.getString("TenSize"));

                SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet(rs.getLong("ID"), rs.getString("MaCTSP"), rs.getInt("SoLuongTon"), rs.getBigDecimal("GiaBan"), rs.getBigDecimal("GiaNiemYet"), rs.getInt("TrangThai"), rs.getString("MoTa"), mauSac, kichThuoc, thuongHieu, sanPham);
                listSearch.add(sanPhamChiTiet);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listSearch;
    }

    public List<SanPhamChiTiet> get(int page, int limt) {
        List<SanPhamChiTiet> list = new ArrayList<>();
        String sql = "SELECT CTSP.ID, CTSP.MaCTSP, SP.TenSP, TH.TenThuongHieu, S.TenSize, M.TenMau, CTSP.SoLuongTon, CTSP.GiaBan, CTSP.GiaNiemYet, CTSP.MoTa, CTSP.TrangThai\n"
                + "FROM CHI_TIET_SAN_PHAM as CTSP\n"
                + "JOIN MAU as M on M.ID = CTSP.IdMau\n"
                + "JOIN SIZE as S on S.ID = CTSP.IdSize\n"
                + "JOIN THUONGHIEU as TH on TH.ID = CTSP.IdThuongHieu\n"
                + "JOIN SANPHAM as SP on SP.ID = CTSP.IdSP\n"
                + "ORDER BY CTSP.ID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY;";

        try {
            PreparedStatement pstm = connect.prepareStatement(sql);
            // Công thức chỉ cần ghi như vậy
            pstm.setInt(1, (page - 1) * limt);
            pstm.setInt(2, limt);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham(rs.getString("TenSP"));
                MauSac mauSac = new MauSac(rs.getString("TenMau"));
                ThuongHieu thuongHieu = new ThuongHieu(rs.getString("TenThuongHieu"));
                KichThuoc kichThuoc = new KichThuoc(rs.getString("TenSize"));
                SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet(rs.getLong("ID"), rs.getString("MaCTSP"), rs.getInt("SoLuongTon"), rs.getBigDecimal("GiaBan"), rs.getBigDecimal("GiaNiemYet"), rs.getInt("TrangThai"), rs.getString("MoTa"), mauSac, kichThuoc, thuongHieu, sanPham);
                list.add(sanPhamChiTiet);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
// Đếm tổng số bản ghi 

    public int getRowCount() {
        String query = "SELECT COUNT(*) AS totalRows FROM KHACHHANG";

        try {
            PreparedStatement pstm = connect.prepareCall(query);
            ResultSet rs = pstm.executeQuery();
            int totalRows = 0;
            if (rs.next()) {
                return totalRows = rs.getInt("totalRows");
            }
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamCT_Repository.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public void insertSPCT(SanPhamChiTiet spct) {
        String query = " Insert  into CHI_TIET_SAN_PHAM (IdSP,IdThuongHieu,IdMau,IdSize,MaCTSP,SoLuongTon,GiaNiemYet,GiaBan,MoTa,TrangThai) Values (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = connect.prepareCall(query);
            pstm.setLong(1, spct.getIdSanPham().getIdSanPham());
            pstm.setLong(2, spct.getIdThuongHieu().getIdThuongHieu());
            pstm.setLong(3, spct.getIdMau().getIdMau());
            pstm.setLong(4, spct.getIdKichThuoc().getIdSize());
            pstm.setString(5, spct.getMaSPCT());
            pstm.setInt(6, spct.getSoLuong());
            pstm.setBigDecimal(7, spct.getGiaNiemYet());
            pstm.setBigDecimal(8, spct.getGiaBan());
            pstm.setString(9, spct.getMoTa());
            pstm.setInt(10, spct.getTrangThai());

            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateSPCT(SanPhamChiTiet spct, String maCTSP) {
        String query = " UPDATE CHI_TIET_SAN_PHAM  set SoLuongTon = ?,GiaNiemYet = ?,GiaBan = ?,MoTa = ?,TrangThai=? WHERE MaCTSP = ?";
        try {
            PreparedStatement pstm = connect.prepareCall(query);

            pstm.setInt(1, spct.getSoLuong());
            pstm.setBigDecimal(2, spct.getGiaNiemYet());
            pstm.setBigDecimal(3, spct.getGiaBan());
            pstm.setString(4, spct.getMoTa());
            pstm.setInt(5, spct.getTrangThai());
            pstm.setString(6, maCTSP);
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
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

    public SanPhamChiTiet getProductByMa(String ma) {
        SanPhamChiTiet result = null;
        String sql = "select CTSP.ID,CTSP.MaCTSP,SP.TenSP,TH.TenThuongHieu,S.TenSize,M.TenMau,CTSP.SoLuongTon, CTSP.GiaBan, CTSP.GiaNiemYet, CTSP.MoTa, CTSP.TrangThai  from CHI_TIET_SAN_PHAM as CTSP\n"
                + "join MAU as M on M.ID = CTSP.IdMau\n"
                + "join SIZE as S on S.ID = CTSP.IdSize\n"
                + "join THUONGHIEU as TH on TH.ID = CTSP.IdThuongHieu\n"
                + "join SANPHAM as SP on SP.ID = CTSP.IdSP\n"
                + "WHERE CTSP.MaCTSP = ?";

        try {
            PreparedStatement pstm = connect.prepareCall(sql);
            pstm.setString(1, ma);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                SanPham sanPham = new SanPham(rs.getString("TenSP"));
                MauSac mauSac = new MauSac(rs.getString("TenMau"));
                ThuongHieu thuongHieu = new ThuongHieu(rs.getString("TenThuongHieu"));
                KichThuoc kichThuoc = new KichThuoc(rs.getString("TenSize"));

                result = new SanPhamChiTiet(rs.getLong("ID"), rs.getString("MaCTSP"), rs.getInt("SoLuongTon"), rs.getBigDecimal("GiaBan"), rs.getBigDecimal("GiaNiemYet"), rs.getInt("TrangThai"), rs.getString("MoTa"), mauSac, kichThuoc, thuongHieu, sanPham);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

}
