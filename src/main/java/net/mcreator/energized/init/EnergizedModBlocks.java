
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.energized.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.energized.block.TankBlock;
import net.mcreator.energized.block.MachineBlock;
import net.mcreator.energized.block.LightningSummonerBlock;
import net.mcreator.energized.block.LightningCompressorBlock;
import net.mcreator.energized.block.CompressedLightningBlock;
import net.mcreator.energized.block.AnimatedCogBlock;
import net.mcreator.energized.EnergizedMod;

public class EnergizedModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, EnergizedMod.MODID);
	public static final RegistryObject<Block> ANIMATED_COG = REGISTRY.register("animated_cog", () -> new AnimatedCogBlock());
	public static final RegistryObject<Block> LIGHTNING_COMPRESSOR = REGISTRY.register("lightning_compressor", () -> new LightningCompressorBlock());
	public static final RegistryObject<Block> TANK = REGISTRY.register("tank", () -> new TankBlock());
	public static final RegistryObject<Block> MACHINE = REGISTRY.register("machine", () -> new MachineBlock());
	public static final RegistryObject<Block> LIGHTNING_SUMMONER = REGISTRY.register("lightning_summoner", () -> new LightningSummonerBlock());
	public static final RegistryObject<Block> COMPRESSED_LIGHTNING = REGISTRY.register("compressed_lightning", () -> new CompressedLightningBlock());

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
