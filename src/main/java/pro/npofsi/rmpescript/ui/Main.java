package pro.npofsi.rmpescript.ui;

import pro.npofsi.rmpescript.ui.swing.SplashUi;

public class Main {
    public static void main(String[] args){
        System.out.println("UiLaunched");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SplashUi().create();
            }
        });
    }
}
