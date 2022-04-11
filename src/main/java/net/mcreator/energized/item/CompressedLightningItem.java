
package net.mcreator.energized.item;

import net.minecraft.network.chat.Component;

public class CompressedLightningItem extends BucketItem {

	public CompressedLightningItem() {
		super(() -> EnergizedModFluids.COMPRESSED_LIGHTNING,
				new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON).tab(EnergizedModTabs.TAB_ENERGIZED));
		setRegistryName("compressed_lightning_bucket");
	}

}
