
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.energized.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.energized.block.TankBlock;
import net.mcreator.energized.block.MachineBlock;
import net.mcreator.energized.block.LightningSummonerBlock;
import net.mcreator.energized.block.LightningCompressorBlock;
import net.mcreator.energized.block.CompressedLightningBlock;
import net.mcreator.energized.block.AnimatedCogBlock;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EnergizedModBlocks {
	private static final List<Block> REGISTRY = new ArrayList<>();
	public static final Block ANIMATED_COG = register(new AnimatedCogBlock());
	public static final Block LIGHTNING_COMPRESSOR = register(new LightningCompressorBlock());
	public static final Block COMPRESSED_LIGHTNING = register(new CompressedLightningBlock());
	public static final Block TANK = register(new TankBlock());
	public static final Block MACHINE = register(new MachineBlock());
	public static final Block LIGHTNING_SUMMONER = register(new LightningSummonerBlock());

	private static Block register(Block block) {
		REGISTRY.add(block);
		return block;
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Block[0]));
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			AnimatedCogBlock.registerRenderLayer();
			LightningCompressorBlock.registerRenderLayer();
			TankBlock.registerRenderLayer();
			MachineBlock.registerRenderLayer();
			LightningSummonerBlock.registerRenderLayer();
		}
	}
}
