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
public class data_pengembalian {
     int id_kembali , id_denda , id_transaksi ,id_customer , id_detail , id_motor , cek_save = 0 , id_pemilik , total_pembayaran;
     String tgl_kembali , tgl_sewa , jaminan;
     
     public data_pengembalian (int id_kembali , int id_denda , int id_transaksi , int id_customer , int id_detail , int id_motor , int id_pemilik , int total_pembayaran , String tgl_kembali , String tgl_sewa , String jaminan){
         this.id_kembali = id_kembali;
         this.id_denda = id_denda;
         this.id_transaksi = id_transaksi;
         this.id_customer = id_customer;
         this.id_detail = id_detail;
         this.id_motor = id_motor;
         this.id_pemilik = id_pemilik;
         this.total_pembayaran = total_pembayaran;
         this.tgl_kembali = tgl_kembali;
         this.tgl_sewa = tgl_sewa;
         this.jaminan = jaminan;
     }

    public int getId_kembali() {
        return id_kembali;
    }
    
    public void setId_kembali(int id_kembali) {
        this.id_kembali = id_kembali;
    }

    public int getId_denda() {
        return id_denda;
    }
    
    public void setId_denda(int id_denda) {
        this.id_denda = id_denda;
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

    public int getCek_save() {
        return cek_save;
    }
    
    public void setCek_save(int cek_save) {
        this.cek_save = cek_save;
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

    public String getTgl_kembali() {
        return tgl_kembali;
    }
    
    public void setTgl_kembali(String tgl_kembali) {
        this.tgl_kembali = tgl_kembali;
    }

    public String getTgl_sewa() {
        return tgl_sewa;
    }
    
    public void setTgl_sewa(String tgl_sewa) {
        this.tgl_sewa = tgl_sewa;
    }

    public String getJaminan() {
        return jaminan;
    }

    public void setJaminan(String jaminan) {
        this.jaminan = jaminan;
    }
    
    
}
