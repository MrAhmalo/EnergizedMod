
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.energized.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.energized.item.EmptyElectronicBottleItem;
import net.mcreator.energized.item.ElectronicBottleItem;
import net.mcreator.energized.item.CompressedLightningItem;
import net.mcreator.energized.EnergizedMod;

public class EnergizedModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, EnergizedMod.MODID);
	public static final RegistryObject<Item> ANIMATED_COG = block(EnergizedModBlocks.ANIMATED_COG, EnergizedModTabs.TAB_ENERGIZED);
	public static final RegistryObject<Item> LIGHTNING_COMPRESSOR = block(EnergizedModBlocks.LIGHTNING_COMPRESSOR, EnergizedModTabs.TAB_ENERGIZED);
	public static final RegistryObject<Item> TANK = block(EnergizedModBlocks.TANK, EnergizedModTabs.TAB_ENERGIZED);
	public static final RegistryObject<Item> MACHINE = block(EnergizedModBlocks.MACHINE, EnergizedModTabs.TAB_ENERGIZED);
	public static final RegistryObject<Item> LIGHTNING_SUMMONER = block(EnergizedModBlocks.LIGHTNING_SUMMONER, EnergizedModTabs.TAB_ENERGIZED);
	public static final RegistryObject<Item> COMPRESSED_LIGHTNING_BUCKET = REGISTRY.register("compressed_lightning_bucket",
			() -> new CompressedLightningItem());
	public static final RegistryObject<Item> EMPTY_ELECTRONIC_BOTTLE = REGISTRY.register("empty_electronic_bottle",
			() -> new EmptyElectronicBottleItem());
	public static final RegistryObject<Item> ELECTRONIC_BOTTLE = REGISTRY.register("electronic_bottle", () -> new ElectronicBottleItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
