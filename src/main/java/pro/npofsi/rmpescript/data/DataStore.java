package pro.npofsi.rmpescript.data;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import pro.npofsi.rmpescript.RMPEScript;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;
import java.util.TreeMap;

public class DataStore {
    public String currentDir;
    public File workDir;
    public String cacheDirPath,propertyPath,scriptDirPath;
    public Stack<String> propertyCon;
    public TreeMap<String,String> properties;
    public static final String SP=File.separator;
    public void init(){
        currentDir=System.getProperty("user.dir");
        RMPEScript.Log.i("UsingDir:"+currentDir);
        workDir=new File(currentDir+SP+"mods"+SP+"RMPEScript");
        scriptDirPath=workDir.getPath()+SP+"Scripts";

        initDir(getScriptDir());
    }
    public void initDir(File f){
        if(!f.exists()){
            f.mkdirs();
        }
        if(!f.isDirectory()){
            RMPEScript.Log.e("Can't mkdirs : <"+f.getPath()+"> is a file.");
        }
    }

    private DataStore(){}
    public static DataStore getInstance(){ return ClassHolder.sInstance; }
    private static class ClassHolder{ private static final DataStore sInstance = new DataStore();}

    public String getResourceString(String name){

        String fileContent = "";
        try {
            InputStream is = this.getClass().getResourceAsStream(name);
            fileContent = IOUtils.toString(is);
        } catch (IOException e) {
            RMPEScript.Log.e("IOException : "+e.toString());
            e.printStackTrace();
        }
        return fileContent;
    }

    public File getDir(){
        return workDir;
    }
    public File getScriptDir(){
        return new File(scriptDirPath);
    }
    public static class isFileFilter implements FileFilter {
        public boolean accept(File f){
            return f.isFile();
        }
    }
    public static class fileTypeFilter implements FileFilter {
        String type;
        public fileTypeFilter(String type){this.type=type;}
        public boolean accept(File f){
            return f.isFile()&&f.getName().endsWith("."+type);
        }
    }
}

