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
public class cek_motor_ready {

    public int id_motor, id_pemilik, tarif_motor;
    public String no_plat, jenis_motor;

    public cek_motor_ready(int id_motor, int id_pemilik, int tarif_motor, String no_plat, String jenis_motor) {
        this.id_motor = id_motor;
        this.id_pemilik = id_pemilik;
        this.tarif_motor = tarif_motor;
        this.no_plat = no_plat;
        this.jenis_motor = jenis_motor;
    }

    public cek_motor_ready() {
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

    public int getTarif_motor() {
        return tarif_motor;
    }

    public void setTarif_motor(int tarif_motor) {
        this.tarif_motor = tarif_motor;
    }

    public String getNo_plat() {
        return no_plat;
    }

    public void setNo_plat(String no_plat) {
        this.no_plat = no_plat;
    }

    public String getJenis_motor() {
        return jenis_motor;
    }

    public void setJenis_motor(String jenis_motor) {
        this.jenis_motor = jenis_motor;
    }

    public ArrayList<cek_motor_ready> getAll(String keyword) {
        ArrayList<cek_motor_ready> ListCekMotor = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("select m.no_plat ,m.jenis_motor, p.id_pemilik,  m.id_motor, m.tarif_motor\n"
                + "from motor m \n"
                + "inner join pemilik_motor p\n"
                + "on p.id_pemilik = m.id_pemilik\n"
                + "where m.id_motor not in(\n"
                + "               select mt.id_motor from motor mt\n"
                + "               inner join detail_transaksi dt\n"
                + "               on mt.id_motor = dt.id_motor\n"
                + "               inner join header_transaksi ht\n"
                + "               on ht.id_transaksi = dt.id_transaksi\n"
                + "   			   inner join pemilik_motor p\n"
                + "               on p.id_pemilik = mt.id_pemilik\n"
                + "    			where ht.tgl_sewa LIKE '%" + keyword + "%'\n"
                + "				)");
        try {
            while (rs.next()) {
                cek_motor_ready dm = new cek_motor_ready();
                dm.setId_motor(rs.getInt("id_motor"));
                dm.setId_pemilik(rs.getInt("id_pemilik"));
                dm.setNo_plat(rs.getString("no_plat"));
                dm.setJenis_motor(rs.getString("jenis_motor"));
                dm.setTarif_motor(rs.getInt("tarif_motor"));

                ListCekMotor.add(dm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListCekMotor;
    }

    public String toString() {
        return String.valueOf(no_plat + "| Jenis :" + jenis_motor + "| id pemilik :" + id_pemilik + "| Id Motor :" + id_motor + "| Tarif Motor :" + tarif_motor);
    }

}
