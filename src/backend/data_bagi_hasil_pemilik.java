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
public class data_bagi_hasil_pemilik {

    String nama_pemilik, tgl_awal, tgl_akhir, jenis_motor, tgl_sewa;
    int id_pemilik, total_hasil, bagi_pemilik, id_motor;

    public data_bagi_hasil_pemilik(String nama_pemilik, String tgl_awal, String tgl_akhir, String jenis_motor, String tgl_sewa, int id_pemilik, int total_hasil, int bagi_pemilik, int id_motor) {
        this.nama_pemilik = nama_pemilik;
        this.tgl_awal = tgl_awal;
        this.tgl_akhir = tgl_akhir;
        this.jenis_motor = jenis_motor;
        this.tgl_sewa = tgl_sewa;
        this.id_pemilik = id_pemilik;
        this.total_hasil = total_hasil;
        this.bagi_pemilik = bagi_pemilik;
        this.id_motor = id_motor;
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

    public int getBagi_pemilik() {
        return bagi_pemilik;
    }

    public void setBagi_pemilik(int bagi_pemilik) {
        this.bagi_pemilik = bagi_pemilik;
    }

    public data_bagi_hasil_pemilik() {
    }

    public String getTgl_awal() {
        return tgl_awal;
    }

    public void setTgl_awal(String tgl_awal) {
        this.tgl_awal = tgl_awal;
    }

    public String getTgl_akhir() {
        return tgl_akhir;
    }

    public void setTgl_akhir(String tgl_akhir) {
        this.tgl_akhir = tgl_akhir;
    }

    public String getNama_pemilik() {
        return nama_pemilik;
    }

    public void setNama_pemilik(String nama_pemilik) {
        this.nama_pemilik = nama_pemilik;
    }

    public int getId_pemilik() {
        return id_pemilik;
    }

    public void setId_pemilik(int id_pemilik) {
        this.id_pemilik = id_pemilik;
    }

    public int getTotal_hasil() {
        return total_hasil;
    }

    public void setTotal_hasil(int total_hasil) {
        this.total_hasil = total_hasil;
    }

//    public ArrayList<data_bagi_hasil_pemilik> getAll() {
//        ArrayList<data_bagi_hasil_pemilik> ListCekTransaksi = new ArrayList();
//        ResultSet rs = DBHelper.selectQuery("select ht.id_transaksi , ht.tgl_sewa , ht.tgl_kembali ,ct.nama_customer , m.jenis_motor , m.no_plat \n"
//                + "                from header_transaksi ht\n"
//                + "                inner join detail_transaksi dt\n"
//                + "                on ht.id_transaksi = dt.id_transaksi\n"
//                + "                inner join customer ct\n"
//                + "                on ht.id_customer = ct.id_customer\n"
//                + "                inner join motor m\n"
//                + "                on dt.id_motor = m.id_motor\n"
//                + "                ORDER BY id_transaksi ASC");
//        try {
//            while (rs.next()) {
//                data_bagi_hasil_pemilik dct = new data_bagi_hasil_pemilik();
//                dct.setId_transaksi(rs.getInt("ht.id_transaksi"));
//                dct.setTgl_sewa(rs.getString("ht.tgl_sewa"));
//                dct.setTgl_kembali(rs.getString("ht.tgl_kembali"));
//                dct.setNama_customer(rs.getString("ct.nama_customer"));
//                dct.setJenis_motor(rs.getString("m.jenis_motor"));
//                dct.setPlat(rs.getString("m.no_plat"));
//
//                ListCekTransaksi.add(dct);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(rs);
//        return ListCekTransaksi;
//    }
    public ArrayList<data_bagi_hasil_pemilik> search(String tgl_awal, String tgl_akhir, int id_pemilik) {
        ArrayList<data_bagi_hasil_pemilik> ListCekTransaksi = new ArrayList();
        String sql = "SELECT pm.id_pemilik , pm.nama_pemilik, sum(dt.bagi_pemilik) as total\n"
                + "from detail_transaksi dt\n"
                + "inner join header_transaksi ht\n"
                + "on ht.id_transaksi = dt.id_transaksi\n"
                + "inner join pemilik_motor pm\n"
                + "on pm.id_pemilik = dt.id_pemilik\n"
                + "where dt.id_pemilik = " + id_pemilik + " AND ht.tgl_sewa >='" + tgl_awal + "' AND ht.tgl_sewa <='" + tgl_akhir + "'";
        ResultSet rs = DBHelper.selectQuery(sql);
        try {
            while (rs.next()) {
                data_bagi_hasil_pemilik dct = new data_bagi_hasil_pemilik();
                dct.setId_pemilik(rs.getInt("pm.id_pemilik"));
                dct.setNama_pemilik(rs.getString("pm.nama_pemilik"));
                dct.setTgl_awal(tgl_awal);
                dct.setTgl_akhir(tgl_akhir);
                dct.setTotal_hasil(rs.getInt("total"));

                ListCekTransaksi.add(dct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListCekTransaksi;
    }

    public ArrayList<data_bagi_hasil_pemilik> search_list(String tgl_awal, String tgl_akhir, int id_pemilik) {
        ArrayList<data_bagi_hasil_pemilik> ListCekTransaksi = new ArrayList();
        String sql = "SELECT pm.id_pemilik , pm.nama_pemilik , mt.id_motor  , mt.jenis_motor, ht.tgl_sewa as sewa , dt.bagi_pemilik\n"
                + "from detail_transaksi dt\n"
                + "inner join header_transaksi ht\n"
                + "on ht.id_transaksi = dt.id_transaksi\n"
                + "inner join pemilik_motor pm\n"
                + "on pm.id_pemilik = dt.id_pemilik\n"
                + "inner join motor mt\n"
                + "on mt.id_pemilik = pm.id_pemilik\n"
                + "where dt.id_pemilik = " + id_pemilik + " AND ht.tgl_sewa >='" + tgl_awal + "' AND ht.tgl_sewa <='" + tgl_akhir + "' order by sewa asc";
        ResultSet rs = DBHelper.selectQuery(sql);
        try {
            while (rs.next()) {
                data_bagi_hasil_pemilik dct = new data_bagi_hasil_pemilik();
                dct.setId_motor(rs.getInt("mt.id_motor"));
                dct.setJenis_motor(rs.getString("mt.jenis_motor"));
                dct.setTgl_sewa(rs.getString("sewa"));
                dct.setBagi_pemilik(rs.getInt("dt.bagi_pemilik"));

                ListCekTransaksi.add(dct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListCekTransaksi;
    }
}
