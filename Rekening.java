package Entity;

public class Rekening {
    protected int saldo;

    public Rekening(int saldo){
        this.saldo = saldo;
    }

    public int getSaldo (){
        return saldo;
    }
    public void setSaldo(int saldo){
        this.saldo = saldo;
    }
}
