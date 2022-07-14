package hey;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class atm extends JFrame {
private JPanel panel;
private JLabel messageLabel;
private JTextField depositTextField;
private JButton depButton;
private JButton takeButton;
private JButton viewButton;
private final int window_width = 310;
private final int window_height = 100;
private int balance = 0;


public atm() {
    setTitle("ATM");
    setSize(window_width, window_height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    depButton = new JButton("Deposit");
    takeButton = new JButton("Withdraw");
    viewButton = new JButton("View Balance");
    depButton.addActionListener(new CalcButtonListener());
    takeButton.addActionListener(new CalcButtonListener());
    viewButton.addActionListener(new CalcButtonListener());
    panel = new JPanel();
    panel.add(depButton);
    panel.add(takeButton);
    panel.add(viewButton);
    add(panel);
    setVisible(true);
}


private class CalcButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == depButton) {
            String input = JOptionPane.showInputDialog("Enter deposit amount");
            balance += Double.parseDouble(input);
            JOptionPane.showMessageDialog(null, "You've deposited $" + input);
            JOptionPane.showMessageDialog(null, "Account balance: $" + balance);
        }
        else if (e.getSource() == takeButton) {
            String input = JOptionPane.showInputDialog("Enter withdraw amount");
            balance -= Double.parseDouble(input);
            JOptionPane.showMessageDialog(null, "You've withdrawn $" + input);
            JOptionPane.showMessageDialog(null, "Account balance: $" + balance);
        }
        else if (e.getSource() == viewButton) {
            JOptionPane.showMessageDialog(null, "Account balance: $" + balance);
        }


    }
}

    public static void main(String[] args){
    new atm();
    }
}
