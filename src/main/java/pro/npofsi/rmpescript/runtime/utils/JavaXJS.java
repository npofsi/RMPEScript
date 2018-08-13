package pro.npofsi.rmpescript.runtime.utils;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JavaXJS {
    public static Object JavaToJS(Object obj,String name,Scriptable scope){
        Object out= Context.javaToJS(obj,scope);
        ScriptableObject.putProperty(scope, name, out);
        return  out;
    }
}
