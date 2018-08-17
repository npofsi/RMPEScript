package pro.npofsi.rmpescript.include.modpe;

import pro.npofsi.rmpescript.RMPEScript;

import java.util.Iterator;
import java.util.Stack;

public class Hook {
    public static class useItem{
        private useItem(){}
        public static useItem getInstance(){
            return ClassHolder.sInstance;
        }
        private static class ClassHolder{
            private static final useItem sInstance = new useItem();
        }

        public interface Callback{
            public void run(int x,int y,int z,int id,int data);
        }
        Stack<useItem.Callback> bus;
        Stack<Integer> ids;
        public int register(useItem.Callback callback){
            int id=(int)Math.ceil(Math.random()*10000);
            ids.push(id);
            bus.push(callback);
            return id;
        }
        public void run(int x,int y,int z,int id,int data) {
            for(Iterator<useItem.Callback> i=bus.iterator();i.hasNext();){
                i.next().run(x,y,z,id,data);
                RMPEScript.Log.i("Hook:useItem<"+id+"> called");
            }
        }
    }
}
