/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package raven.application.form.other;

import Model.KichThuoc;
import Model.MauSac;
import Model.SanPham;
import Model.SanPhamChiTiet;
import Model.ThuongHieu;
import Repository.KichThuoc_Repository;
import Repository.MauSac_Reponsitory;
import Repository.SanPhamCT_Repository;
import Repository.SanPham_Repository;
import Repository.ThuongHieu_Repository;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author vutu8
 */
public class Form_SanPhamChiTiet extends javax.swing.JPanel {

    SanPham_Repository sanPham_Repository = new SanPham_Repository();
    SanPhamCT_Repository sanPhamCT_Repository = new SanPhamCT_Repository();
    MauSac_Reponsitory mauSac_Reponsitory = new MauSac_Reponsitory();
    KichThuoc_Repository kichThuoc_Repository = new KichThuoc_Repository();
    ThuongHieu_Repository hieu_Repository = new ThuongHieu_Repository();
    DefaultTableModel tblModel = new DefaultTableModel();
    List<SanPhamChiTiet> listSanPhamChiTiet = new ArrayList<>();

    public Form_SanPhamChiTiet() {
        initComponents();
        fillToCboTenSP();
        fillToCboMau();
        fillToCboKichThuoc();
        fillToCboThuongHieu();
        listSanPhamChiTiet = sanPhamCT_Repository.getToAll();
        fillToTable(listSanPhamChiTiet);
    }

    public void fillToTable(List<SanPhamChiTiet> listSanPhamChiTiet) {
        tblModel = (DefaultTableModel) tblSanPham.getModel();
        tblModel.setRowCount(0);
        int n = 1;
        for (SanPhamChiTiet i : listSanPhamChiTiet) {
            Object[] row = new Object[14];
            row[0] = n++;
            row[1] = i.getMaSPCT();
            row[2] = i.getTenSP();
            row[3] = i.getTenTH();
            row[4] = i.getSize();            
            row[5] = i.getMauSac();            
            row[6] = i.getGiaBan();            
            row[7] = i.getGiaNiemYet();                        
            row[8] = i.getTrangThai() == 0 ? "CÒN HÀNG" : (i.getTrangThai() == 1 ? "TẠM HẾT" : "DỪNG BÁN");         
            row[9] = i.getMoTa();
            row[10] = i.getSoLuongTon();
            tblModel.addRow(row);
        }
    }

    public void fillToCboTenSP() {
        List<SanPham> list = sanPham_Repository.getToAllSanPham();
        for (SanPham sanPham : list) {
            cbo_TenSP.addItem(sanPham.getTenSanpham());
        }
    }

    public void fillToCboMau() {
        List<MauSac> list = mauSac_Reponsitory.getToAllSanPham();
        for (MauSac ms : list) {
            cboMauSac.addItem(ms.getTenMau());
        }
    }

    public void fillToCboKichThuoc() {
        List<KichThuoc> list = kichThuoc_Repository.getToAllKichThuoc();
        for (KichThuoc kt : list) {
            cboKichThuoc.addItem(kt.getTenSize());
        }
    }

    public void fillToCboThuongHieu() {
        List<ThuongHieu> list = hieu_Repository.getToAll();
        for (ThuongHieu th : list) {
            cboHang.addItem(th.getTenThuongHieu());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lb = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbo_TenSP = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txt_MaSPCT = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cboMauSac = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cboKichThuoc = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cboHang = new javax.swing.JComboBox<>();
        btnAdd_MauSac = new javax.swing.JButton();
        btnAdd_KichThuoc = new javax.swing.JButton();
        btnAdd_Hang = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        txtGiaBan1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();

        lb.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("CHI TIẾT GIÀY");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Sitka Display", 3, 18)); // NOI18N
        jLabel1.setText("Tên Giày");

        cbo_TenSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_TenSPActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Sitka Display", 3, 18)); // NOI18N
        jLabel2.setText("Mã SPCT");

        txt_MaSPCT.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Sitka Display", 3, 18)); // NOI18N
        jLabel3.setText("Số Lượng");

        jLabel4.setFont(new java.awt.Font("Sitka Display", 3, 18)); // NOI18N
        jLabel4.setText("Giá Bán");

        jLabel5.setFont(new java.awt.Font("Sitka Display", 3, 18)); // NOI18N
        jLabel5.setText("Mô Tả");

        jLabel6.setFont(new java.awt.Font("Sitka Display", 3, 18)); // NOI18N
        jLabel6.setText("Màu Sắc");

        jLabel7.setFont(new java.awt.Font("Sitka Display", 3, 18)); // NOI18N
        jLabel7.setText("Kích Thước");

        jLabel8.setFont(new java.awt.Font("Sitka Display", 3, 18)); // NOI18N
        jLabel8.setText("Hãng");

        btnAdd_MauSac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add (2).png"))); // NOI18N

        btnAdd_KichThuoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add (2).png"))); // NOI18N

        btnAdd_Hang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add (2).png"))); // NOI18N

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane3.setViewportView(txtMoTa);

        jLabel11.setFont(new java.awt.Font("Sitka Display", 3, 18)); // NOI18N
        jLabel11.setText("Giá Niêm Yết");

        jLabel12.setFont(new java.awt.Font("Sitka Display", 3, 18)); // NOI18N
        jLabel12.setText("Trạng Thái");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn Hàng", "Tạm Hết", "Dừng Bán" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGiaBan1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbo_TenSP, javax.swing.GroupLayout.Alignment.LEADING, 0, 239, Short.MAX_VALUE)
                            .addComponent(txt_MaSPCT, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboMauSac, 0, 250, Short.MAX_VALUE)
                            .addComponent(cboKichThuoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd_MauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd_KichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd_Hang, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbo_TenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_MaSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtGiaBan1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAdd_MauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(cboKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnAdd_KichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(cboHang, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnAdd_Hang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton5.setBackground(new java.awt.Color(0, 102, 102));
        jButton5.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jButton5.setText("Thêm Sản Phẩm");

        jButton6.setBackground(new java.awt.Color(0, 102, 102));
        jButton6.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jButton6.setText("Cập Nhật Sản Phẩm");

        jButton7.setBackground(new java.awt.Color(0, 102, 102));
        jButton7.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jButton7.setText("Làm Mới");

        jButton8.setBackground(new java.awt.Color(0, 102, 102));
        jButton8.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jButton8.setText("Xuất File Excel");

        jButton9.setBackground(new java.awt.Color(0, 102, 102));
        jButton9.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jButton9.setText("Tải Mẫu Excel");

        jButton10.setBackground(new java.awt.Color(0, 102, 102));
        jButton10.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jButton10.setText("Import File Excel");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SPCT", "Tên Giày", "Hãng", "Size", "Màu Sắc", "Giá Bán", "Giá Niêm Yết", "Trạng Thái", "Mô Tả", "Số Lượng"
            }
        ));
        jScrollPane2.setViewportView(tblSanPham);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel10.setText("Danh sách sản phẩm chi tiết");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel9.setText("Tìm Kiếm");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel13.setText("Lọc Trạng Thái");

        jComboBox2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn Hàng", "Tạm Hết", "Dừng Bán" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1038, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbo_TenSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_TenSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_TenSPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd_Hang;
    private javax.swing.JButton btnAdd_KichThuoc;
    private javax.swing.JButton btnAdd_MauSac;
    private javax.swing.JComboBox<String> cboHang;
    private javax.swing.JComboBox<String> cboKichThuoc;
    private javax.swing.JComboBox<String> cboMauSac;
    private javax.swing.JComboBox<String> cbo_TenSP;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lb;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaBan1;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txt_MaSPCT;
    // End of variables declaration//GEN-END:variables
}
