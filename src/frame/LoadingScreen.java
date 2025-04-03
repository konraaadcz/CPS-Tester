package frame;


import java.awt.*;
import javax.swing.*;




public class LoadingScreen {
    private JFrame frame;

    public void showLoadingScreen() {
        SwingUtilities.invokeLater(() -> {

          
            frame = new JFrame("CPS-Tester");
            frame.setUndecorated(true);
            frame.setSize(500, 400);
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            frame.getContentPane().setBackground(new Color(24, 24, 24));
            frame.setLayout(null);


          
            JLabel label = new JLabel("CPS-Tester", JLabel.CENTER);
            label.setForeground(Color.WHITE);
            label.setFont(new Font("Arial", Font.BOLD, 60));
          
          label.setBounds(0, 150, 500, 100);
            frame.add(label);

          
            JProgressBar progressBar = new JProgressBar();
            progressBar.setIndeterminate(true);
            progressBar.setBounds(100, 300, 300, 20);
            frame.add(progressBar);

          
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }


  
    public void closeLoadingScreen() {
        if (frame != null) {
            SwingUtilities.invokeLater(() -> {
                frame.dispose();
                frame = null;
            });
        }
    }
}

