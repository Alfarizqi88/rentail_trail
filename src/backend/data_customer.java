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
 * @author Asus
 */
public class data_customer {
    public int id_customer,cek_save = 0;
    public String nama_customer,no_telepon, alamat;
    
    public data_customer(int id_customer, String nama_customer, String no_telepon, String alamat){
        this.id_customer=id_customer;
        this.nama_customer=nama_customer;
        this.no_telepon=no_telepon;
        this.alamat=alamat;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public data_customer(int id_customer, String nama_customer){
        this.id_customer=id_customer;
        this.nama_customer=nama_customer;
    }
    public data_customer(){
        
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public String getNama_customer() {
        return nama_customer;
    }

    public void setNama_customer(String nama_customer) {
        this.nama_customer = nama_customer;
    }

    public String getNo_telepon() {
        return no_telepon;
    }

    public void setNo_telepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }

    public ArrayList<data_customer> getAll(){
        ArrayList<data_customer> ListDataCustomer=new ArrayList();
        ResultSet rs=DBHelper.selectQuery("SELECT * FROM customer");
        try{
            while(rs.next()){
                data_customer dc=new data_customer();
                dc.setId_customer(rs.getInt("id_customer"));
                dc.setNama_customer(rs.getString("nama_customer"));
                dc.setNo_telepon(rs.getString("no_telepon"));
                dc.setAlamat(rs.getString("alamat"));
                ListDataCustomer.add(dc);
            }
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return ListDataCustomer;
    }
    public data_customer getById(int id_customer) {
        data_customer dc = new data_customer();
        ResultSet rs = DBHelper.selectQuery("select * from customer " + " WHERE id_customer = '" + id_customer + "'");
        try {
            while (rs.next()) {
                dc = new data_customer();
                dc.setId_customer(rs.getInt("id_customer"));
                dc.setNama_customer(rs.getString("nama_customer"));
                dc.setNo_telepon(rs.getString("no_telepon"));
                dc.setAlamat(rs.getString("alamat"));
                cek_save = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dc;
    }
    public void save_data() {

        getById(id_customer);
        if (cek_save == 0) {
            System.out.println("2");
            String SQL = "INSERT into customer (nama_customer , no_telepon,alamat ) values("
//                    + " '" + this.id_customer + " ',"
                    + " '" + this.nama_customer + " ',"
                    + " '" + this.no_telepon + "',"
                    + " '" + this.alamat + "'"
                    + ")";

            DBHelper.executeQuery(SQL);
            System.out.println(SQL);
        } else {
            String sql = "UPDATE customer SET "
                    + " id_customer = '" + this.id_customer + "', "
                    + " nama_customer = '" + this.nama_customer + "', "
                    + " no_telepon = '" + this.no_telepon + "', "
                    + " alamat = '" + this.alamat
                    + "' " + " WHERE id_customer= '" + this.id_customer + "' ";
            DBHelper.executeQuery(sql);
            System.out.println(sql);
        }
    }
    public void cek_data(int id_customer){
        ResultSet rs = DBHelper.selectQuery("Select * from customer where id_customer = '" + id_customer + "'");
        try{
            while(rs.next()){
                setId_customer(rs.getInt("id_customer"));
                setNama_customer(rs.getString("nama_customer"));
                setNo_telepon(rs.getString("no_telepon"));
                setAlamat(rs.getString("alamat"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void delete(int id_customer){
        String sql = "DELETE FROM customer WHERE id_customer = '" + id_customer + "'";
        DBHelper.executeQuery(sql);
    }
    public ArrayList<data_customer> search(String keyword) {
        ArrayList<data_customer> Listkategori = new ArrayList();
        String sql = "select * from customer WHERE " 
                + " id_customer LIKE '%" + keyword + "%' " 
                + " OR nama_customer LIKE '%" + keyword + "%' ";
        ResultSet rs = DBHelper.selectQuery(sql);
        try {
            while (rs.next()) {
                data_customer dc = new data_customer();
                dc.setId_customer(rs.getInt("id_customer"));
                dc.setNama_customer(rs.getString("nama_customer"));
                dc.setNo_telepon(rs.getString("no_telepon"));
                dc.setAlamat(rs.getString("alamat"));
                Listkategori.add(dc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Listkategori;
    }
}
