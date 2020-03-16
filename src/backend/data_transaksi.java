/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.ResultSet;

/**
 *
 * @author WINDOWS 10
 */
public class data_transaksi {
    
    int id_transaksi ,id_customer, id_detail , id_motor , id_pemilik , total_pembayaran , cek_save = 0, harga_motor , bagi_pemilik , bagi_rental; 
    String tgl_sewa,tgl_kembali="",jaminan="" , status;

    public data_transaksi(int id_transaksi, int id_customer, int id_detail, int id_motor, int id_pemilik, int total_pembayaran, int harga_motor, int bagi_pemilik, int bagi_rental, String tgl_sewa, String status) {
        this.id_transaksi = id_transaksi;
        this.id_customer = id_customer;
        this.id_detail = id_detail;
        this.id_motor = id_motor;
        this.id_pemilik = id_pemilik;
        this.total_pembayaran = total_pembayaran;
        this.harga_motor = harga_motor;
        this.bagi_pemilik = bagi_pemilik;
        this.bagi_rental = bagi_rental;
        this.tgl_sewa = tgl_sewa;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
    public int getCek_save() {
        return cek_save;
    }

    public void setCek_save(int cek_save) {
        this.cek_save = cek_save;
    }

    public int getBagi_pemilik() {
        return bagi_pemilik;
    }

    public void setBagi_pemilik(int bagi_pemilik) {
        this.bagi_pemilik = bagi_pemilik;
    }

    public int getBagi_rental() {
        return bagi_rental;
    }

    public void setBagi_rental(int bagi_rental) {
        this.bagi_rental = bagi_rental;
    }

    public int getHarga_motor() {
        return harga_motor;
    }

    public void setHarga_motor(int harga_motor) {
        this.harga_motor = harga_motor;
    }
    
    public data_transaksi() {
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

    public int getId_detail() {
        return id_detail;
    }

    public void setId_detail(int id_detail) {
        this.id_detail = id_detail;
    }

    public int getId_motor() {
        return id_motor;
    }

    public void setId_motor(int id_motor) {
        this.id_motor = id_motor;
    }

    public int getId_pemilik() {
        return id_pemilik;
    }

    public void setId_pemilik(int id_pemilik) {
        this.id_pemilik = id_pemilik;
    }

    public int getTotal_pembayaran() {
        return total_pembayaran;
    }

    public void setTotal_pembayaran(int total_pembayaran) {
        this.total_pembayaran = total_pembayaran;
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

    public String getJaminan() {
        return jaminan;
    }

    public void setJaminan(String jaminan) {
        this.jaminan = jaminan;
    }
            
    public data_transaksi getById(int id_transaksi) {
        data_transaksi dt = new data_transaksi();
        ResultSet rs = DBHelper.selectQuery("select * from header_transaksi ht " + " WHERE id_transaksi = '" + id_transaksi + "' inner join detail_transaksi dt on ht.id_transaksi = dt.id_transaksi");
        try {
            while (rs.next()) {
                dt = new data_transaksi();
                dt.setId_pemilik(rs.getInt("id_pemilik"));
                dt.setTgl_sewa(rs.getString("tgl_sewa"));
                dt.setTgl_kembali(rs.getString("tgl_kembali"));
                
                cek_save = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dt;
    }
            
    public void save_data() {
        String SQL = "INSERT into header_transaksi (id_transaksi,id_customer , tgl_sewa , tgl_kembali , total_pembayaran ,jaminan) values("
                + " '" + this.id_transaksi + " ',"
                + " '" + this.id_customer + " ',"
                + " '" + this.tgl_sewa + " ',"
                + " '" + this.tgl_kembali + " ',"
                + " '" + this.total_pembayaran + " ',"
                + " '" + this.jaminan + "'"
                + ")";
        DBHelper.executeQuery(SQL);
        System.out.println(SQL);
    }
    
    public void save_data_detail() {
        String SQL = "INSERT into detail_transaksi (id_transaksi,id_motor , id_pemilik , harga_motor, bagi_pemilik , bagi_rental , status ) values("
                + " '" + this.id_transaksi + " ',"
                + " '" + this.id_motor + " ',"
                + " '" + this.id_pemilik + " ',"
                + " '" + this.harga_motor + " ',"
                + " '" + this.bagi_pemilik + " ',"
                + " '" + this.bagi_rental + " ',"
                + " '" + this.status + "'"
//                + " '" + this.status + "'"
                + ")";

        DBHelper.executeQuery(SQL);
        System.out.println(SQL);
    }
    public data_transaksi getLastId() {
        data_transaksi dt = new data_transaksi();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM header_transaksi ORDER BY id_transaksi DESC LIMIT 1");
        try {
            while (rs.next()) {
                dt = new data_transaksi();
                int id = rs.getInt("id_transaksi");
                setId_transaksi(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dt;
    }
}
