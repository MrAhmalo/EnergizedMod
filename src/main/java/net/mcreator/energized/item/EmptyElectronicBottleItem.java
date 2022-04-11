
package net.mcreator.energized.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.energized.init.EnergizedModTabs;

public class EmptyElectronicBottleItem extends Item {
	public EmptyElectronicBottleItem() {
		super(new Item.Properties().tab(EnergizedModTabs.TAB_ENERGIZED).stacksTo(64).rarity(Rarity.COMMON));
		setRegistryName("empty_electronic_bottle");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}
}
