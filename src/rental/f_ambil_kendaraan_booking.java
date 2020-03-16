/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rental;

import backend.data_ambil_kendaraan_booking;
import backend.data_pengembalian_motor;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Abiyyuoo
 */
public class f_ambil_kendaraan_booking extends javax.swing.JFrame {
    
    /**
     * Creates new form f_ambil_kendaraan_booking
     */
    public f_ambil_kendaraan_booking() {
        initComponents();
    }
//    public void tampilkanData() {
//        String[] kolom = {"id transaksi", "id_detail", "nama customer", "tanggal sewa", "tanggal kembali", "jenis motor", "jaminan","status"};
//        ArrayList<data_ambil_kendaraan_booking> list = new data_ambil_kendaraan_booking().getAll();
//        Object rowData[] = new Object[8];
//        tbl_transaksi.setModel(new DefaultTableModel(new Object[][]{}, kolom));
//        for (data_ambil_kendaraan_booking dpm : list) {
//            rowData[0] = dpm.getId_transaksi();
//            rowData[1] = dpm.getId_detail();
//            rowData[2] = dpm.getNama_customer();
//            rowData[3] = dpm.getTgl_sewa();
//            rowData[4] = dpm.getTgl_kembali();
//            rowData[5] = dpm.getJenis_motor();
//            rowData[6] = dpm.getJaminan();
//            rowData[7] = dpm.getStatus();
//            ((DefaultTableModel) tbl_transaksi.getModel()).addRow(rowData);
//        } 
//    }

    public void cari(String nama) {
        String[] kolom = {"id transaksi", "id_detail", "nama customer", "tanggal sewa", "tanggal kembali", "jenis motor", "jaminan","status"};
        ArrayList<data_ambil_kendaraan_booking> list = new data_ambil_kendaraan_booking().search(nama);
        Object rowData[] = new Object[8];
        tbl_transaksi.setModel(new DefaultTableModel(new Object[][]{}, kolom));
        for (data_ambil_kendaraan_booking dpm : list) {
            rowData[0] = dpm.getId_transaksi();
            rowData[1] = dpm.getId_detail();
            rowData[2] = dpm.getNama_customer();
            rowData[3] = dpm.getTgl_sewa();
            rowData[4] = dpm.getTgl_kembali();
            rowData[5] = dpm.getJenis_motor();
            rowData[6] = dpm.getJaminan();
            rowData[7] = dpm.getStatus();
            ((DefaultTableModel) tbl_transaksi.getModel()).addRow(rowData);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_nama = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_id_detail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_cari = new javax.swing.JTextField();
        btn_cari = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_used = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_transaksi = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txt_nama.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txt_nama.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setText("NAMA");

        txt_id_detail.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txt_id_detail.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("ID DETAIL");

        txt_cari.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cariKeyPressed(evt);
            }
        });

        btn_cari.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btn_cari.setText("CARI");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btn_delete.setText("DELETE");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_used.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btn_used.setText("USED");
        btn_used.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_usedActionPerformed(evt);
            }
        });

        tbl_transaksi.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tbl_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_transaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_transaksi);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/logo1.png"))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setPreferredSize(new java.awt.Dimension(0, 3));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("AMBIL BOOKING");

        btnback.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        btnback.setText("BACK");
        btnback.setBorder(null);
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(204, 204, 204)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_cari)
                .addGap(103, 103, 103))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_id_detail, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(128, 128, 128)
                                .addComponent(btn_delete)
                                .addGap(133, 133, 133)
                                .addComponent(btn_used, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id_detail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cari))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_delete)
                    .addComponent(btn_used)
                    .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        // TODO add your handling code here:
        cari(txt_cari.getText());
    }//GEN-LAST:event_btn_cariActionPerformed

    private void tbl_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_transaksiMouseClicked
        // TODO add your handling code here:
         DefaultTableModel model = (DefaultTableModel) tbl_transaksi.getModel();
        int row = tbl_transaksi.getSelectedRow();
        txt_id_detail.setText(model.getValueAt(row, 1).toString());
        txt_nama.setText(model.getValueAt(row, 2).toString());
        
    }//GEN-LAST:event_tbl_transaksiMouseClicked

    private void btn_usedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_usedActionPerformed
        // TODO add your handling code here:
        
        data_ambil_kendaraan_booking dakb = new data_ambil_kendaraan_booking();
        dakb.setId_detail(Integer.parseInt(txt_id_detail.getText()));
        DefaultTableModel model = (DefaultTableModel) tbl_transaksi.getModel();
        while(model.getRowCount()>0){
            model.setRowCount(0);
        }
        dakb.update_status();
        
    }//GEN-LAST:event_btn_usedActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tbl_transaksi.getModel();
        int row = tbl_transaksi.getSelectedRow();
        data_ambil_kendaraan_booking db = new data_ambil_kendaraan_booking();
        int id_detail = Integer.parseInt(txt_id_detail.getText());
        db.delete(id_detail);
        cari(txt_nama.getText());
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        new f_home().show();
        dispose();
    }//GEN-LAST:event_btnbackActionPerformed

    private void txt_cariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            cari(txt_cari.getText());
        }
    }//GEN-LAST:event_txt_cariKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(f_ambil_kendaraan_booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(f_ambil_kendaraan_booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(f_ambil_kendaraan_booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(f_ambil_kendaraan_booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new f_ambil_kendaraan_booking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_used;
    private javax.swing.JButton btnback;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_transaksi;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_id_detail;
    private javax.swing.JTextField txt_nama;
    // End of variables declaration//GEN-END:variables
}