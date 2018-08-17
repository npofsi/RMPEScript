package pro.npofsi.rmpescript.runtime.modular;

import pro.npofsi.rmpescript.runtime.ScriptManager;

public class JSPre {
    private static String[] head={
            "var pro=Packages.pro;",
            "const _RMPE=Packages.pro.npofsi.rmpescript;",
            "var RMPE=_RMPE.include.RMPE;",
            "var Global=_RMPE.include.modpe.Global;",
            "var Level=_RMPE.include.modpe.Level;",
            "var ModPE=_RMPE.include.modpe.ModPE;",
            "var ChatColor=_RMPE.include.modpe.contants.ChatColor;"
    };
    private static String[] footer={
            "''+('Run Done')"
    };
    public static String getHead(){
        String cache="";
        for(String i:head){
            cache+=i+"\n";
        }
        return cache;
    }
    public static String getFooter(){
        String cache="";
        for(String i:footer){
            cache+="\n"+i;
        }
        return cache;
    }
//    public static String getResHead(){
//        String str=ScriptManager.getInstance().getClass().getResource("meta.js");
//
//    }
}
