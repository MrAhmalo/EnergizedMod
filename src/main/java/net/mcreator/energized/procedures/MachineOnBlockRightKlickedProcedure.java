package net.mcreator.energized.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.BlockPos;

import net.mcreator.energized.init.EnergizedModBlocks;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MachineOnBlockRightKlickedProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		Player entity = event.getPlayer();
		if (event.getHand() != entity.getUsedItemHand())
			return;
		execute(event, event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(),
				event.getWorld().getBlockState(event.getPos()), entity);
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		execute(null, world, x, y, z, blockstate, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		double posX = 0;
		double drainValue = 0;
		double posY = 0;
		double posZ = 0;
		if (blockstate.getBlock() == EnergizedModBlocks.MACHINE) {
			if (entity.isShiftKeyDown()) {
				if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getCount() == 0) {
					if (event != null && event.isCancelable()) {
						event.setCanceled(true);
					}
					if ((new Object() {
						public String getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getTileData().getString(tag);
							return "";
						}
					}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "State")).equals("on")) {
						if (!world.isClientSide()) {
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getTileData().putString("State", "off");
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (entity instanceof Player _player && !_player.level.isClientSide())
							_player.displayClientMessage(new TextComponent("Machine Off"), (true));
					} else {
						if (!world.isClientSide()) {
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getTileData().putString("State", "on");
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (entity instanceof Player _player && !_player.level.isClientSide())
							_player.displayClientMessage(new TextComponent("Machine On"), (true));
					}
				}
			}
		}
	}
}
