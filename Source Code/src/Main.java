import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JRadioButton[] radioButtons = new JRadioButton[8];
        ButtonGroup group = new ButtonGroup();
        TextField amount = new TextField();
        JButton calculate = new JButton("Calculate");
        JLabel result = new JLabel("The result is:");

        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new GridLayout(9, 2));
        frame.add(panel);
        frame.setSize(400, 300);
        panel.add(new JLabel("Select Percentage: "));
        panel.add(new JLabel());

        for (int i=0; i<8; i++) {
            JRadioButton b = new JRadioButton(String.format("%d%%", 97-i));
            radioButtons[i] = b;
            group.add(b);
            panel.add(b);
        }

        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel("Enter Amount:"));
        panel.add(amount);
        panel.add(new JLabel());
        panel.add(calculate);
        panel.add(new JLabel("Made By Krisgfx"));
        panel.add(result);

        calculate.addActionListener(e -> {
            JRadioButton button = radioButtons[0];
            for (JRadioButton radioButton : radioButtons) {
                if (radioButton.isSelected()) {
                    button = radioButton;
                }
            }
            float percentage = Float.parseFloat(button.getText().substring(0, 2)) * 0.01f;
            float a;
            try {
                a = Float.parseFloat(amount.getText());
            } catch (NumberFormatException error) {
                result.setText("Error: Invalid Input");
                return;
            }
            result.setText("The result is: " + a * percentage);
        });

        frame.setVisible(true);
    }
}