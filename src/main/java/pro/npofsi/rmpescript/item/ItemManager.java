package pro.npofsi.rmpescript.item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Stack;

public class ItemManager
{
    private Stack<ItemInstance> items = new Stack<ItemInstance>();

    public void add(ItemInstance item)
    {
        items.push(item);

    }

    public void load()
    {
        Stack<ItemInstance> backup = items;
        for(int i=0;i<items.size();i++){
            ItemInstance item = items.pop();
            register(item);
            initModel(item);
        }
        items = backup;
    }

    private static void initModel(ItemInstance item){
        for(int i =0;i<item.metadata.size();i++){
            ModelLoader.setCustomModelResourceLocation(item, item.metadata.pop(),
                    new ModelResourceLocation(""+item.getRegistryName(), "inventory"));
        }
    }

    public static void register(Item item)
    {
        ForgeRegistries.ITEMS.register(item);
    }

    private ItemManager(){

    }
    public static ItemManager getInstance(){
        return ClassHolder.sInstance;
    }
    private static class ClassHolder{
        private static final ItemManager sInstance = new ItemManager();
    }
}