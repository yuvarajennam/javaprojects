

import java.awt.*;
import java.awt.event.*;

public class Calculator1 extends Frame implements ActionListener {
    int num1 = 0, num2 = 0, result = 0;
    char operator;
    TextField tf;

    Calculator1() {
        // Create and add display text field
        tf = new TextField();

        add(tf, BorderLayout.NORTH);

        // Create panel and grid layout
        Panel p = new Panel();
        p.setLayout(new GridLayout(4, 5, 10, 10));

        // Define all calculator buttons

        String buttons[] = { "7", "8", "9", "4", "+", "5", "6", "1", "2", "-", "3", "0", "*", "/", "%", "=", "C" };

        // Create buttons and add to panel
        for (int i = 0; i < buttons.length; i++) {
            Button b = new Button(buttons[i]);
            b.addActionListener(this);
            p.add(b);
        }

        // Add panel to frame
        add(p, BorderLayout.CENTER);

        // Frame properties
        setTitle("My Calculator");
        setSize(300, 300);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        // If digit is pressed
        if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {
            tf.setText(tf.getText() + s);
        }
        // Clear button
        else if (s.equals("C")) {
            tf.setText("");
            num1 = num2 = result = 0;
        }
        // Equals button
        else if (s.equals("=")) {
            try {
                num2 = Integer.parseInt(tf.getText());
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 == 0)
                            throw new ArithmeticException("Cannot divide by zero");
                        result = num1 / num2;
                        break;

                    case '%':
                        if (num2 == 0)
                            throw new ArithmeticException("Cannot divide by zero");
                        result = num1 % num2;
                        break;
                }
                tf.setText(String.valueOf(result));
            } catch (ArithmeticException ex) {
                tf.setText(ex.getMessage());
            } catch (Exception ex) {
                tf.setText("Error");
            }
        }
        // Operator buttons
        else {
            try {
                num1 = Integer.parseInt(tf.getText());
                operator = s.charAt(0);
                tf.setText("");
            } catch (Exception ex) {
                tf.setText("Error");
            }
        }
    }

    public static void main(String[] args) {
        new Calculator1();
    }
}

