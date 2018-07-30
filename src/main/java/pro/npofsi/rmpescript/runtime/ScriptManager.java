package pro.npofsi.rmpescript.runtime;

import java.lang.*;
import java.util.Stack;

public class ScriptManager {

    private ScriptManager(){}
    public static ScriptManager getInstance(){
        return ClassHolder.sInstance;
    }
    private static class ClassHolder{
        private static final ScriptManager sInstance = new ScriptManager();
    }

    Stack<Thread> runstack;
    Stack<Integer> ids;

}
