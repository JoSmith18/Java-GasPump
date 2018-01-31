package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;

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

    private static void setText(final JLabel label, final String text){
        label.setText(text);
        label.paintImmediately(label.getVisibleRect());
    }

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

                    setText(gallonsrecieved, "" + 0.0);

                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            double filled = 0.0;
                            double print_filled = 0.0;
                            while (filled <= gallons) {
                                filled += 0.01;
                                print_filled = Math.round(filled * 100.00) / 100.00;
                                setText(gallonsrecieved, "" + print_filled);
                                System.out.println(print_filled);
                            }
                            gallonsrecieved.setText("" + gallons);
                        }
                    });

                } else if (price.getText().equals("$2.32")){
                    double cash = Double.parseDouble($TextField.getText());
                    Gas gaspump = new Gas("Mid-Grade", cash, 0.0);
                    double gallons = gaspump.getMidGallons(cash);
//                    new Timer(600, a);
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

        gallonsrecieved.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                try {
                    Thread.sleep(75);

                } catch (InterruptedException e){

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
