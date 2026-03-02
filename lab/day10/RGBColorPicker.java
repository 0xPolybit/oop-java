package lab.day10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RGBColorPicker {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My Frame");
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        Integer[] values = new Integer[256];
        for (int i = 0; i < 256; i++) {
            values[i] = i;
        }

        JLabel labelRed = new JLabel("Red");
        labelRed.setForeground(Color.RED);
        labelRed.setBounds(20, 20, 30, 30);
        panel.add(labelRed);

        JComboBox<Integer> comboRed = new JComboBox<>(values);
        comboRed.setBounds(50, 20, 60, 30);
        panel.add(comboRed);

        JLabel labelBlue = new JLabel("Blue");
        labelBlue.setForeground(Color.BLUE);
        labelBlue.setBounds(120, 20, 40, 30);
        panel.add(labelBlue);

        JComboBox<Integer> comboBlue = new JComboBox<>(values);
        comboBlue.setBounds(160, 20, 60, 30);
        panel.add(comboBlue);

        JLabel labelGreen = new JLabel("Green");
        labelGreen.setForeground(Color.GREEN);
        labelGreen.setBounds(230, 20, 50, 30);
        panel.add(labelGreen);

        JComboBox<Integer> comboGreen = new JComboBox<>(values);
        comboGreen.setBounds(280, 20, 60, 30);
        panel.add(comboGreen);

        JButton button = new JButton("Show-Output");
        button.setBounds(360, 20, 120, 30);
        panel.add(button);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int r = (int) comboRed.getSelectedItem();
                int g = (int) comboGreen.getSelectedItem();
                int b = (int) comboBlue.getSelectedItem();
                panel.setBackground(new Color(r, g, b));
            }
        });

        frame.setVisible(true);
    }
}
