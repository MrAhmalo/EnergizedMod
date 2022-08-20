
package net.mcreator.energized.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.energized.world.inventory.FuelGUIMenu;
import net.mcreator.energized.procedures.Progress5Procedure;
import net.mcreator.energized.procedures.Progress4Procedure;
import net.mcreator.energized.procedures.Progress3Procedure;
import net.mcreator.energized.procedures.Progress2Procedure;
import net.mcreator.energized.procedures.Progress1Procedure;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class FuelGUIScreen extends AbstractContainerScreen<FuelGUIMenu> {
	private final static HashMap<String, Object> guistate = FuelGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public FuelGUIScreen(FuelGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 50;
		this.imageHeight = 100;
	}

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		RenderSystem.setShaderTexture(0, new ResourceLocation("energized:textures/screens/tank_background.png"));
		this.blit(ms, this.leftPos + 0, this.topPos + 0, 0, 0, 50, 100, 50, 100);

		if (Progress1Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("energized:textures/screens/tank_bar_1.png"));
			this.blit(ms, this.leftPos + 16, this.topPos + 75, 0, 0, 16, 13, 16, 13);
		}
		if (Progress2Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("energized:textures/screens/tank_bar_2.png"));
			this.blit(ms, this.leftPos + 16, this.topPos + 62, 0, 0, 16, 26, 16, 26);
		}
		if (Progress3Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("energized:textures/screens/tank_bar_3.png"));
			this.blit(ms, this.leftPos + 16, this.topPos + 49, 0, 0, 16, 39, 16, 39);
		}
		if (Progress4Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("energized:textures/screens/tank_bar_4.png"));
			this.blit(ms, this.leftPos + 16, this.topPos + 36, 0, 0, 16, 52, 16, 52);
		}
		if (Progress5Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("energized:textures/screens/tank_bar_5.png"));
			this.blit(ms, this.leftPos + 16, this.topPos + 24, 0, 0, 16, 64, 16, 64);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Fuel:", 11, 7, -1);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
	}
}
