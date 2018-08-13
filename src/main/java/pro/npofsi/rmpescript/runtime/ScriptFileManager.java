package pro.npofsi.rmpescript.runtime;

import pro.npofsi.rmpescript.RMPEScript;
import pro.npofsi.rmpescript.data.DataStore;
import pro.npofsi.rmpescript.data.FileOperator;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class ScriptFileManager {
    private ScriptFileManager(){}
    public static ScriptFileManager getInstance(){
        return ClassHolder.sInstance;
    }
    private static class ClassHolder{
        private static final ScriptFileManager sInstance = new ScriptFileManager();
    }

    public void refresh(){
        ScriptManager.getInstance().refresh(refreshFromFiles());
    }
    public Map<String,String> refreshFromFiles(){
        File[] fs=DataStore.getInstance().getScriptDir().listFiles(new DataStore.isFileFilter());
        Map<String,String> scripts=new TreeMap<String, String>();
        for (File f : fs){
            try {
                scripts.put(f.getName(),FileOperator.read(f.getCanonicalPath()));
            } catch (IOException e) {
                RMPEScript.Log.e("Can't find file:"+f.getPath());
                e.printStackTrace();
            }
        }
        return scripts;
    }
}
