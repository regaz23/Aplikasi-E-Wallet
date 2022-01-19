package Entity;

public class Rekening {
    protected static int saldo;

    public Rekening(int saldo){
        this.saldo = saldo;
    }

    public static int getSaldo(){
        return saldo;
    }
    public void setSaldo(int saldo){
        this.saldo = saldo;
    }
}
