# Day 11: GUI Programming (Swing) - Common Errors

---

## Question 1: GUI Calculator

### Source Code

```java
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
```

### Sample Input/Output

**Input:** Click `7`, then `*`, then `8`, then `=`

**Output:** Display shows `56`

**Input:** Click `9`, then `/`, then `0`, then `=`

**Output:** Display shows `Error`

**Input:** Click `1`, `0`, then `+`, then `5`, then `=`

**Output:** Display shows `15`

### Common Errors

| Sl No. | Error | Error Type | Error Fix |
|--------|-------|------------|-----------|
| 1 | Pressing `=` immediately after the calculator opens (when `operator` is empty but display shows `"Error"` from a previous division by zero) calls `Double.parseDouble("Error")` and throws a `NumberFormatException`, crashing the action | Runtime | Wrap the `Double.parseDouble(display.getText())` call in a try-catch block and reset the display to `"0"` if parsing fails |
| 2 | Pressing an operator button consecutively (e.g., `5`, `+`, `+`) overwrites the stored operator silently but also re-parses the display which already holds a valid number; this works, but pressing two operators before entering any second number means the first operand is overwritten with whatever is on the display at that moment | Logical | Guard the operator handler to skip saving if `newInput[0]` is already `true` (meaning no new number has been typed since the last operator), so repeated operator presses update only the operator without re-saving `firstNum` |
| 3 | There is no decimal point (`.`) button, so only integer inputs are possible despite the logic using `double` internally | Logical | Add a `"."` button to the grid and handle it by appending `"."` to the display only if the current display string does not already contain one |

---

## Question 2: String Operations GUI

### Source Code

```java
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
```

### Sample Input/Output

**Input:** Type `Harish Patnaik` and click **IN CAPS**

**Output:** Result field shows `HARISH PATNAIK`

**Input:** Type `Hello World` and click **WORDS**

**Output:** Result field shows `2`

**Input:** Type `aabbcc` and click **FREQUENCY**

**Output:** Result field shows `a:2 b:2 c:2`

**Input:** Type `hello world` and click **BEGIN CAPS**

**Output:** Result field shows `Hello World`

### Common Errors

| Sl No. | Error | Error Type | Error Fix |
|--------|-------|------------|-----------|
| 1 | The `resultLabel` has a fixed width of `200` pixels set via `setBounds`; after clicking operations like **FREQUENCY** or **BEGIN CAPS**, the updated label text (e.g., `"Character frequency:"`) is wider than 200px and gets clipped, making it unreadable | Logical | Increase the label width in `setBounds` to at least `250` pixels, or call `resultLabel.revalidate()` and `resultLabel.repaint()` after updating the text |
| 2 | The FREQUENCY button uses `str.indexOf(c) == i` to detect the first occurrence, which is case-sensitive; for a string like `"aAbB"`, `'a'` and `'A'` are treated as separate characters, so the frequency output may be unexpected if the user expected case-insensitive counting | Logical | Decide on case sensitivity explicitly; if case-insensitive frequency is desired, convert `str` to lowercase before processing and document the behaviour in the label |
| 3 | Clicking any button when the input field is empty performs operations on an empty string without any feedback; for example, WORDS returns `0` but the result label changes to `"Number of words:"`, which can confuse users who did not intend to operate on an empty string | Logical | Add a guard at the start of each `ActionListener` to check `inputField.getText().isEmpty()` and show a `JOptionPane` warning prompting the user to enter a string first |
