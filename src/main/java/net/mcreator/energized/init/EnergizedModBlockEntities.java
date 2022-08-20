
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.energized.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.energized.block.entity.TankBlockEntity;
import net.mcreator.energized.block.entity.MachineBlockEntity;
import net.mcreator.energized.block.entity.LightningCompressorBlockEntity;
import net.mcreator.energized.EnergizedMod;

public class EnergizedModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, EnergizedMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> LIGHTNING_COMPRESSOR = register("lightning_compressor",
			EnergizedModBlocks.LIGHTNING_COMPRESSOR, LightningCompressorBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TANK = register("tank", EnergizedModBlocks.TANK, TankBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MACHINE = register("machine", EnergizedModBlocks.MACHINE, MachineBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block,
			BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
