package pro.npofsi.rmpescript.data;

import pro.npofsi.rmpescript.RMPEScript;

import java.io.*;
import java.util.Stack;


public class FileOperator {

    /**
     * 使用FileWriter类写文本文件
     */
    public static BufferedWriter write(String path, String contents) {
        String[] array={contents};
        return  write(path,array);
    }
    public static BufferedWriter write(String path, String[] contents) {
        try {
            File f=new File(path);
            if(!f.exists()){
                f.getParentFile().mkdirs();
                f.createNewFile();
            }
            if(!f.canWrite()||f.isDirectory()){
                return null;
            }
            BufferedWriter out = new BufferedWriter(new FileWriter(path));
            for (int i = 0; i < contents.length; i++) {
                out.write(contents[i]);
            }
            out.close();
            return out;
        } catch (IOException e) {
            e.printStackTrace();

        }
        return null;
    }

    /**
     * 使用BufferedReader类读文本文件
     */
    public static String read(String path)
    {
        String content = "";
        try {
            File f=new File(path);
            if(!f.exists()||!f.canRead()||f.isDirectory()){
                return "";
            }
            BufferedReader in = new BufferedReader(new FileReader(path));
            content = in.readLine();
            while (content != null) {
                content = in.readLine();
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
    public static Stack<String> readAsStack(String path)
    {
        Stack<String> content = new Stack<String>();
        try {
            File f=new File(path);
            if(!f.exists()||!f.canRead()||f.isDirectory()){
                return content;
            }
            BufferedReader in = new BufferedReader(new FileReader(path));
            content.push(in.readLine());
            while (content.lastElement() != null) {
                content.push(in.readLine());
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
