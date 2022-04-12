
package net.mcreator.energized.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import net.mcreator.energized.init.EnergizedModTabs;

import java.util.List;

public class BlockLocationSaverItem extends Item {
	public BlockLocationSaverItem() {
		super(new Item.Properties().tab(EnergizedModTabs.TAB_ENERGIZED).stacksTo(64).rarity(Rarity.COMMON));
		setRegistryName("block_location_saver");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("\u00A7bSaves Block Locations"));
	}
}
