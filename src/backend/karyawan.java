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
public class karyawan {
    
   public int id_admin;
    String username , password;

    public karyawan(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public karyawan() {
    }

    public int getId_Admin() {
        return id_admin;
    }
    
    public void setId_Admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public karyawan login(String username ,String password)
    {
        karyawan kr=new karyawan();
        ResultSet rs= DBHelper.selectQuery("SELECT * FROM admin " + " WHERE username = '"+ username + "'" + "AND password = '" + password + "'");
        try{
            while(rs.next()){
                kr=new karyawan();
                kr.setId_Admin(rs.getInt("id_admin"));
                kr.setUsername(rs.getString("username"));
                kr.setPassword(rs.getString("password")); 
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return kr;
    }
    public void register(){
//        if (cek_save == 0) {
//            System.out.println("2");
            String SQL = "INSERT into admin (username , password) values("
                    + " '" + this.username + " ',"
                    + " '" + this.password +  "'"
                    + ")";

            DBHelper.executeQuery(SQL);
            System.out.println(SQL);
            //konfirm_save_detail = 1;
//        }
    }
}
