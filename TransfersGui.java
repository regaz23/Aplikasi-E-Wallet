package GUI;

import Model.AllObjectModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransfersGui extends JFrame {
    public TransfersGui(int cek) {
        comp(cek);
    }
    protected JLabel lbnamapenerima = new JLabel("Nama Penerima");
    protected JLabel lbnominal = new JLabel("Nominal Transfer");

    protected JTextField txtnamapenerima = new JTextField();
    protected JTextField txtnominal = new JTextField();

    protected JButton btnconfirm = new JButton("Confirm");
    protected JButton btnkembali = new JButton("Back");

    private void comp(final int cek){
        setTitle("Registrasi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350,400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        lbnamapenerima.setBounds(30,50,100,25);
        add(lbnamapenerima);
        txtnamapenerima.setBounds(120,50,100,25);
        add(txtnamapenerima);
        lbnominal.setBounds(30,90,100,25);
        add(lbnominal);
        txtnominal.setBounds(120,90,100,25);
        add(txtnominal);

        btnconfirm.setBounds(80,120,100,25);
        add(btnconfirm);
        btnkembali.setBounds(10,10,100,25);
        add(btnkembali);

        btnconfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nominal = Integer.parseInt(txtnominal.getText());
                AllObjectModel.userModel.Transfers(cek,txtnamapenerima.getText(),nominal);
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
