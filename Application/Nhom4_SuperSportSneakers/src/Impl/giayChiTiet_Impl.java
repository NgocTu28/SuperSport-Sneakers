/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Impl;

import Model.SanPhamChiTiet;
import Repository.SanPhamCT_Repository;
import Service.giayChiTiet_Service;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.Hashtable;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
    
/**
 *
 * @author vutu8
 */
public class giayChiTiet_Impl implements giayChiTiet_Service{
    SanPhamCT_Repository sanPhamChiTiet_Repo = new SanPhamCT_Repository();
    
    @Override
    public String exportQr(String pathFolder, String ma) {
        SanPhamChiTiet spct = (SanPhamChiTiet) sanPhamChiTiet_Repo.getProductByMa(ma);
        if (spct== null) {
            return "Không tìm thấy điện thoại";
        }
        DecimalFormat moneyFormat = new DecimalFormat("#,###");
//        String data = "Mã điện thoại: " + ctdt.getMaDienThoai()
//                + "\nIMEI: " + ctdt.getImei()
//                + "\nTên điện thoại: " + ctdt.getDienThoai()
//                + "\nHãng: " + ctdt.getHang()
//                + "\nMàu sắc: " + ctdt.getMauSac()
//                + "\nTình trạng: " + (ctdt.getTinhTrang() == 100 ? "Mới" : "Cũ - " + ctdt.getTinhTrang() + "%")
//                + "\nĐơn giá: " + moneyFormat.format(ctdt.getDonGia()) + "VNĐ"
//                + "\nRam: " + ctdt.getRam()
//                + "\nBộ nhớ: " + ctdt.getBoNho()
//                + "\nThời gian bảo hành: " + ctdt.getThoiGianBaoHanh() + " tháng"
//                + "\nTrạng thái: " + (ctdt.getTrangThai() == 0 ? "Đang bán" : ctdt.getTrangThai() == 1 ? "Đã bán" : ctdt.getTrangThai() == 2 ? "Sản phẩm lỗi" : "")
//                + (ctdt.getMoTa() == null ? "" : "\nMô tả: " + ctdt.getMoTa());

        String data = "Mã Giày Chi Tiết:" + spct.getMaSPCT()
                + "\n Tên Giày:" + spct.getIdSanPham().getTenSanpham()
                + "\n Tên Thương Hiệu:" + spct.getIdThuongHieu().getTenThuongHieu()
                + "\n Kích Thước:" + spct.getIdKichThuoc().getTenSize()
                + "\n Màu Sắc" + spct.getIdMau().getTenMau()
                +"\n Số Lượng Tồn" + spct.getSoLuong()
                +"\n Giá Bán" + spct.getGiaBan()
                +"\n Giá Niêm Yết" + spct.getGiaNiemYet()
                +(spct.getMoTa() == null ? "":"\n Mô Tả" + spct.getMoTa()) 
                +"\n Trạng Thái" + spct.getTrangThai();
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            Hashtable hints = new Hashtable();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix matrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 200, 200, hints);

            // Write to file image
            Path path = FileSystems.getDefault().getPath(pathFolder + "\\" + spct.getMaSPCT() + "-" + spct.getIdSanPham().getTenSanpham() + ".png");
            BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(matrix);
            MatrixToImageWriter.writeToPath(matrix, "PNG", path);
        } catch (Exception ex) {
            Logger.getLogger(giayChiTiet_Impl.class.getName()).log(Level.SEVERE, null, ex);
            return "Lỗi hệ thống. Không thể export";
        }
        return "Tải thành công";
    }
    
}
