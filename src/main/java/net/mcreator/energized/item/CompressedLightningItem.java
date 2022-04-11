
package net.mcreator.energized.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.energized.init.EnergizedModTabs;
import net.mcreator.energized.init.EnergizedModFluids;

public class CompressedLightningItem extends BucketItem {
	public CompressedLightningItem() {
		super(() -> EnergizedModFluids.COMPRESSED_LIGHTNING,
				new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON).tab(EnergizedModTabs.TAB_ENERGIZED));
		setRegistryName("compressed_lightning_bucket");
	}
}
