package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class gasPumpGui {
    private JLabel regnamelabel;
    private JButton regularbutton;
    private JLabel price;
    private JPanel gaspanel;
    private JButton MidGradeButton;
    private JButton PremiumButton;
    private JTextField $TextField;
    private JButton payButton;
    private JLabel gallonsrecieved;


    public gasPumpGui() {
        regularbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                price.setText("$2.19");
            }
        });
        MidGradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                price.setText("$2.32");
            }
        });
        PremiumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                price.setText("$2.49");
            }
        });
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent){

                if (price.getText().equals("$2.19")){
                    double cash = Double.parseDouble($TextField.getText());
                    Gas gaspump = new Gas("Regular", cash, 0.0);
                    double gallons = gaspump.getRegGallons(cash);
                    gallonsrecieved.setText("" + gallons);
                } else if (price.getText().equals("$2.32")){
                    double cash = Double.parseDouble($TextField.getText());
                    Gas gaspump = new Gas("Mid-Grade", cash, 0.0);
                    double gallons = gaspump.getMidGallons(cash);
                    gallonsrecieved.setText("" + gallons);
                    }

                 else if (price.getText().equals("$2.49")){
                    double cash = Double.parseDouble($TextField.getText());
                    Gas gaspump = new Gas("Premium", cash, 0.0);
                    double gallons = gaspump.getPremGallons(cash);
                    gallonsrecieved.setText("" + gallons);
                } else {
                    JOptionPane.showMessageDialog(null, "Error In Inputs Try Again!!!");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("gasPumpGui");
        frame.setContentPane(new gasPumpGui().gaspanel);
        frame.pack();
        frame.setVisible(true);
    }
}
