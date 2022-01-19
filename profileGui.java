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
    protected JButton btnkembali = new JButton("Kembali");
    protected JButton btnupdatepass = new JButton("Update");
    protected JButton btnupdatenotelp = new JButton("Update");
    protected JButton btnupdatealamat = new JButton("Update");

    protected JLabel lbemail = new JLabel("Email");
    protected JLabel lbpass = new JLabel("Password");
    protected JLabel lbnama = new JLabel("Nama");
    protected JLabel lbnoktp = new JLabel("No ktp");
    protected JLabel lbnotelp = new JLabel("No telp");
    protected JLabel lbalamat = new JLabel("Alamat");

    protected JTextField txtemail = new JTextField();
    protected JPasswordField txtpass = new JPasswordField();
    protected JTextField txtnama = new JTextField();
    protected JTextField txtnoktp = new JTextField();
    protected JTextField txtnotelp = new JTextField();
    protected JTextField txtalamat = new JTextField();

    public void comp(final int cek){
        setTitle("DOMPET DIGITAL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350,400);
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

        txtemail.setBounds(80,30,120,25);
        txtemail.setText(email);
        txtemail.setEditable(false);
        add(txtemail);
        txtpass.setBounds(80,60,120,25);
        txtpass.setText(pass);
        txtpass.setEditable(false);
        add(txtpass);
        txtnama.setBounds(80,90,120,25);
        txtnama.setText(nama);
        txtnama.setEditable(false);
        add(txtnama);
        txtnoktp.setBounds(80,120,120,25);
        txtnoktp.setText(noktp);
        txtnoktp.setEditable(false);
        add(txtnoktp);
        txtnotelp.setBounds(80,150,120,25);
        txtnotelp.setText(notelp);
        txtnotelp.setEditable(false);
        add(txtnotelp);
        txtalamat.setBounds(80,180,120,25);
        txtalamat.setText(alamat);
        txtalamat.setEditable(false);
        add(txtalamat);

        btnupdatepass.setBounds(220,60,100,25);
        add(btnupdatepass);
        btnupdatenotelp.setBounds(220,150,100,25);
        add(btnupdatenotelp);
        btnupdatealamat.setBounds(220,180,100,25);
        add(btnupdatealamat);

        btnkembali.setBounds(100,230,100,25);
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
                try{
                    String inputpass = JOptionPane.showInputDialog("Masukkan Nama Baru");
                    if(inputpass.length() >0){
                        AllObjectController.user.update(1, inputpass,cek);
                        txtpass.setText(inputpass);
                    }else {
                        JOptionPane.showMessageDialog(null,"Data Kosong");
                    }
                }catch (Exception ex){

                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });

        btnupdatenotelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String inputnotelp = JOptionPane.showInputDialog("Masukkan Nama Baru");
                    if(inputnotelp.length() >0){
                        AllObjectController.user.update(2, inputnotelp,cek);
                        txtnotelp.setText(inputnotelp);
                    }else {
                        JOptionPane.showMessageDialog(null,"Data Kosong");
                    }
                }catch (Exception ex){

                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });

        btnupdatealamat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String inputalamat = JOptionPane.showInputDialog("Masukkan Nama Baru");
                    if(inputalamat.length() >0){
                        AllObjectController.user.update(3, inputalamat,cek);
                        txtalamat.setText(inputalamat);
                    }else {
                        JOptionPane.showMessageDialog(null,"Data Kosong");
                    }
                }catch (Exception ex){

                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
    }
}
