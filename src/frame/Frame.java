package frame;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import cps.Cps;



public class Frame {


    private JFrame frame;
    private JLabel clickLabel;
    private JLabel timerLabel;
    private Cps logic;


    public Frame() {

        logic = new Cps(this);
        frame = new JFrame("CPS Tester");
        frame.setUndecorated(true);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.DARK_GRAY);



        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(Color.BLACK);



        JButton minimizeButton = new JButton("_");
        JButton closeButton = new JButton("X");



        minimizeButton.setForeground(Color.WHITE);
        minimizeButton.setBackground(Color.GRAY);
        minimizeButton.setFocusPainted(false);
        minimizeButton.addActionListener(e -> frame.setState(JFrame.ICONIFIED));



        closeButton.setForeground(Color.WHITE);
        closeButton.setBackground(Color.RED);
        closeButton.setFocusPainted(false);
        closeButton.addActionListener(e -> System.exit(0));



        buttonPanel.add(minimizeButton);
        buttonPanel.add(closeButton);



        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 1, 10, 10));
        centerPanel.setBackground(Color.DARK_GRAY);



        clickLabel = new JLabel("Clicks: 0", SwingConstants.CENTER);
        clickLabel.setForeground(Color.WHITE);
        clickLabel.setFont(new Font("Arial", Font.BOLD, 20));



        timerLabel = new JLabel("Time: 5s", SwingConstants.CENTER);
        timerLabel.setForeground(Color.WHITE);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 20));



        JButton clickButton = new JButton("Click");
        clickButton.setFont(new Font("Arial", Font.BOLD, 20));
        clickButton.addActionListener(e -> logic.handleClick());



        JButton resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.BOLD, 20));
        resetButton.addActionListener(e -> logic.resetTest());



        centerPanel.add(clickLabel);
        centerPanel.add(timerLabel);
        centerPanel.add(clickButton);
        centerPanel.add(resetButton);



        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }



    public void updateClickLabel(int clicks) {

        clickLabel.setText("Clicks: " + clicks);

    }


    public void updateTimerLabel(int timeLeft) {

        timerLabel.setText("Time: " + timeLeft + "s");

    }


    public void showResult(double cps) {

        JOptionPane.showMessageDialog(frame, "Test finished! CPS: " + cps);

    }
}
