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
 * @author Abiyyuoo
 */
public class data_ambil_kendaraan_booking {
    
     int id_detail, id_pengembalian, id_transaksi, id_customer, id_motor;
    String jenis_motor, tgl_sewa, tgl_kembali, status, nama_customer, jaminan;

    public data_ambil_kendaraan_booking() {
    }

    public data_ambil_kendaraan_booking(int id_detail, int id_pengembalian, int id_transaksi, int id_customer, int id_motor, String jenis_motor, String tgl_sewa, String tgl_kembali, String status, String nama_customer, String jaminan) {
        this.id_detail = id_detail;
        this.id_pengembalian = id_pengembalian;
        this.id_transaksi = id_transaksi;
        this.id_customer = id_customer;
        this.id_motor = id_motor;
        this.jenis_motor = jenis_motor;
        this.tgl_sewa = tgl_sewa;
        this.tgl_kembali = tgl_kembali;
        this.status = status;
        this.nama_customer = nama_customer;
        this.jaminan = jaminan;
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
    
//    public ArrayList<data_ambil_kendaraan_booking> getAll(){
//        ArrayList<data_ambil_kendaraan_booking> ListCekTransaksi=new ArrayList();
//        ResultSet rs=DBHelper.selectQuery("select ct.nama_customer , ht.id_transaksi , dt.id_detail , ht.tgl_sewa , ht.tgl_kembali , mt.jenis_motor ,  ht.jaminan, dt.status\n"
//                + "from header_transaksi ht\n"
//                + "inner join detail_transaksi dt\n"
//                + "on ht.id_transaksi = dt.id_transaksi\n"
//                + "inner join motor mt\n"
//                + "on mt.id_motor = dt.id_motor\n"
//                + "INNER JOIN customer ct\n"
//                + "on ct.id_customer = ht.id_customer \n"
//                + "where dt.status = 'booking'"
//                );
//        try{
//            while(rs.next()){
//                data_ambil_kendaraan_booking dpm = new data_ambil_kendaraan_booking();
//                dpm.setNama_customer(rs.getString("ct.nama_customer"));
//                dpm.setId_detail(rs.getInt("dt.id_detail"));
//                dpm.setId_transaksi(rs.getInt("ht.id_transaksi"));
//                dpm.setTgl_sewa(rs.getString("ht.tgl_sewa"));
//                dpm.setTgl_kembali(rs.getString("ht.tgl_kembali"));
//                dpm.setJenis_motor(rs.getString("mt.jenis_motor"));
//                dpm.setJaminan(rs.getString("ht.jaminan"));
//                dpm.setStatus(rs.getString("dt.status"));
//                ListCekTransaksi.add(dpm);
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//            
//        }
//        return ListCekTransaksi;
//    }
    public ArrayList<data_ambil_kendaraan_booking> search(String nama) {
        ArrayList<data_ambil_kendaraan_booking> ListCekTransaksi = new ArrayList();
        String sql = "select ct.nama_customer , ht.id_transaksi , dt.id_detail , ht.tgl_sewa , ht.tgl_kembali , mt.jenis_motor ,  ht.jaminan,dt.status\n"
                + "from header_transaksi ht\n"
                + "inner join detail_transaksi dt\n"
                + "on ht.id_transaksi = dt.id_transaksi\n"
                + "inner join motor mt\n"
                + "on mt.id_motor = dt.id_motor\n"
                + "INNER JOIN customer ct\n"
                + "on ct.id_customer = ht.id_customer \n"
                + "where ct.nama_customer LIKE '%" + nama + "%'   AND dt.status='booking'";
        ResultSet rs = DBHelper.selectQuery(sql);
        try {
            while (rs.next()) {
                data_ambil_kendaraan_booking dpm = new data_ambil_kendaraan_booking();
                dpm.setNama_customer(rs.getString("ct.nama_customer"));
                dpm.setId_detail(rs.getInt("dt.id_detail"));
                dpm.setId_transaksi(rs.getInt("ht.id_transaksi"));
                dpm.setTgl_sewa(rs.getString("ht.tgl_sewa"));
                dpm.setTgl_kembali(rs.getString("ht.tgl_kembali"));
                dpm.setJenis_motor(rs.getString("mt.jenis_motor"));
                dpm.setJaminan(rs.getString("ht.jaminan"));
                dpm.setStatus(rs.getString("dt.status"));
                ListCekTransaksi.add(dpm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListCekTransaksi;
    }
    public void update_status(){
        String sql = "UPDATE detail_transaksi SET "                   
                + " status = '" + "used" 
                + "' "+" WHERE id_detail= '"+ this.id_detail+"' ";
        DBHelper.executeQuery(sql);
        
//        System.out.println(sql);
        }
    public void delete(int id_detail){
        String sql = "DELETE FROM detail_transaksi WHERE id_detail = '" + id_detail + "'";
        DBHelper.executeQuery(sql);
    }
    
    
}
