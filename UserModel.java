package Model;
import Entity.Rekening;
import Entity.User;
import KoneksiDB.KoneksiDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserModel {
    private String sql;
    Connection conn = KoneksiDB.getconection();

    public List<User> getUser(){
        List<User> arraylistUser = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM user";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()){
                User userEntity = new User(rs.getString("email"),rs.getString("password"),
                        rs.getInt("id"),rs.getString("nama"),rs.getString("noktp"),
                        rs.getString("notelp"),rs.getString("alamat"));
                arraylistUser.add(userEntity);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return arraylistUser;
    }

    public List<User> getUserby(int id){
        List<User> arraylistUser = new ArrayList<>();
        try {
            sql = "SELECT * FROM user where id =?";
            PreparedStatement statAlfa = conn.prepareStatement(sql);
            statAlfa.setInt(1,id);
            ResultSet rs = statAlfa.executeQuery();
            while (rs.next()){
                User userEntity = new User(rs.getString("email"),rs.getString("password"),
                        rs.getInt("id"),rs.getString("nama"),rs.getString("noktp"),
                        rs.getString("notelp"),rs.getString("alamat"));
                arraylistUser.add(userEntity);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return arraylistUser;
    }

    public List<Rekening> getsaldoby(int saldo){
        List<Rekening> arraylistrek = new ArrayList<>();
        try {
            sql = "SELECT * FROM user where id = ?";
            PreparedStatement statAlfa = conn.prepareStatement(sql);
            statAlfa.setInt(1,saldo);
            ResultSet rs = statAlfa.executeQuery();
            while (rs.next()){
                Rekening rek = new Rekening(rs.getInt("saldo"));
                arraylistrek.add(rek);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return arraylistrek;
    }

    public void registrasi(User User){
        try {
            sql = "INSERT INTO user (email, password, nama, noktp, notelp, alamat, saldo) VALUE(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,User.getEmail());
            stat.setString(2,User.getPass());
            stat.setString(3,User.getNama());
            stat.setString(4,User.getNoktp());
            stat.setString(5,User.getNotelp());
            stat.setString(6,User.getAlamat());
            stat.setInt(7,Rekening.getSaldo());

            stat.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
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
            }else {
                cek = 0;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
        }
    }

    public void updateAlamat(String alamat, int id){
        try {
            sql = "update user SET alamat =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,alamat);
            stat.setInt(2,id);

            stat.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void updateSaldo(int saldo, int id){
        try {
            sql = "update user SET saldo =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,saldo);
            stat.setInt(2,id);

            stat.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void Transfers(int idasal, String namapenerima, int jumlah){
        try {
            int asal = cekTFsaldo(idasal);
            int penerima = cekTFsaldo(cekTFid(namapenerima));

            int saldoasal = asal - jumlah;
            int saldopenerima = penerima + jumlah;

            updateSaldo(saldoasal, idasal);
            updateSaldo(saldopenerima, cekTFid(namapenerima));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public int cekTFsaldo(int id){
        int saldo = 0;
        try{
            sql = "SELECT * FROM user WHERE id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                saldo = rs.getInt("saldo");
            }else {
                saldo = 0;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return saldo;
    }

    public int cekTFid(String nama){
        int id = 0;
        try{
            sql = "SELECT * FROM user WHERE nama = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nama);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                id = rs.getInt("id");
            }else {
                id = 0;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return id;
    }
}
