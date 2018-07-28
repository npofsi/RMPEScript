package pro.npofsi.rmpescript.item;
import net.minecraft.item.Item;

import java.util.Stack;


public class ItemInstance extends Item{
    public Stack<Integer> metadata;
    public ItemInstance(String registryName,String unlocalizedName){
        //TODO
        metadata.push(0);
        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(registryName);
    }

}
