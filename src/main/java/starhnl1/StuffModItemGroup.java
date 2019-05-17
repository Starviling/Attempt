package mod.starhnl1;

import mod.starhnl1.lists.BlockList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class StuffModItemGroup extends ItemGroup
{
	public StuffModItemGroup()
	{
		super("stuff");
	}
	
	@Override
	public ItemStack createIcon()
	{
		return new ItemStack(Item.BLOCK_TO_ITEM.get(BlockList.copper_ore));
	}

}
