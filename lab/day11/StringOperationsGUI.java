package lab.day11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StringOperationsGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(880, 565);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(250, 160, 150));

        JLabel inputLabel = new JLabel("Enter the string:");
        inputLabel.setFont(new Font("Arial", Font.BOLD, 14));
        inputLabel.setBounds(50, 150, 200, 30);
        frame.add(inputLabel);

        JTextField inputField = new JTextField();
        inputField.setBounds(250, 150, 300, 30);
        frame.add(inputField);

        JLabel resultLabel = new JLabel("String in upper case:");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        resultLabel.setBounds(50, 200, 200, 30);
        frame.add(resultLabel);

        JTextField resultField = new JTextField();
        resultField.setEditable(false);
        resultField.setBounds(250, 200, 300, 30);
        frame.add(resultField);

        JButton btnCaps = new JButton("IN CAPS");
        btnCaps.setBounds(15, 430, 100, 30);
        frame.add(btnCaps);

        JButton btnSmall = new JButton("IN SMALL");
        btnSmall.setBounds(165, 430, 105, 30);
        frame.add(btnSmall);

        JButton btnConvert = new JButton("CONVERT CASE");
        btnConvert.setBounds(335, 430, 140, 30);
        frame.add(btnConvert);

        JButton btnWords = new JButton("WORDS");
        btnWords.setBounds(545, 430, 100, 30);
        frame.add(btnWords);

        JButton btnLetters = new JButton("LETTERS");
        btnLetters.setBounds(730, 430, 100, 30);
        frame.add(btnLetters);

        JButton btnReverse = new JButton("REVERSE");
        btnReverse.setBounds(90, 468, 100, 30);
        frame.add(btnReverse);

        JButton btnVowels = new JButton("VOWELS");
        btnVowels.setBounds(248, 468, 100, 30);
        frame.add(btnVowels);

        JButton btnFrequency = new JButton("FREQUENCY");
        btnFrequency.setBounds(437, 468, 120, 30);
        frame.add(btnFrequency);

        JButton btnBeginCaps = new JButton("BEGIN CAPS");
        btnBeginCaps.setBounds(625, 468, 120, 30);
        frame.add(btnBeginCaps);

        JButton btnReset = new JButton("RESET");
        btnReset.setBounds(370, 508, 100, 30);
        btnReset.setBackground(Color.BLUE);
        btnReset.setForeground(Color.WHITE);
        btnReset.setOpaque(true);
        frame.add(btnReset);

        btnCaps.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultLabel.setText("String in upper case:");
                resultField.setText(inputField.getText().toUpperCase());
            }
        });

        btnSmall.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultLabel.setText("String in lower case:");
                resultField.setText(inputField.getText().toLowerCase());
            }
        });

        btnConvert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultLabel.setText("Converted case:");
                String str = inputField.getText();
                StringBuilder sb = new StringBuilder();
                for (char c : str.toCharArray()) {
                    if (Character.isUpperCase(c)) sb.append(Character.toLowerCase(c));
                    else if (Character.isLowerCase(c)) sb.append(Character.toUpperCase(c));
                    else sb.append(c);
                }
                resultField.setText(sb.toString());
            }
        });

        btnWords.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultLabel.setText("Number of words:");
                String str = inputField.getText().trim();
                if (str.isEmpty()) {
                    resultField.setText("0");
                } else {
                    resultField.setText(String.valueOf(str.split("\\s+").length));
                }
            }
        });

        btnLetters.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultLabel.setText("Number of letters:");
                int count = 0;
                for (char c : inputField.getText().toCharArray()) {
                    if (Character.isLetter(c)) count++;
                }
                resultField.setText(String.valueOf(count));
            }
        });

        btnReverse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultLabel.setText("Reversed string:");
                resultField.setText(new StringBuilder(inputField.getText()).reverse().toString());
            }
        });

        btnVowels.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultLabel.setText("Number of vowels:");
                int count = 0;
                for (char c : inputField.getText().toLowerCase().toCharArray()) {
                    if ("aeiou".indexOf(c) != -1) count++;
                }
                resultField.setText(String.valueOf(count));
            }
        });

        btnFrequency.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultLabel.setText("Character frequency:");
                String str = inputField.getText();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < str.length(); i++) {
                    char c = str.charAt(i);
                    if (str.indexOf(c) == i) {
                        int freq = 0;
                        for (char ch : str.toCharArray()) {
                            if (ch == c) freq++;
                        }
                        sb.append(c).append(":").append(freq).append(" ");
                    }
                }
                resultField.setText(sb.toString().trim());
            }
        });

        btnBeginCaps.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultLabel.setText("Begin caps:");
                String[] words = inputField.getText().split(" ");
                StringBuilder sb = new StringBuilder();
                for (String w : words) {
                    if (!w.isEmpty()) {
                        sb.append(Character.toUpperCase(w.charAt(0)));
                        sb.append(w.substring(1).toLowerCase());
                        sb.append(" ");
                    }
                }
                resultField.setText(sb.toString().trim());
            }
        });

        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputField.setText("");
                resultField.setText("");
                resultLabel.setText("String in upper case:");
            }
        });

        frame.setVisible(true);
    }
}
