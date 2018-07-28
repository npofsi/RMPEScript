package pro.npofsi.rmpescript.data;

import com.google.gson.Gson;
import pro.npofsi.rmpescript.RMPEScript;

import java.io.File;
import java.util.Stack;
import java.util.TreeMap;

public class DataStore {
    public String currentDir;
    public File workDir;
    public String cacheDirPath,propertyPath,scriptDirPath;
    public Stack<String> propertyCon;
    public TreeMap<String,String> properties;
    public void init(){

        currentDir=System.getProperty("user.dir");
        RMPEScript.Log.i("UsingDir:"+currentDir);
        workDir=new File(currentDir+"/RMPEScript");
    }
    private DataStore(){

    }
    public static DataStore getInstance(){
        return ClassHolder.sInstance;
    }
    private static class ClassHolder{
        private static final DataStore sInstance = new DataStore();
    }
}

