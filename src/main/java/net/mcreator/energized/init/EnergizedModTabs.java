
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.energized.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class EnergizedModTabs {
	public static CreativeModeTab TAB_ENERGIZED;

	public static void load() {
		TAB_ENERGIZED = new CreativeModeTab("tabenergized") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(Items.BLAZE_ROD);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
