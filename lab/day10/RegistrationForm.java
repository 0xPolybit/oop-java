package lab.day10;

import javax.swing.*;
import java.awt.*;

public class RegistrationForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Registration Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(null);

        JLabel titleLabel = new JLabel("User Registration");
        titleLabel.setBounds(130, 20, 150, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(titleLabel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 70, 100, 30);
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(120, 70, 200, 30);
        frame.add(nameField);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(20, 110, 100, 30);
        frame.add(genderLabel);

        JRadioButton male = new JRadioButton("Male");
        male.setBounds(120, 110, 70, 30);
        JRadioButton female = new JRadioButton("Female");
        female.setBounds(200, 110, 80, 30);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        frame.add(male);
        frame.add(female);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(20, 150, 100, 30);
        frame.add(addressLabel);

        JTextArea addressArea = new JTextArea();
        addressArea.setBounds(120, 150, 200, 80);
        addressArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        frame.add(addressArea);

        JLabel hobbyLabel = new JLabel("Hobbies:");
        hobbyLabel.setBounds(20, 240, 100, 30);
        frame.add(hobbyLabel);

        JCheckBox reading = new JCheckBox("Reading");
        reading.setBounds(120, 240, 100, 30);
        JCheckBox music = new JCheckBox("Music");
        music.setBounds(220, 240, 100, 30);
        frame.add(reading);
        frame.add(music);

        JLabel imgLabel = new JLabel("Profile Photo:");
        imgLabel.setBounds(20, 280, 100, 30);
        frame.add(imgLabel);

        JLabel photoBox = new JLabel();
        photoBox.setBounds(120, 280, 100, 100);
        photoBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        photoBox.setHorizontalAlignment(JLabel.CENTER);
        photoBox.setText("No Image");
        frame.add(photoBox);

        JButton submitButton = new JButton("Register");
        submitButton.setBounds(120, 400, 100, 40);
        frame.add(submitButton);

        frame.setVisible(true);
    }
}
