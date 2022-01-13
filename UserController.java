package Controller;

import Entity.Rekening;
import Entity.User;
import Model.AllObjectModel;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    public void registrasi (String email, String pass, String nama, String noktp, String notelp, String alamat, int saldo){
        User userEntity = new User(email, pass, nama, noktp, notelp, alamat);
        Rekening rek = new Rekening(saldo);
        AllObjectModel.userModel.registrasi(userEntity);
    }

    public void update(int pilih, String data, int id){
        switch (pilih){
            case 1:
                AllObjectModel.userModel.updatePassword(data,id);
                break;
            case 2:
                AllObjectModel.userModel.updateNotelp(data,id);
                break;
            case 3:
                AllObjectModel.userModel.updateAlamat(data,id);
                break;
        }
    }

    public List<User> getDataUser(){
        return AllObjectModel.userModel.getUser();
    }
    public List<Rekening> getSaldo(int cek) {return  AllObjectModel.userModel.getsaldoby(cek);}
    public List<User> getByid(int cek){
        return AllObjectModel.userModel.getUserby(cek);
    }

    public int login(String email, String pass){
        int cek = AllObjectModel.userModel.cekLogin(email,pass);
        return cek;
    }
}
