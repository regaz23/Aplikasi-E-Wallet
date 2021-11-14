package Dompet;

public class Pengguna {
    protected String nama, notelp, alamat, noktp;

    public Pengguna(String nama, String notelp, String alamat, String noktp){
        this.nama = nama;
        this.notelp = notelp;
        this.alamat =  alamat;
        this.noktp = noktp;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getNotelp(){
        return notelp;
    }

    public void setNotelp(String notelp){
        this.notelp = notelp;
    }

    public String getAlamat(){
        return alamat;
    }

    public void setAlamat(String alamat){
        this.alamat = alamat;
    }

    public String getNoktp(){
        return noktp;
    }

    public void setNoktp(String noktp){
        this.noktp = noktp;
    }
}
