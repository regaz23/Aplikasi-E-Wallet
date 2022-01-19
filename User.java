package Entity;

public class User extends Penduduk {
    protected String email, pass;
    protected int id;
    Rekening saldo;

    public User(String email, String pass, int id, String nama, String noktp, String notelp, String alamat){
        super (nama, noktp, notelp, alamat);
        this.email = email;
        this.pass = pass;
        this.id = id;
    }

    public User(String email, String pass, String nama, String noktp, String notelp, String alamat, Rekening saldo) {
        super (nama, noktp, notelp, alamat);
        this.email = email;
        this.pass = pass;
        this.saldo = saldo;
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

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

}
