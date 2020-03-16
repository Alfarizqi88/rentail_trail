/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author WINDOWS 10
 */
public class data_pengembalian_motor {

    int id_detail, id_pengembalian, id_transaksi, id_customer, denda, id_motor, cek_save = 0;
    String jenis_motor, tgl_sewa, tgl_kembali, tgl_pengembalian, status, nama_customer, jaminan;

    public data_pengembalian_motor(int id_detail, int id_pengembalian, int id_transaksi, int id_customer, int denda, int id_motor, String jenis_motor, String tgl_sewa, String tgl_kembali, String tgl_pengembalian, String status, String nama_customer, String jaminan) {
        this.id_detail = id_detail;
        this.id_pengembalian = id_pengembalian;
        this.id_transaksi = id_transaksi;
        this.id_customer = id_customer;
        this.denda = denda;
        this.id_motor = id_motor;
        this.jenis_motor = jenis_motor;
        this.tgl_sewa = tgl_sewa;
        this.tgl_kembali = tgl_kembali;
        this.tgl_pengembalian = tgl_pengembalian;
        this.status = status;
        this.nama_customer = nama_customer;
        this.jaminan = jaminan;
    }

    public data_pengembalian_motor() {
    }

    public int getId_detail() {
        return id_detail;
    }

    public void setId_detail(int id_detail) {
        this.id_detail = id_detail;
    }

    public int getId_pengembalian() {
        return id_pengembalian;
    }

    public void setId_pengembalian(int id_pengembalian) {
        this.id_pengembalian = id_pengembalian;
    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public int getDenda() {
        return denda;
    }

    public void setDenda(int denda) {
        this.denda = denda;
    }

    public int getId_motor() {
        return id_motor;
    }

    public void setId_motor(int id_motor) {
        this.id_motor = id_motor;
    }

    public String getJenis_motor() {
        return jenis_motor;
    }

    public void setJenis_motor(String jenis_motor) {
        this.jenis_motor = jenis_motor;
    }

    public String getTgl_sewa() {
        return tgl_sewa;
    }

    public void setTgl_sewa(String tgl_sewa) {
        this.tgl_sewa = tgl_sewa;
    }

    public String getTgl_kembali() {
        return tgl_kembali;
    }

    public void setTgl_kembali(String tgl_kembali) {
        this.tgl_kembali = tgl_kembali;
    }

    public String getTgl_pengembalian() {
        return tgl_pengembalian;
    }

    public void setTgl_pengembalian(String tgl_pengembalian) {
        this.tgl_pengembalian = tgl_pengembalian;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNama_customer() {
        return nama_customer;
    }

    public void setNama_customer(String nama_customer) {
        this.nama_customer = nama_customer;
    }

    public String getJaminan() {
        return jaminan;
    }

    public void setJaminan(String jaminan) {
        this.jaminan = jaminan;
    }

    public ArrayList<data_pengembalian_motor> search(String nama, String tgl_sewa) {
        ArrayList<data_pengembalian_motor> ListCekTransaksi = new ArrayList();
        String sql = "select ct.nama_customer , ht.id_transaksi , dt.id_detail , ht.tgl_sewa , ht.tgl_kembali , mt.jenis_motor ,  ht.jaminan, CURDATE() as tgl_pengembalian ,datediff(CURDATE(),ht.tgl_sewa)*mt.tarif_motor as denda\n"
                + "from header_transaksi ht\n"
                + "inner join detail_transaksi dt\n"
                + "on ht.id_transaksi = dt.id_transaksi\n"
                + "inner join motor mt\n"
                + "on mt.id_motor = dt.id_motor\n"
                + "INNER JOIN customer ct\n"
                + "on ct.id_customer = ht.id_customer \n"
                + "where ct.nama_customer LIKE '%" + nama + "%'  AND ht.tgl_sewa ='" + tgl_sewa + "'  AND ht.tgl_sewa <=curdate() " + " AND dt.status='used'";
        ResultSet rs = DBHelper.selectQuery(sql);
        try {
            while (rs.next()) {
                data_pengembalian_motor dpm = new data_pengembalian_motor();
                dpm.setNama_customer(rs.getString("ct.nama_customer"));
                dpm.setId_detail(rs.getInt("dt.id_detail"));
                dpm.setId_transaksi(rs.getInt("ht.id_transaksi"));
                dpm.setTgl_sewa(rs.getString("ht.tgl_sewa"));
                dpm.setTgl_kembali(rs.getString("ht.tgl_kembali"));
                dpm.setJenis_motor(rs.getString("mt.jenis_motor"));
                dpm.setJaminan(rs.getString("ht.jaminan"));
                dpm.setTgl_pengembalian(rs.getString("tgl_pengembalian"));
                dpm.setDenda(rs.getInt("denda"));

                ListCekTransaksi.add(dpm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListCekTransaksi;
    }

    public data_pengembalian_motor getById(int id_pengembalian) {
        data_pengembalian_motor dpm = new data_pengembalian_motor();
        ResultSet rs = DBHelper.selectQuery("select * from pengembalian " + " WHERE id_pengembalian = '" + id_pengembalian + "'");
        try {
            while (rs.next()) {
                dpm = new data_pengembalian_motor();
                dpm.setId_detail(rs.getInt("id_detail"));
                dpm.setId_transaksi(rs.getInt("id_transaksi"));
                dpm.setDenda(rs.getInt("denda"));
                dpm.setTgl_pengembalian(rs.getString("tgl_pengembalian"));

                cek_save = 1;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dpm;
    }

    public void save_data() {
        getById(id_pengembalian);
        if (cek_save == 0) {
            System.out.println("2");
            String SQL = "INSERT into pengembalian (id_pengembalian , id_transaksi , id_detail , denda , tgl_pengembalian) values("
                    + " '" + this.id_pengembalian + " ',"
                    + " '" + this.id_transaksi + " ',"
                    + " '" + this.id_detail + " ',"
                    + " '" + this.denda + " ',"
                    + " CURDATE()"
                    + ")";

            DBHelper.executeQuery(SQL);
            System.out.println(SQL);
            //konfirm_save_detail = 1;
            ubah_status();
        } else {
            String sql = "UPDATE motor SET "
                    + " denda = '" + this.denda + "', "
                    + " tgl_pengembalian = '" + this.tgl_pengembalian
                    + "' " + " WHERE id_pengembalian= '" + this.id_pengembalian + "' ";
            DBHelper.executeQuery(sql);
            System.out.println(sql);
        }
    }

    public void ubah_status() {
        String SQL = "UPDATE detail_transaksi\n"
                + "set STATUS=\"available\"\n"
                + "where id_detail= '" + this.id_detail + "'";
        DBHelper.executeQuery(SQL);
            System.out.println(SQL);
    }

}
