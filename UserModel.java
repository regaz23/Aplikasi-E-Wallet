package Model;
import Entity.Rekening;
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
                User userEntity = new User(rs.getString("email"),rs.getString("password"),
                        rs.getInt("id"),rs.getString("nama"),rs.getString("noktp"),
                        rs.getString("notelp"),rs.getString("alamat"));
                arraylistUser.add(userEntity);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return arraylistUser;
    }

    public ArrayList<User> getUserby(int id){
        ArrayList<User> arraylistUser = new ArrayList<>();
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
            System.out.println(e);
        }
        return arraylistUser;
    }

    public ArrayList<Rekening> getsaldoby(int saldo){
        ArrayList<Rekening> arraylistrek = new ArrayList<>();
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
            System.out.println(e);
        }
        return arraylistrek;
    }
    //VALUE('%s', '%s', '%s', '%s', '%s', '%s', '%d')

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
            stat.setInt(7,User.getSaldo());

            stat.executeUpdate();
        }catch (SQLException e){
            System.out.println("Gagal Registrasi!!");
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
            System.out.println("Password / Email Salah!!");
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
            System.out.println("Gagal Ubah Alamat!!");
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
            System.out.println(e);
        }
    }

    public void Transfers(String namaasal, String namapenerima, int jumlah){
        int asal = cekTF(namaasal);
        int penerima = cekTF(namapenerima);

        int saldoasal = asal - jumlah;
        int saldopenerima = penerima + jumlah;

        updateSaldo(saldoasal,asal);
        updateSaldo(saldopenerima,penerima);
    }

    public int cekTF(String nama){
        int saldo = 0;
        try{
            sql = "SELECT * FROM user WHERE nama = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,nama);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                saldo = rs.getInt("saldo");
            }else {
                saldo = 0;
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return saldo;
    }
}
