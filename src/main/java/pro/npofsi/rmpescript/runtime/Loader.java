package pro.npofsi.rmpescript.runtime;

import pro.npofsi.rmpescript.RMPEScript;

public class Loader extends Thread {
    public void remove(){
        try {
            this.join();
        } catch (InterruptedException e) {
            RMPEScript.Log.e(e.toString());
            e.printStackTrace();
        }
    }
}
