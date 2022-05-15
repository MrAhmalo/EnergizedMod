
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.energized.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.energized.block.entity.TankBlockEntity;
import net.mcreator.energized.block.entity.MachineBlockEntity;
import net.mcreator.energized.block.entity.LightningCompressorBlockEntity;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EnergizedModBlockEntities {
	private static final List<BlockEntityType<?>> REGISTRY = new ArrayList<>();
	public static final BlockEntityType<?> LIGHTNING_COMPRESSOR = register("energized:lightning_compressor", EnergizedModBlocks.LIGHTNING_COMPRESSOR,
			LightningCompressorBlockEntity::new);
	public static final BlockEntityType<?> TANK = register("energized:tank", EnergizedModBlocks.TANK, TankBlockEntity::new);
	public static final BlockEntityType<?> MACHINE = register("energized:machine", EnergizedModBlocks.MACHINE, MachineBlockEntity::new);

	private static BlockEntityType<?> register(String registryname, Block block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		BlockEntityType<?> blockEntityType = BlockEntityType.Builder.of(supplier, block).build(null).setRegistryName(registryname);
		REGISTRY.add(blockEntityType);
		return blockEntityType;
	}

	@SubscribeEvent
	public static void registerTileEntity(RegistryEvent.Register<BlockEntityType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new BlockEntityType[0]));
	}
}
