package GUI;

import Controller.AllObjectController;
import Entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class profileGui extends JFrame{

    public profileGui(int cek){
        comp(cek);
    }
    String email, pass, nama, noktp, notelp, alamat;
    int id;
    JButton btnkembali = new JButton("Kembali");
    JButton btnupdatepass = new JButton("Update");
    JButton btnupdatenotelp = new JButton("Update");
    JButton btnupdatealamat = new JButton("Update");

    JLabel lbemail = new JLabel("Email");
    JLabel lbpass = new JLabel("Password");
    JLabel lbnama = new JLabel("Nama");
    JLabel lbnoktp = new JLabel("No ktp");
    JLabel lbnotelp = new JLabel("No telp");
    JLabel lbalamat = new JLabel("Alamat");

    JTextField txtemail = new JTextField();
    JPasswordField txtpass = new JPasswordField();
    JTextField txtnama = new JTextField();
    JTextField txtnoktp = new JTextField();
    JTextField txtnotelp = new JTextField();
    JTextField txtalamat = new JTextField();

    public void comp(final int cek){
        setTitle("DOMPET DIGITAL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250,400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        for (User userentity : AllObjectController.user.getByid(cek)) {
            this.id = userentity.getId();
            this.email = userentity.getEmail();
            this.pass = userentity.getPass();
            this.nama = userentity.getNama();
            this.noktp = userentity.getNoktp();
            this.notelp = userentity.getNotelp();
            this.alamat = userentity.getAlamat();
        }

        lbemail.setBounds(30,30,100,25);
        add(lbemail);
        lbpass.setBounds(30,60,100,25);
        add(lbpass);
        lbnama.setBounds(30,90,100,25);
        add(lbnama);
        lbnoktp.setBounds(30,120,100,25);
        add(lbnoktp);
        lbnotelp.setBounds(30,150,100,25);
        add(lbnotelp);
        lbalamat.setBounds(30,180,100,25);
        add(lbalamat);

        txtemail.setBounds(60,30,120,25);
        txtemail.setEditable(false);
        add(txtemail);
        txtpass.setBounds(60,60,120,25);
        txtpass.setEditable(false);
        add(txtpass);
        txtnama.setBounds(60,90,120,25);
        txtnama.setEditable(false);
        add(txtnama);
        txtnoktp.setBounds(60,120,120,25);
        txtnoktp.setEditable(false);
        add(txtnoktp);
        txtnotelp.setBounds(60,150,120,25);
        txtnotelp.setEditable(false);
        add(txtnotelp);
        txtalamat.setBounds(60,180,120,25);
        txtalamat.setEditable(false);
        add(txtalamat);

        btnupdatepass.setBounds(150,60,100,25);
        add(btnupdatepass);
        btnupdatenotelp.setBounds(150,150,100,25);
        add(btnupdatenotelp);
        btnupdatealamat.setBounds(150,180,100,25);
        add(btnupdatealamat);

        btnkembali.setBounds(100,200,100,25);
        add(btnkembali);

        btnkembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserGui(cek).setVisible(true);
            }
        });

        btnupdatepass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        btnupdatenotelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        btnupdatealamat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}
