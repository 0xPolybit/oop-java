package lab.day10;

import javax.swing.*;
import java.awt.event.*;

public class BasicCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My Calc");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel l1 = new JLabel("Enter the First Number:");
        l1.setBounds(50, 50, 150, 30);
        frame.add(l1);

        JTextField t1 = new JTextField();
        t1.setBounds(200, 50, 50, 30);
        frame.add(t1);

        JLabel l2 = new JLabel("Enter the Second Number:");
        l2.setBounds(50, 90, 150, 30);
        frame.add(l2);

        JTextField t2 = new JTextField();
        t2.setBounds(200, 90, 50, 30);
        frame.add(t2);

        JLabel l3 = new JLabel("result:");
        l3.setBounds(50, 130, 150, 30);
        frame.add(l3);

        JTextField t3 = new JTextField();
        t3.setBounds(200, 130, 100, 30);
        t3.setEditable(false);
        frame.add(t3);

        JButton bAdd = new JButton("Add");
        bAdd.setBounds(300, 50, 80, 30);
        frame.add(bAdd);

        JButton bSub = new JButton("subtract");
        bSub.setBounds(390, 50, 100, 30);
        frame.add(bSub);

        JButton bMul = new JButton("multiply");
        bMul.setBounds(500, 50, 100, 30); 
        frame.add(bMul);
        
        frame.setSize(750, 300); 

        JButton bReset = new JButton("reset");
        bReset.setBounds(400, 90, 100, 30);
        frame.add(bReset);

        bAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double n1 = Double.parseDouble(t1.getText());
                    double n2 = Double.parseDouble(t2.getText());
                    t3.setText(String.valueOf(n1 + n2));
                } catch (Exception ex) { t3.setText("Error"); }
            }
        });

        bSub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double n1 = Double.parseDouble(t1.getText());
                    double n2 = Double.parseDouble(t2.getText());
                    t3.setText(String.valueOf(n1 - n2));
                } catch (Exception ex) { t3.setText("Error"); }
            }
        });

        bMul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double n1 = Double.parseDouble(t1.getText());
                    double n2 = Double.parseDouble(t2.getText());
                    t3.setText(String.valueOf(n1 * n2));
                } catch (Exception ex) { t3.setText("Error"); }
            }
        });

        bReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t1.setText("");
                t2.setText("");
                t3.setText("");
            }
        });

        frame.setVisible(true);
    }
}
