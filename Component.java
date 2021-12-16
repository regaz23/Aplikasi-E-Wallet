package GUI;

import javax.swing.*;

public class Component extends JFrame {
    //label
    protected JLabel jmlhsaldo = new JLabel();
    protected JLabel lbsaldo = new JLabel("Saldo");
    protected JLabel email = new JLabel("Email");
    protected JLabel pass = new JLabel("Password");
    protected JLabel welcome = new JLabel();

    //button
    protected JButton btnlogin = new JButton("Login");
    protected JButton btnregis = new JButton("Register");
    protected JButton btntopup = new JButton("Top Up");
    protected JButton btnTrans = new JButton("Transfer");
    protected JButton btnHisto = new JButton("History Transaksi");

    //field
    protected JTextField jtxtemail = new JTextField();
    protected JPasswordField jtxtpass = new JPasswordField();

    protected void kosong(){
        jtxtemail.setText(null);
        jtxtpass.setText(null);
    }
}
