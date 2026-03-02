# Day 10: GUI Programming (Swing) - Common Errors

---

## Question 1: Basic Calculator

### Source Code

```java
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
```

### Sample Input/Output

**Input:** Enter `10` in the first field and `5` in the second field, then click **Add**

**Output:** Result field displays `15.0`

**Input:** Enter `abc` in the first field and click **Add**

**Output:** Result field displays `Error`

### Common Errors

| Sl No. | Error | Error Type | Error Fix |
|--------|-------|------------|-----------|
| 1 | `NumberFormatException` when a text field is left empty or contains non-numeric text; silently shows "Error" with no explanation | Runtime | Display a specific message such as `"Invalid input"` in the result field, or show a `JOptionPane` dialog to guide the user |
| 2 | The Multiply button is placed at x=500 which is outside the initial frame width of 500; `frame.setSize(750, 300)` is called after adding the button, so the button may briefly appear invisible before the pack | Logical | Set the final frame size once before adding all components, or call `frame.revalidate()` after resizing |
| 3 | There is no division operation; dividing by zero is never handled, leaving a gap in calculator functionality | Logical | Add a Divide button with an explicit check for zero denominator before performing division, displaying a `"Division by zero"` message if needed |

---

## Question 2: Color Changer

### Source Code

```java
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
```

### Sample Input/Output

**Input:** Select `red` from the list and click **Click**

**Output:** Panel background changes to red

**Input:** Click **Click** without selecting any color

**Output:** Nothing happens (no feedback given to the user)

### Common Errors

| Sl No. | Error | Error Type | Error Fix |
|--------|-------|------------|-----------|
| 1 | Clicking the button without selecting a color does nothing silently; the user receives no feedback | Logical | Add an `else` branch to show a `JOptionPane.showMessageDialog` prompting the user to select a color first |
| 2 | After the panel background changes to a dark color like `blue` or `red`, the `JList` text becomes hard to read since its background remains white but the surrounding panel is dark, creating a jarring visual mismatch | Logical | Wrap the list and button in a separate sub-panel with a fixed background, or place the controls in a dedicated top bar separate from the color preview area |
| 3 | Using `panel.setLayout(null)` with fixed `setBounds` makes the layout break when the frame is resized, as components do not reposition or scale | Logical | Use a standard `LayoutManager` such as `BorderLayout` or `FlowLayout` so components adapt to frame resizing |

---

## Question 3: Registration Form

### Source Code

```java
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
```

### Sample Input/Output

**Input:** Fill in Name, select Gender, enter Address, check Hobbies, click **Register**

**Output:** GUI form is displayed; no action occurs on button click (no ActionListener attached)

### Common Errors

| Sl No. | Error | Error Type | Error Fix |
|--------|-------|------------|-----------|
| 1 | The Register button has no `ActionListener` attached, so clicking it does nothing; form data is never collected or validated | Logical | Add an `ActionListener` to `submitButton` that reads all field values, validates mandatory fields, and shows a confirmation via `JOptionPane` |
| 2 | `ButtonGroup` prevents both radio buttons from being selected simultaneously but does not enforce that at least one must be selected; the form can be "submitted" with no gender chosen | Logical | In the submit action, check `!male.isSelected() && !female.isSelected()` and show a warning dialog before proceeding |
| 3 | The profile photo section only displays static "No Image" text; there is no mechanism to actually browse and load an image file | Logical | Add a `JButton` labeled "Browse" that opens a `JFileChooser` with an image file filter, then loads the chosen file as an `ImageIcon` into the `photoBox` label |

---

## Question 4: RGB Color Picker

### Source Code

```java
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
```

### Sample Input/Output

**Input:** Select Red=255, Blue=0, Green=0 and click **Show-Output**

**Output:** Panel background changes to pure red

**Input:** Select Red=0, Blue=0, Green=0 and click **Show-Output**

**Output:** Panel background changes to black, making labels and combo boxes hard to see

### Common Errors

| Sl No. | Error | Error Type | Error Fix |
|--------|-------|------------|-----------|
| 1 | After applying a dark color like black (0,0,0), the labels, combo boxes, and button become very hard to see because the entire panel background is overwritten | Logical | Use a separate `JPanel` as a dedicated color preview area below the controls, and only change that panel's background instead of the main panel |
| 2 | `comboRed.getSelectedItem()` returns `Object`; casting directly with `(int)` relies on auto-unboxing from `Integer`, which throws a `NullPointerException` if `getSelectedItem()` returns `null` (e.g., if the model is cleared programmatically) | Runtime | Cast to `Integer` first: `int r = (Integer) comboRed.getSelectedItem();` to make the intent explicit and avoid ambiguous cast behavior |
| 3 | The combo boxes for Blue and Green are laid out left-to-right as Blue then Green, but a user naturally expects the order Red, Green, Blue (RGB); the reversed middle order (Red, **Blue**, Green) can cause confusion when manually picking colors | Logical | Reorder the combo box layout to Red, Green, Blue to match the standard RGB convention |
