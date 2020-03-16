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
public class data_bagi_hasil_rental {
    String  tgl_awal, tgl_akhir;
    int total;

    public data_bagi_hasil_rental(String tgl_awal, String tgl_akhir, int total) {
        this.tgl_awal = tgl_awal;
        this.tgl_akhir = tgl_akhir;
        this.total = total;
    }

    public data_bagi_hasil_rental() {
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    public ArrayList<data_bagi_hasil_rental> search(String tgl_awal, String tgl_akhir) {
        ArrayList<data_bagi_hasil_rental> ListCekTransaksi = new ArrayList();
        String sql = "select sum(dt.bagi_rental) as total\n"
                + "from detail_transaksi dt\n"
                + "inner join header_transaksi ht\n"
                + "on ht.id_transaksi = dt.id_transaksi\n"
                + "inner join pemilik_motor pm\n"
                + "on pm.id_pemilik = dt.id_pemilik\n"
                + "where  ht.tgl_sewa >='" + tgl_awal + "' AND ht.tgl_sewa <='" + tgl_akhir + "'";
        ResultSet rs = DBHelper.selectQuery(sql);
        System.out.println(sql);
        try {
            while (rs.next()) {
                data_bagi_hasil_rental dct = new data_bagi_hasil_rental();
                
                dct.setTgl_awal(tgl_awal);
                dct.setTgl_akhir(tgl_akhir);
                dct.setTotal(rs.getInt("total"));

                ListCekTransaksi.add(dct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListCekTransaksi;
    }
    
}
