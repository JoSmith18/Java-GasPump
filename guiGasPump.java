package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guiGasPump extends JPanel {

    private JPanel panel1;
    private JButton premium;
    private JButton midGrade;
    private JButton Regular;
    private JTextField gallons;
    private JButton calculate;
    private JLabel price;
    private JLabel total;

    public guiGasPump() {
        this.setLayout(new BorderLayout());
        this.add(new JButton());
//        Regular.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent arg0) {
//                price.setText("2.19");
//            }
//        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setContentPane(new guiGasPump());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setTitle("GUI GAS PUMP RULEZZ");
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
