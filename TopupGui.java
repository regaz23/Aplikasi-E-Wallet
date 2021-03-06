package GUI;

import Controller.AllObjectController;
import Entity.Rekening;
import Model.AllObjectModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopupGui extends JFrame {
    private int saldo;

    public TopupGui(int cek) {
        comp(cek);
    }

    protected JLabel lbjmlh = new JLabel("Masukan Nominal");

    protected JTextField txtjmlh = new JTextField();

    protected JButton btnconfirm = new JButton("Confirm");
    protected JButton btnkembali = new JButton("Back");

    private void comp(final int cek) {
        for (Rekening rekening : AllObjectController.user.getSaldo(cek)) {
            this.saldo = rekening.getSaldo();
        }
        setTitle("Registrasi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350,400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        lbjmlh.setBounds(30,30,100,25);
        add(lbjmlh);
        txtjmlh.setBounds(60,30,100,25);
        add(txtjmlh);

        btnconfirm.setBounds(60,60,100,25);
        add(btnconfirm);
        btnkembali.setBounds(10,10,100,25);
        add(btnkembali);

        btnconfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nominal = Integer.parseInt(txtjmlh.getText());
                int saldobaru = saldo + nominal;
                AllObjectModel.userModel.updateSaldo(saldobaru,cek);
                dispose();
                new UserGui(cek).setVisible(true);
            }
        });

        btnkembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserGui(cek).setVisible(true);
            }
        });
    }
}
