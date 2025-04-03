import javax.swing.*;
import frame.*;


public class Launcher {


    public static void main(String[] args ) throws InterruptedException  {

        LoadingScreen a = new LoadingScreen();
        a.showLoadingScreen();
        Thread.sleep(5000);

        a.closeLoadingScreen();
        SwingUtilities.invokeLater(Frame::new);
    }


}
