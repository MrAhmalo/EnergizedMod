
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.energized.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.energized.item.EmptyElectronicBottleItem;
import net.mcreator.energized.item.ElectronicBottleItem;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EnergizedModItems {
	private static final List<Item> REGISTRY = new ArrayList<>();
	public static final Item ANIMATED_COG = register(EnergizedModBlocks.ANIMATED_COG, EnergizedModTabs.TAB_ENERGIZED);
	public static final Item LIGHTNING_COMPRESSOR = register(EnergizedModBlocks.LIGHTNING_COMPRESSOR, EnergizedModTabs.TAB_ENERGIZED);
	public static final Item ELECTRONIC_BOTTLE = register(new ElectronicBottleItem());
	public static final Item EMPTY_ELECTRONIC_BOTTLE = register(new EmptyElectronicBottleItem());

	private static Item register(Item item) {
		REGISTRY.add(item);
		return item;
	}

	private static Item register(Block block, CreativeModeTab tab) {
		return register(new BlockItem(block, new Item.Properties().tab(tab)).setRegistryName(block.getRegistryName()));
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Item[0]));
	}
}
