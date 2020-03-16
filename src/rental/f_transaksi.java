/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rental;
import backend.data_motor;
import backend.data_pemilik;
import backend.cek_motor_ready;
import backend.data_customer;
import backend.data_transaksi;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WINDOWS 10
 */
public class f_transaksi extends javax.swing.JFrame {
    private FileWriter out;
    int pembayaran = 0, bagi_pemilik = 0, bagi_rental = 0;
    /**
     * Creates new form f_transaksi
     */
    public f_transaksi() {
        initComponents();
//        tampilkanComboMotor();
        ambil_id_transaksi();
        reset();
        date_tgl_sewa.setMinSelectableDate(new Date());
        date_tgl_kembali.setMinSelectableDate(new Date());
    }
    
//    public void reset_id(){
//        txt_id_motor.setText("");
//        txt_id_pemilik.setText("");
//    }
    
    public void setdata(int id_customer, String nama_customer){
        this.txt_id_customer.setText(String.valueOf(id_customer));
        this.txt_nama_pel.setText(nama_customer);
    }
    
    public void ambil_id_transaksi(){
        data_transaksi dt = new data_transaksi();
        dt.getLastId();
        int id_terakhir = dt.getId_transaksi() + 1;
        txt_id_transaksi.setText(String.valueOf(id_terakhir));
    }
    
    public void tampilkanComboMotor(String keyword) {
        combo_plat.setModel(new DefaultComboBoxModel(new cek_motor_ready().getAll(keyword).toArray()));
        combo_plat.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    //String a = combo_plat.getSelectedItem().toString();
                    String data = combo_plat.getSelectedItem().toString();
                    String[] sp1 = data.split("\\|");
                    String[] sp2 = sp1[2].split("\\:");
                    String[] sp3 = sp1[3].split("\\:");
                    String[] sp4 = sp1[4].split("\\:");
                    txt_id_pemilik.setText(sp2[1]);
                    txt_id_motor.setText(sp3[1]);
                    txt_harga_motor.setText(sp4[1]);
                    int convert_harga = Integer.parseInt(sp4[1]);
                    bagi_pemilik = convert_harga * 60 / 100;
                    bagi_rental = convert_harga * 40 / 100;
                    txt_bagi_pemilik.setText(String.valueOf(bagi_pemilik));
                    txt_bagi_rental.setText(String.valueOf(bagi_rental));
                    //System.out.println(a);
                }
            }
        });  
    }
    
    public void cetak_struk(){   
        String sewa, kembali;
        sewa = String.valueOf(date_tgl_sewa.getDate()) ;
        kembali = String.valueOf(date_tgl_kembali.getDate());
        try {
            out = new FileWriter("transaksi.txt", true);
//            out.write("/home/abiyyuoo/Documents/Semester 5/Proyek2_Netbeans/offroad/src/asset/logo1.png");
            out.write("--------------------------------" + "\n");
            out.write("--------------------------------" + "\n");
            out.write("Nama            : " + String.valueOf(txt_nama_pel.getText())+"\n");
            out.write("Tanggal Sewa    :"+ "\n");
            out.write(sewa + "\n");
            out.write("Tanggal Kembali :"+ "\n");
            out.write(kembali + "\n");
            out.write("Jaminan         :" + String.valueOf(txtjaminan.getText())+"\n");
            out.write("Bayar           :" + String.valueOf(txtbayar.getText())+"\n");
            out.write("Kembalian       :" + String.valueOf(txtkembalian.getText()+"\n"));
            out.write("--------------------------------" + "\n");
            out.write("            THANK YOU            " + "\n");
            out.write("--------------------------------" + "\n");
            out.close();
        } catch (IOException e) {}
    }
    
    public void reset() {
        
        txt_id_motor.getText();
        txt_id_pemilik.getText();
        date_tgl_sewa.setCalendar(null);
//        txt_id_motor.setText("");
//        txt_id_pemilik.setText("");
        date_tgl_kembali.setCalendar(null);
        txtjaminan.getText();
        txtbayar.getText();
    }
    public void save(){
        if (txt_id_motor.getText().equals("") || txt_id_pemilik.getText().equals("") || txt_id_customer.getText().equals("")|| txt_nama_pel.getText().equals("") || txtjaminan.getText().equals("") || txtbayar.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "inputan kosong");
        } else {
            System.out.println("save");
//            data_motor dm = new data_motor();
            data_transaksi dt = new data_transaksi();
            dt.setId_transaksi(Integer.parseInt(txt_id_transaksi.getText()));
            dt.setId_pemilik(Integer.parseInt(txt_id_pemilik.getText()));
            dt.setId_motor(Integer.parseInt(txt_id_motor.getText()));
            dt.setId_customer(Integer.parseInt(txt_id_customer.getText()));
//            dt.setTgl_sewa(date_tgl_sewa.getDateFormatString());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            dt.setTgl_sewa(sdf.format(date_tgl_sewa.getDate()));
//            dt.setTgl_kembali(txtkembali.getText());
            dt.setTgl_kembali(sdf.format(date_tgl_kembali.getDate()));
            dt.setJaminan(txtjaminan.getText());
            dt.setTotal_pembayaran(Integer.parseInt(txtbayar.getText()));
            dt.setHarga_motor(Integer.parseInt(txt_harga_motor.getText()));
            dt.setBagi_pemilik(Integer.parseInt(txt_bagi_pemilik.getText()));
            dt.setBagi_rental(Integer.parseInt(txt_bagi_rental.getText()));
            dt.setStatus(txt_status.getText());
            System.out.println(txt_status.getText());
            dt.save_data();
            dt.save_data_detail();
            JOptionPane.showMessageDialog(this, "sukses");
//            reset_id();
            txtjaminan.setText("");
            cetak_struk();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_id_customer = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_id_pemilik = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_nama_pel = new javax.swing.JTextField();
        combo_plat = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txt_id_motor = new javax.swing.JTextField();
        txtjaminan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btncektgl = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txt_id_transaksi = new javax.swing.JTextField();
        date_tgl_sewa = new com.toedter.calendar.JDateChooser();
        date_tgl_kembali = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        txt_harga_motor = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_bagi_pemilik = new javax.swing.JTextField();
        txt_bagi_rental = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtbayar = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtkembalian = new javax.swing.JTextField();
        btn_save_detail = new javax.swing.JButton();
        txt_status = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("TRANSAKSI");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel3.setText("TANGGAL SEWA");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel12.setText("ID CUSTOMER");

        txt_id_customer.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txt_id_customer.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel6.setText("ID_PEMILIK");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel9.setText("ID_MOTOR");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel4.setText("TANGGAL KEMBALI");

        txt_id_pemilik.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txt_id_pemilik.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel8.setText("NAMA CUSTOMER");

        txt_nama_pel.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txt_nama_pel.setEnabled(false);

        combo_plat.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        combo_plat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel7.setText("JAMINAN");

        txt_id_motor.setEnabled(false);

        txtjaminan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtjaminanKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel2.setText("JENIS MOTOR");

        btncektgl.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        btncektgl.setText("CEK");
        btncektgl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btncektgl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncektglActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel10.setText("ID TRANSAKSI");

        txt_id_transaksi.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txt_id_transaksi.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setText("TARIF");

        txt_harga_motor.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel14.setText("PEMILIK");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel15.setText("RENTAL");

        txt_bagi_pemilik.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txt_bagi_pemilik.setEnabled(false);

        txt_bagi_rental.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txt_bagi_rental.setEnabled(false);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/logo1.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("BAYAR");

        txtbayar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtbayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbayarKeyPressed(evt);
            }
        });

        btnsave.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnsave.setText("SAVE");
        btnsave.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        btnsave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnsaveKeyPressed(evt);
            }
        });

        btnreset.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnreset.setText("RESET");
        btnreset.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });

        btnback.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnback.setText("BACK");
        btnback.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setText("KEMBALI");

        txtkembalian.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtkembalian.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 83, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtkembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtbayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtkembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsave)
                    .addComponent(btnreset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnback))
                .addGap(28, 28, 28))
        );

        btn_save_detail.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        btn_save_detail.setText("SAVE DETAIL");
        btn_save_detail.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_save_detail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_save_detailActionPerformed(evt);
            }
        });

        txt_status.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        txt_status.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel12)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(155, 155, 155)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(48, 48, 48)
                                .addComponent(txt_bagi_rental, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(date_tgl_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_id_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(date_tgl_sewa, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btncektgl, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_status, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_nama_pel, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtjaminan, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_id_pemilik, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_id_motor, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(105, 105, 105)
                                    .addComponent(btn_save_detail, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(combo_plat, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txt_id_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13))
                                .addGap(48, 48, 48)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_harga_motor, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_bagi_pemilik, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(362, 362, 362))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)))
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt_id_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(date_tgl_sewa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btncektgl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_id_customer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_nama_pel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combo_plat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txt_id_pemilik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_id_motor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(btn_save_detail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(date_tgl_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtjaminan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txt_harga_motor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_bagi_pemilik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15)
                                .addComponent(txt_bagi_rental, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel14)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        new f_home().show();
        dispose();   
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        // TODO add your handling code here:
        reset();
        txtjaminan.setText("");
        txt_harga_motor.setText("");
        txt_bagi_pemilik.setText("");
        txt_bagi_rental.setText("");
        txtbayar.setText("");
        txtkembalian.setText("");
    }//GEN-LAST:event_btnresetActionPerformed

    private void btncektglActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncektglActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String date = sdf.format(date_tgl_sewa.getDate());
//        cari(sdf.format(date_tgl_sewa.getDate()));
        tampilkanComboMotor(sdf.format(date_tgl_sewa.getDate()));
        date_tgl_kembali.setMinSelectableDate(date_tgl_sewa.getDate());
        Date date = new Date();
        String ambil_tgl_sewa = sdf.format(date_tgl_sewa.getDate());
        String cek_status = sdf.format(date);
        System.out.println(date_tgl_sewa.getDate());
        if(ambil_tgl_sewa.equals(cek_status)){
            txt_status.setText("used");
        }else{
            txt_status.setText("booking");
        }
    }//GEN-LAST:event_btncektglActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        save();
    }//GEN-LAST:event_btnsaveActionPerformed

    private void txtjaminanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtjaminanKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtbayar.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtjaminanKeyPressed

    private void txtbayarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbayarKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            int x = Integer.parseInt(txtbayar.getText());
            int y = Integer.parseInt(txt_harga_motor.getText());
            int hasil = x-y;
            if(x < y){
                JOptionPane.showMessageDialog(this, "mohon lakukan pembayaran");
            }else{
                txtkembalian.setText(Integer.toString(hasil));
                btnsave.requestFocusInWindow();
            }
        }
    }//GEN-LAST:event_txtbayarKeyPressed

    private void btnsaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnsaveKeyPressed
        // TODO add your handling code here:
        save();
        
    }//GEN-LAST:event_btnsaveKeyPressed

    private void btn_save_detailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_save_detailActionPerformed
        // TODO add your handling code here:
        if (txt_id_motor.getText().equals("") || txt_id_pemilik.getText().equals("") 
                || txt_id_customer.getText().equals("")|| txtjaminan.getText().equals("")|| txtbayar.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "inputan kosong");
        } else {
            System.out.println("save");
            data_transaksi dt = new data_transaksi();

            dt.setId_transaksi(Integer.parseInt(txt_id_transaksi.getText()));
            dt.setId_pemilik(Integer.parseInt(txt_id_pemilik.getText()));
            dt.setId_motor(Integer.parseInt(txt_id_motor.getText()));
            dt.setId_customer(Integer.parseInt(txt_id_customer.getText()));
            dt.setHarga_motor(Integer.parseInt(txt_harga_motor.getText()));
            dt.setBagi_pemilik(Integer.parseInt(txt_bagi_pemilik.getText()));
            dt.setBagi_rental(Integer.parseInt(txt_bagi_rental.getText()));
            // dt.save_data();
            dt.save_data_detail();
            JOptionPane.showMessageDialog(this, "sukses");
//            reset_id();
            //menanpilkan combo box
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            tampilkanComboMotor(sdf.format(date_tgl_sewa.getDate()));

        }
    }//GEN-LAST:event_btn_save_detailActionPerformed

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
            java.util.logging.Logger.getLogger(f_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(f_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(f_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(f_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new f_transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_save_detail;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btncektgl;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnsave;
    private javax.swing.JComboBox<String> combo_plat;
    private com.toedter.calendar.JDateChooser date_tgl_kembali;
    private com.toedter.calendar.JDateChooser date_tgl_sewa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField txt_bagi_pemilik;
    private javax.swing.JTextField txt_bagi_rental;
    private javax.swing.JTextField txt_harga_motor;
    private javax.swing.JTextField txt_id_customer;
    private javax.swing.JTextField txt_id_motor;
    private javax.swing.JTextField txt_id_pemilik;
    private javax.swing.JTextField txt_id_transaksi;
    private javax.swing.JTextField txt_nama_pel;
    private javax.swing.JTextField txt_status;
    private javax.swing.JTextField txtbayar;
    private javax.swing.JTextField txtjaminan;
    private javax.swing.JTextField txtkembalian;
    // End of variables declaration//GEN-END:variables
}
