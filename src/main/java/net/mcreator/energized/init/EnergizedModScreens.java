
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.energized.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.energized.client.gui.LightingsummonerrightklickedguiScreen;
import net.mcreator.energized.client.gui.FuelGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EnergizedModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(EnergizedModMenus.FUEL_GUI, FuelGUIScreen::new);
			MenuScreens.register(EnergizedModMenus.LIGHTINGSUMMONERRIGHTKLICKEDGUI, LightingsummonerrightklickedguiScreen::new);
		});
	}
}
