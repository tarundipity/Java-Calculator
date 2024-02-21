import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculator implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionsButtons = new JButton[9];
    JButton addButton, subtractButton, multiplyButton, divideButton;
    JButton decimalButton, equalButton, deleteButton, clearButton, negativeButton;
    JPanel panel;

    Font myfont = new Font("Ink Free", Font.BOLD, 22);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    calculator() {
        // frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        // textfield
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myfont);
        textfield.setEditable(false);

        // JButtons for functions
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("x");
        divideButton = new JButton("÷");
        decimalButton = new JButton(".");
        equalButton = new JButton("=");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");
        negativeButton = new JButton("(-)");

        deleteButton.setBounds(50, 430, 100, 50);
        clearButton.setBounds(150, 430, 100, 50);
        negativeButton.setBounds(250, 430, 100, 50);

        functionsButtons[0] = addButton;
        functionsButtons[1] = subtractButton;
        functionsButtons[2] = multiplyButton;
        functionsButtons[3] = divideButton;
        functionsButtons[4] = decimalButton;
        functionsButtons[5] = equalButton;
        functionsButtons[6] = deleteButton;
        functionsButtons[7] = clearButton;
        functionsButtons[8] = negativeButton;

        // JButtons for functions - set up
        for (int i = 0; i < 9; i++) {
            functionsButtons[i].addActionListener(this);
            functionsButtons[i].setFont(myfont);
            functionsButtons[i].setFocusable(false);
        }
        // JButtons for numbers - set up
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myfont);
            numberButtons[i].setFocusable(false);
        }

        // panel
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 01));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subtractButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiplyButton);
        panel.add(decimalButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divideButton);

        // add components and set visiability
        frame.add(panel);
        frame.add(negativeButton);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(textfield);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        calculator calc = new calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // concats number if button clicked
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        // concats decimal point if button clicked
        if (e.getSource() == decimalButton) {
            textfield.setText(textfield.getText().concat("."));
        }

        // saves number into num1, sets operator to +, empties textfield for num2
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }

        // saves number into num1, sets operator to -, empties textfield for num2
        if (e.getSource() == subtractButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }

        // saves number into num1, sets operator to *, empties textfield for num2
        if (e.getSource() == multiplyButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }

        // saves number into num1, sets operator to /, empties textfield for num2
        if (e.getSource() == divideButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }

        // save number in textfield as num2, use switch to solve
        if (e.getSource() == equalButton) {
            num2 = Double.parseDouble(textfield.getText());

            // solve based on each case/operator used
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
                    result = num1 / num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
        }

        // clear textfield, make num1 equal 0
        if (e.getSource() == clearButton) {
            textfield.setText("");
        }

        // removes last value in textfield
        if (e.getSource() == deleteButton) {
            String string = textfield.getText();
            textfield.setText("");

            for (int i = 0; i < string.length() - 1; i++) {
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }
        // makes number negative
        if (e.getSource() == negativeButton) {
            double temp = Double.parseDouble(textfield.getText());
            temp *= -1;
            textfield.setText(String.valueOf(temp));
        }
    }
}
