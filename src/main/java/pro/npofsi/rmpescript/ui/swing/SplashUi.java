package pro.npofsi.rmpescript.ui.swing;

import javax.swing.*;

public class SplashUi {
    public void create(){
        JFrame frame = new JFrame("RMPEScript-Splash");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("RMPEScript");
        label.setSize(800,480);
        frame.getContentPane().add(label);
        frame.pack();
        frame.setVisible(true);
    }

}
