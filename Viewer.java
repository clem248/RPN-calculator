import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;


public class Viewer {

    private JTextField textField;
    private JTextField littleTextField;

    public Viewer() {
        Controller controller = new Controller(this);
        Font font = new Font("Helvetica", Font.PLAIN, 25);
        Color lighterGreen = new Color(166, 232, 58);
        Color whitish = new Color(251, 255, 234);
        Color darkerGreen = new Color(137, 203, 9);

        littleTextField = new JTextField();
        littleTextField.setFont(font);
        littleTextField.setForeground(Color.BLACK);
        littleTextField.setBounds(60, 10, 250, 40);

        textField = new JTextField();
        textField.setFont(font);
        textField.setForeground(Color.BLACK);
        textField.setBounds(50, 50, 270, 50);

        JButton buttonZero = createButton("0", font, Color.BLACK, whitish, 120, 320, 60, 60, controller, "Zero");
        JButton buttonOne = createButton("1", font, Color.BLACK, whitish, 50, 250, 60, 60, controller, "One");
        JButton buttonTwo = createButton("2", font, Color.BLACK, whitish, 120, 250, 60, 60, controller, "Two");
        JButton buttonThree = createButton("3", font, Color.BLACK, whitish, 190, 250, 60, 60, controller, "Three");
        JButton buttonFour = createButton("4", font, Color.BLACK, whitish, 50, 180, 60, 60, controller, "Four");
        JButton buttonFive = createButton("5", font, Color.BLACK, whitish, 120, 180, 60, 60, controller, "Five");
        JButton buttonSix = createButton("6", font, Color.BLACK, whitish, 190, 180, 60, 60, controller, "Six");
        JButton buttonSeven = createButton("7", font, Color.BLACK, whitish, 50, 110, 60, 60, controller, "Seven");
        JButton buttonEight = createButton("8", font, Color.BLACK, whitish, 120, 110, 60, 60, controller, "Eight");
        JButton buttonNine = createButton("9", font, Color.BLACK, whitish, 190, 110, 60, 60, controller, "Nine");

        // (+, -, /, *)
        JButton buttonPlus = createButton("+", font, Color.BLACK, lighterGreen, 260, 110, 60, 60, controller, "Plus_Command");
        JButton buttonMinus = createButton("-", font, Color.BLACK, lighterGreen, 260, 180, 60, 60, controller, "Minus_Command");
        JButton buttonDivide = createButton("/", font, Color.BLACK, lighterGreen, 260, 250, 60, 60, controller, "Div_Command");
        JButton buttonMultiply = createButton("*", font, Color.BLACK, lighterGreen, 260, 320, 60, 60, controller, "Mult_Command");

        //(Del, C, =, .)
        JButton buttonDel = createButton("<-", font, Color.BLACK, whitish, 50, 320, 60, 60, controller, "Del_Command");
        JButton buttonClear = createButton("C", font, Color.BLACK, lighterGreen, 50, 390, 130, 60, controller, "C_Command");
        JButton buttonEquals = createButton("=", font, Color.BLACK, lighterGreen, 190, 390, 130, 60, controller, "Equals_Command");
        JButton buttonDot = createButton(".", font, Color.BLACK, whitish, 190, 320, 60, 60, controller, "Dot_Command");

        JFrame frame = new JFrame("Calculator MVC");
        frame.setSize(390, 540);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.add(littleTextField);
        frame.add(textField);
        frame.add(buttonZero);
        frame.add(buttonOne);
        frame.add(buttonTwo);
        frame.add(buttonThree);
        frame.add(buttonFour);
        frame.add(buttonFive);
        frame.add(buttonSix);
        frame.add(buttonSeven);
        frame.add(buttonEight);
        frame.add(buttonNine);
        frame.add(buttonPlus);
        frame.add(buttonMinus);
        frame.add(buttonDivide);
        frame.add(buttonMultiply);
        frame.add(buttonDel);
        frame.add(buttonClear);
        frame.add(buttonEquals);
        frame.add(buttonDot);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JButton createButton(String label, Font font, Color color, Color backgroundColor, int x, int y, int width, int height, ActionListener listener, String actionCommand) {
        JButton button = new JButton(label);
        button.setFont(font);
        button.setForeground(color);
        button.setBackground(backgroundColor);
        button.setBounds(x, y, width, height);
        button.addActionListener(listener);
        button.setActionCommand(actionCommand);
        return button;
    }

    public void updateText(String result) {
        textField.setText(result);
    }

    public void updatelittleTextField(String result) {
        littleTextField.setText(result);
    }

    public void cCommand(String result) {
        textField.setText(result);
        littleTextField.setText(result);
    }
}
