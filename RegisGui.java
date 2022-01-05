package GUI;

import Controller.AllObjectController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisGui extends JFrame{
    public RegisGui(){comp();}
    JLabel lbemail = new JLabel("Email");
    JLabel lbpass = new JLabel("Password");
    JLabel lbnama = new JLabel("Nama");
    JLabel lbnoktp = new JLabel("No. ktp");
    JLabel lbnotelp = new JLabel("No. telp");
    JLabel lbalamat = new JLabel("Alamat");

    JTextField txtemail = new JTextField();
    JPasswordField txtpass = new JPasswordField();
    JTextField txtnama = new JTextField();
    JTextField txtnoktp = new JTextField();
    JTextField txtnotelp = new JTextField();
    JTextField txtalamat = new JTextField();

    JButton btnregis = new JButton("Daftarkan");

    void kosong (){
        txtemail.setText(null);
        txtpass.setText(null);
    }

    private void comp(){
        setTitle("Registrasi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350,400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        lbnama.setBounds(100,40,100,25);
        add(lbnama);

        txtnama.setBounds(150,40,100,25);
        add(txtnama);

        lbnoktp.setBounds(100,70,100,25);
        add(lbnoktp);

        txtnoktp.setBounds(150,70,100,25);
        add(txtnoktp);

        lbnotelp.setBounds(100,100,100,25);
        add(lbnotelp);

        txtnotelp.setBounds(150,100,100,25);
        add(txtnotelp);

        lbalamat.setBounds(100,130,100,25);
        add(lbalamat);

        txtalamat.setBounds(150,130,100,25);
        add(txtalamat);

        lbemail.setBounds(100,160,100,25);
        add(lbemail);

        txtemail.setBounds(150,160,100,25);
        add(txtemail);

        lbpass.setBounds(80,190,120,25);
        add(lbpass);

        txtpass.setBounds(150,190,100,25);
        add(txtpass);

        btnregis.setBounds(150,230,100,25);
        add(btnregis);

        btnregis.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String nama = txtnama.getText();
                String noktp = txtnoktp.getText();
                String notelp = txtnotelp.getText();
                String alamat = txtalamat.getText();
                String email = txtemail.getText();
                String pass = txtpass.getText();
                int saldo = 0;
                if(nama.length() != 0 && noktp.length() != 0 && notelp.length() != 0 && alamat.length() != 0
                && email.length() != 0 && pass.length() != 0){
                    AllObjectController.user.registrasi(email, pass, nama, noktp, notelp, alamat, saldo);
                    JOptionPane.showMessageDialog(null, "Silahkan Login Kembali");
                    dispose();
                    new LoginGui().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
                    kosong();
                }
            }
        });
    }
}
