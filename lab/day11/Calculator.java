package lab.day11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CALCULATOR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(290, 235);
        frame.setLayout(new BorderLayout(2, 2));
        frame.getContentPane().setBackground(Color.CYAN);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        topPanel.setBackground(Color.CYAN);

        JLabel titleLabel = new JLabel("CALCULATOR");
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(180, 230, 255));
        titleLabel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        JTextField display = new JTextField("0", 10);
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);

        topPanel.add(titleLabel);
        topPanel.add(display);
        frame.add(topPanel, BorderLayout.NORTH);

        JPanel gridPanel = new JPanel(new GridLayout(4, 4, 2, 2));
        gridPanel.setBackground(Color.CYAN);
        gridPanel.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));

        String[] labels = {"1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", "/", "0", "%", "="};

        double[] firstNum = {0};
        String[] operator = {""};
        boolean[] newInput = {true};

        for (String label : labels) {
            JButton btn = new JButton(label);
            if (label.matches("[0-9]")) {
                btn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (newInput[0]) {
                            display.setText(e.getActionCommand());
                            newInput[0] = false;
                        } else {
                            display.setText(display.getText() + e.getActionCommand());
                        }
                    }
                });
            } else if (label.equals("=")) {
                btn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (operator[0].isEmpty()) return;
                        double secondNum = Double.parseDouble(display.getText());
                        double result = 0;
                        switch (operator[0]) {
                            case "+": result = firstNum[0] + secondNum; break;
                            case "-": result = firstNum[0] - secondNum; break;
                            case "*": result = firstNum[0] * secondNum; break;
                            case "/":
                                if (secondNum == 0) {
                                    display.setText("Error");
                                    operator[0] = "";
                                    newInput[0] = true;
                                    return;
                                }
                                result = firstNum[0] / secondNum;
                                break;
                            case "%": result = firstNum[0] % secondNum; break;
                        }
                        if (result == (long) result) {
                            display.setText(String.valueOf((long) result));
                        } else {
                            display.setText(String.valueOf(result));
                        }
                        operator[0] = "";
                        newInput[0] = true;
                    }
                });
            } else {
                btn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        firstNum[0] = Double.parseDouble(display.getText());
                        operator[0] = e.getActionCommand();
                        newInput[0] = true;
                    }
                });
            }
            gridPanel.add(btn);
        }

        frame.add(gridPanel, BorderLayout.CENTER);

        JPanel offPanel = new JPanel(new GridLayout(1, 1));
        offPanel.setBackground(Color.CYAN);
        offPanel.setBorder(BorderFactory.createEmptyBorder(2, 5, 5, 5));
        JButton offBtn = new JButton("OFF");
        offBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        offPanel.add(offBtn);
        frame.add(offPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
