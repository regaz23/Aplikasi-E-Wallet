package Dompet;

public class User extends Pengguna{
    private String email, pass;

    public User(String email, String pass, String nama, String notelp, String alamat, String noktp){
        super(nama,notelp,alamat,noktp);
        this.email = email;
        this.pass = pass;
    }

    public String getEmail (){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPass(){
        return pass;
    }

    public void setPass(String pass){
        this.pass = pass;
    }

}
