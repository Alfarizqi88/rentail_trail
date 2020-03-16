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
public class data_pemilik {
    
    public int id_pemilik , cek_save = 0 , id_pemilik_baru;
    public String nama_pemilik , no_telepon;

    public data_pemilik(int id_pemilik, String no_telepon, String nama_pemilik) {
        this.id_pemilik = id_pemilik;
        this.no_telepon = no_telepon;
        this.nama_pemilik = nama_pemilik;
    }

    public data_pemilik() {
    }

    public int getId_pemilik_baru() {
        return id_pemilik_baru;
    }

    public void setId_pemilik_baru(int id_pemilik_baru) {
        this.id_pemilik_baru = id_pemilik_baru;
    }
    
    public int getId_pemilik() {
        return id_pemilik;
    }

    public void setId_pemilik(int id_pemilik) {
        this.id_pemilik = id_pemilik;
    }

    public String getNo_telepon() {
        return no_telepon;
    }

    public void setNo_telepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }

    public String getNama_pemilik() {
        return nama_pemilik;
    }

    public void setNama_pemilik(String nama_pemilik) {
        this.nama_pemilik = nama_pemilik;
    }
    
    public data_pemilik getById(int id_pemilik){
        data_pemilik dp=new data_pemilik();
        ResultSet rs= DBHelper.selectQuery("select * from pemilik_motor " + " WHERE id_pemilik = '"+ id_pemilik + "'");
        try{
            while(rs.next()){
                dp=new data_pemilik();
                dp.setNama_pemilik(rs.getString("nama_pemilik"));
                dp.setNo_telepon(rs.getString("no_telepon"));
                cek_save=1;
            }
        }catch(Exception e){
            e.printStackTrace();
        }        
        return dp;
    }
     
    public void cari_id(String nama_pemilik_baru){
        data_pemilik dp = new data_pemilik();    
        String sql = "select * from pemilik_motor WHERE " 
            + " nama_pemilik = '" + nama_pemilik_baru +"'"  ;
            ResultSet rs = DBHelper.selectQuery(sql);
            System.out.println(sql);
        try {
            while (rs.next()) {      
                id_pemilik_baru = rs.getInt("id_pemilik");
                //dp.setId_pemilik_baru(rs.getInt("id_pemilik"));
                System.out.println(id_pemilik_baru + "cek id");   
            }
        } catch (Exception e) {
            e.printStackTrace();
        }           
    }
    
    public void save_data(){
        getById(id_pemilik);
        if (cek_save == 0){
//            System.out.println(getById(id_pemilik).id_pemilik);
//            System.out.println(id_pemilik);
            System.out.println("2");
            String SQL = "INSERT into pemilik_motor (nama_pemilik , no_telepon) values("
                    + " '" + this.nama_pemilik + " ',"
                    + " '" + this.no_telepon + "'"
                    + ")";

            DBHelper.executeQuery(SQL);
            System.out.println(SQL);
            //konfirm_save_detail = 1;
        }else {
            String sql = "UPDATE pemilik_motor SET "                   
                    + " nama_pemilik = '"+ this.nama_pemilik + "', "
                    + " no_telepon = '" + this.no_telepon 
                    + "' "+" WHERE id_pemilik= '"+ this.id_pemilik+"' ";
            DBHelper.executeQuery(sql);
        }
    }
     
    public ArrayList<data_pemilik> search(String keyword) {
        ArrayList<data_pemilik> Listkategori = new ArrayList();
        String sql = "select * from pemilik_motor WHERE " 
                + " id_pemilik LIKE '%" + keyword + "%' " 
                + " OR nama_pemilik LIKE '%" + keyword + "%' ";
        ResultSet rs = DBHelper.selectQuery(sql);
        try {
            while (rs.next()) {
                 data_pemilik dp = new data_pemilik();                
                dp.setId_pemilik(rs.getInt("id_pemilik"));
                dp.setNama_pemilik(rs.getString("nama_pemilik"));
                dp.setNo_telepon(rs.getString("no_telepon"));
                Listkategori.add(dp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Listkategori;
    }

    public ArrayList<data_pemilik> getAll() {
        ArrayList<data_pemilik> Listkategori = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("select * from pemilik_motor ");
        try {
            while (rs.next()) {
                data_pemilik dp = new data_pemilik();                
                dp.setId_pemilik(rs.getInt("id_pemilik"));
                dp.setNama_pemilik(rs.getString("nama_pemilik"));
                dp.setNo_telepon(rs.getString("no_telepon"));
                Listkategori.add(dp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Listkategori;
    }
    
    public void delete(int id_pemilik){
        String sql = "DELETE FROM pemilik_motor WHERE id_pemilik = '" + id_pemilik + "'";
        DBHelper.executeQuery(sql);
    }
//    public String toString(){
//        return String.valueOf( nama_pemilik);
//    }
    public String toString(){
        return String.valueOf("id pemilik :" + id_pemilik + "| nama pemilik :" + nama_pemilik);
    }
}
