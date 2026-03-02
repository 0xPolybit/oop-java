package lab.day10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorChanger {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My frame");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        String[] colors = {"white", "orange", "red", "blue"};
        JList<String> colorList = new JList<>(colors);
        colorList.setBounds(150, 20, 80, 80);
        colorList.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(colorList);

        JButton button = new JButton("Click");
        button.setBounds(240, 45, 80, 30);
        panel.add(button);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selected = colorList.getSelectedValue();
                if (selected != null) {
                    switch (selected) {
                        case "white": panel.setBackground(Color.WHITE); break;
                        case "orange": panel.setBackground(Color.ORANGE); break;
                        case "red": panel.setBackground(Color.RED); break;
                        case "blue": panel.setBackground(Color.BLUE); break;
                    }
                }
            }
        });

        frame.setVisible(true);
    }
}
