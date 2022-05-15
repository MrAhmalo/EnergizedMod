
package net.mcreator.energized.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

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
		list.add(new TextComponent("\uFFFDbSaves Block Locations"));
	}

}
