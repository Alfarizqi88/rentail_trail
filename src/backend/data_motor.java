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
public class data_motor {

    public int id_motor, id_pemilik, tarif_motor, cek_save = 0 , jml_motor_all;
    public String no_plat, no_mesin, jenis_motor , nama_pemilik;

    public data_motor(int id_motor, int id_pemilik, int tarif_motor, String no_plat, String no_mesin, String jenis_motor) {
        this.id_motor = id_motor;
        this.id_pemilik = id_pemilik;
        this.tarif_motor = tarif_motor;
        this.no_plat = no_plat;
        this.no_mesin = no_mesin;
        this.jenis_motor = jenis_motor;
    }

    public data_motor() {
    }

    public int getJml_motor_all() {
        return jml_motor_all;
    }

    public void setJml_motor_all(int jml_motor_all) {
        this.jml_motor_all = jml_motor_all;
    }

    public String getNama_pemilik() {
        return nama_pemilik;
    }

    public void setNama_pemilik(String nama_pemilik) {
        this.nama_pemilik = nama_pemilik;
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

    public String getNo_mesin() {
        return no_mesin;
    }

    public void setNo_mesin(String no_mesin) {
        this.no_mesin = no_mesin;
    }

    public String getJenis_motor() {
        return jenis_motor;
    }

    public void setJenis_motor(String jenis_motor) {
        this.jenis_motor = jenis_motor;
    }

    public ArrayList<data_motor> getAll() {
        ArrayList<data_motor> ListDataMotor = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM motor k inner join pemilik_motor p on p.id_pemilik = k.id_pemilik ORDER BY id_motor ASC");
        try {
            while (rs.next()) {
                data_motor dm = new data_motor();
                dm.setId_motor(rs.getInt("id_motor"));
                dm.setId_pemilik(rs.getInt("id_pemilik"));
                dm.setNama_pemilik(rs.getString("nama_pemilik"));
                dm.setNo_plat(rs.getString("no_plat"));
                dm.setNo_mesin(rs.getString("no_mesin"));
                dm.setJenis_motor(rs.getString("jenis_motor"));
                dm.setTarif_motor(rs.getInt("tarif_motor"));

                ListDataMotor.add(dm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListDataMotor;
    }
   
    public data_motor htng_jml_mtr() {
        data_motor dm = new data_motor();
        ResultSet rs = DBHelper.selectQuery("select COUNT(id_motor) as hitung from motor " );
      
        try {
            while (rs.next()) {
                dm = new data_motor();
                dm.setJml_motor_all(rs.getInt("hitung"));
                System.out.println(jml_motor_all);
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dm;
    }

    public data_motor getById(String no_plat) {
        data_motor dm = new data_motor();
        ResultSet rs = DBHelper.selectQuery("select * from motor " + " WHERE no_plat = '" + no_plat + "'");
        try {
            while (rs.next()) {
                dm = new data_motor();
                dm.setId_pemilik(rs.getInt("id_pemilik"));
                dm.setNo_plat(rs.getString("no_plat"));
                dm.setNo_mesin(rs.getString("no_mesin"));
                dm.setJenis_motor(rs.getString("jenis_motor"));
                dm.setTarif_motor(rs.getInt("tarif_motor"));

                cek_save = 1;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dm;
    }

    public void save_data() {
        getById(no_plat);
        if (cek_save == 0) {
            System.out.println("2");
            String SQL = "INSERT into motor (id_pemilik , no_plat , no_mesin , jenis_motor , tarif_motor) values("
                    + " '" + this.id_pemilik + " ',"
                    + " '" + this.no_plat + " ',"
                    + " '" + this.no_mesin + " ',"
                    + " '" + this.jenis_motor + " ',"
                    + " '" + this.tarif_motor + "'"
                    + ")";

            DBHelper.executeQuery(SQL);
            System.out.println(SQL);
            //konfirm_save_detail = 1;
        } else {
            String sql = "UPDATE motor SET "
                    + " id_pemilik = '" + this.id_pemilik + "', "
                    + " no_mesin = '" + this.no_mesin + "', "
                    + " jenis_motor = '" + this.jenis_motor + "', "
                    + " tarif_motor = '" + this.tarif_motor
                    + "' " + " WHERE no_plat= '" + this.no_plat + "' ";
            DBHelper.executeQuery(sql);
            System.out.println(sql);
        }
    }
    
    public void delete(int id_motor){
        String sql = "DELETE FROM motor WHERE id_motor = '" + id_motor + "'";
        DBHelper.executeQuery(sql);
    }

    public String toString(){
        return String.valueOf(no_plat + "| Jenis :" + jenis_motor + "| id pemilik :" + id_pemilik + "| Id Motor :" + id_motor + "| Tarif Motor :" + tarif_motor);
    }
    
    public ArrayList<data_motor> search(String keyword) {
        ArrayList<data_motor> Listkategori = new ArrayList();
        String sql = "SELECT m.id_motor , m.id_pemilik , pm.nama_pemilik ,\n"
                + "m.no_plat , m.no_mesin , m.jenis_motor , m.tarif_motor\n"
                + "FROM motor m \n"
                + "inner join pemilik_motor pm\n"
                + "on pm.id_pemilik = m.id_pemilik  WHERE\n"
                + " m.id_motor LIKE '%" + keyword + "%' "
                + " OR m.jenis_motor LIKE '%" + keyword + "%' "
                + " OR m.tarif_motor LIKE '%" + keyword + "%' ";
        ResultSet rs = DBHelper.selectQuery(sql);
        try {
            while (rs.next()) {
                data_motor dm = new data_motor();
                dm = new data_motor();
                dm.setId_motor(rs.getInt("m.id_motor"));
                dm.setId_pemilik(rs.getInt("m.id_pemilik"));
                dm.setNama_pemilik(rs.getString("pm.nama_pemilik"));
                dm.setNo_plat(rs.getString("m.no_plat"));
                dm.setNo_mesin(rs.getString("m.no_mesin"));
                dm.setJenis_motor(rs.getString("m.jenis_motor"));
                dm.setTarif_motor(rs.getInt("m.tarif_motor"));

                Listkategori.add(dm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Listkategori;
    }
}
