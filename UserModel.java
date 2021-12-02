package Model;
import Entity.User;
import KoneksiDB.KoneksiDB;
import java.sql.*;
import java.util.ArrayList;

public class UserModel {
    private String sql;
    Connection conn = KoneksiDB.getconection();

    public ArrayList<User> getUser(){
        ArrayList<User> arraylistUser = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM user";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()){
                User userEntity = new User();
                userEntity.setId(rs.getInt("id"));
                userEntity.setEmail(rs.getString("email"));
                userEntity.setPass(rs.getString("password"));
                userEntity.setNama(rs.getString("nama"));
                userEntity.setNoktp(rs.getString("noktp"));
                userEntity.setNotelp(rs.getString("notelp"));
                userEntity.setAlamat(rs.getString("alamat"));
                arraylistUser.add(userEntity);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return arraylistUser;
    }

    public void registrasi(User User){
        try {
            sql = "INSERT INTO user (email, password, nama, noktp, notelp, alamat) VALUE('%s', '%s', '%s', '%s', '%s', '%s')";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,User.getEmail());
            stat.setString(2,User.getPass());
            stat.setString(3,User.getNama());
            stat.setString(4,User.getNoktp());
            stat.setString(5,User.getNotelp());
            stat.setString(6,User.getAlamat());

            stat.executeUpdate();
        }catch (SQLException e){
            System.out.println("Gagal Registrasi!!");
            e.printStackTrace();
        }
    }

    public int cekLogin(String email, String pass){
        int cek = 0;
        try {
            sql = "SELECT * FROM user where email =? and password =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,email);
            stat.setString(2,pass);
            ResultSet rs = stat.executeQuery();
            if (rs.next()){
                cek = rs.getInt("id");
                String nama = rs.getString("nama");
                System.out.println("Selamat Datang " + nama);
            }else {
                cek = 0;
            }
        }catch (SQLException e){
            System.out.println("Password / Email Salah!!");
            e.printStackTrace();
        }return cek;
    }

    public void updatePassword(String pass, int id){
        try {
            sql = "update user SET password =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,pass);
            stat.setInt(2,id);

            stat.executeUpdate();
        }catch (SQLException e){
            System.out.println("Gagal Ubah Password!!");
            e.printStackTrace();
        }
    }

    public void updateNotelp(String notelp, int id){
        try {
            sql = "update user SET noTelp =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,notelp);
            stat.setInt(2,id);

            stat.executeUpdate();
        }catch (SQLException e){
            System.out.println("Gagal Mengubah Nomor Telepon!!");
            e.printStackTrace();
        }
    }

    public void updateAlamat(String alamat, int id){
        try {
            sql = "update userSET noTelp =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,alamat);
            stat.setInt(2,id);

            stat.executeUpdate();
        }catch (SQLException e){
            System.out.println("Gagal Ubah Alamat!!");
            e.printStackTrace();
        }
    }

}
