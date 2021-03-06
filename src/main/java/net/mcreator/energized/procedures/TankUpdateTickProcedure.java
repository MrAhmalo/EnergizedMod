package net.mcreator.energized.procedures;

import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.FluidStack;

import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicInteger;

public class TankUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double fillValue = 0;
		if (new Object() {
			public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
							.ifPresent(capability -> _retval.set(capability.getFluidInTank(tank).getAmount()));
				return _retval.get();
			}
		}.getFluidTankLevel(world, new BlockPos(x, y, z), 1) >= 10 && new Object() {
			public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, Direction.UP)
							.ifPresent(capability -> _retval.set(capability.getFluidInTank(tank).getAmount()));
				return _retval.get();
			}
		}.getFluidTankLevel(world, new BlockPos(x, y - 1, z), 1) <= new Object() {
			public int getFluidTankCapacity(LevelAccessor level, BlockPos pos, int tank) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, Direction.UP)
							.ifPresent(capability -> _retval.set(capability.getTankCapacity(tank)));
				return _retval.get();
			}
		}.getFluidTankCapacity(world, new BlockPos(x, y - 1, z), 1) - 10) {
			fillValue = new Object() {
				public int fillTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
					AtomicInteger _retval = new AtomicInteger(0);
					BlockEntity _ent = level.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, Direction.UP).ifPresent(
								capability -> _retval.set(capability.fill(new FluidStack(Fluids.LAVA, amount), IFluidHandler.FluidAction.SIMULATE)));
					return _retval.get();
				}
			}.fillTankSimulate(world, new BlockPos(x, y - 1, z), 10);
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
				int _amount = (int) fillValue;
				if (_ent != null)
					_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
							.ifPresent(capability -> capability.drain(_amount, IFluidHandler.FluidAction.EXECUTE));
			}
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y - 1, z));
				int _amount = (int) fillValue;
				if (_ent != null)
					_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, Direction.UP)
							.ifPresent(capability -> capability.fill(new FluidStack(Fluids.LAVA, _amount), IFluidHandler.FluidAction.EXECUTE));
			}
		}
	}
}
