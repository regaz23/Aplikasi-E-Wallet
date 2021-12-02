package Entity;

public class User extends Penduduk {
    protected String email, pass;
    protected int id;

    public User(){
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
