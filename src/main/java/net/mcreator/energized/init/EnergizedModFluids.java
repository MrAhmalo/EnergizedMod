
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.energized.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.energized.fluid.CompressedLightningFluid;
import net.mcreator.energized.EnergizedMod;

public class EnergizedModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, EnergizedMod.MODID);
	public static final RegistryObject<Fluid> COMPRESSED_LIGHTNING = REGISTRY.register("compressed_lightning",
			() -> new CompressedLightningFluid.Source());
	public static final RegistryObject<Fluid> FLOWING_COMPRESSED_LIGHTNING = REGISTRY.register("flowing_compressed_lightning",
			() -> new CompressedLightningFluid.Flowing());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(COMPRESSED_LIGHTNING.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_COMPRESSED_LIGHTNING.get(), renderType -> renderType == RenderType.translucent());
		}
	}
}
