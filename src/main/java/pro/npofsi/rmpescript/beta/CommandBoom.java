package pro.npofsi.rmpescript.beta;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.AxisAlignedBB;
import pro.npofsi.rmpescript.data.FileOperator;
import pro.npofsi.rmpescript.include.modpe.Level;

import java.util.Iterator;
import java.util.List;

public class CommandBoom extends CommandBase {

    @Override
    public String getName() {
        return "boom";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/boom <r>";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (sender instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) sender;
            // 接下来的代码我直接抄的Szszss的教程: http://www.hakugyokurou.net/wordpress/?p=225
            // 这串代码可以获取玩家周围一定范围的生物列表
            
            List list = player.world.getEntitiesWithinAABB(EntityLiving.class, new AxisAlignedBB((double)player.posX - 30D, (double)player.posY - 20D, (double)player.posZ - 30D, (double)player.posX + 30D, (double)player.posY + 20D, (double)player.posZ + 30D));
            // 使用Iterator遍历list
            for (Iterator iterator = list.iterator(); iterator.hasNext();) {
                EntityLiving entity = (EntityLiving) iterator.next();
                // 上面所获取的生物列表里也包含玩家自己 所以别把自己也炸了
                if (entity.equals(player)) {
                    continue;
                }
                // 顺 ! 间 ! 爆 ! 炸 !
                //Level.setTile(entity.posX,entity.posY,entity.posZ,"stone",0);
                player.world.createExplosion(player, entity.posX, entity.posY, entity.posZ, new Integer(args.length==0?"1":args[0]), true);
            }
        } else {
            //这里特别注意 当玩家输入的指令的参数不对或者有别的什么错误的话
            //直接throw一个CommandException就好 MC会捕获并显示给玩家
            throw new CommandException("This command is for players only!");
        }
    }
}
