
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.energized.init;

import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import net.mcreator.energized.world.inventory.LightingsummonerrightklickedguiMenu;
import net.mcreator.energized.world.inventory.FuelGUIMenu;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EnergizedModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<FuelGUIMenu> FUEL_GUI = register("fuel_gui", (id, inv, extraData) -> new FuelGUIMenu(id, inv, extraData));
	public static final MenuType<LightingsummonerrightklickedguiMenu> LIGHTINGSUMMONERRIGHTKLICKEDGUI = register("lightingsummonerrightklickedgui",
			(id, inv, extraData) -> new LightingsummonerrightklickedguiMenu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}
