package net.mcreator.energized.procedures;

import net.minecraftforge.eventbus.api.Event;

public class Progress1Procedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (new Object() {
			public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
							.ifPresent(capability -> _retval.set(capability.getFluidInTank(tank).getAmount()));
				return _retval.get();
			}
		}.getFluidTankLevel(world, new BlockPos((int) x, (int) y, (int) z), 1) > new Object() {
			public int getFluidTankCapacity(LevelAccessor level, BlockPos pos, int tank) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
							.ifPresent(capability -> _retval.set(capability.getTankCapacity(tank)));
				return _retval.get();
			}
		}.getFluidTankCapacity(world, new BlockPos((int) x, (int) y, (int) z), 1) / 6 && new Object() {
			public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
							.ifPresent(capability -> _retval.set(capability.getFluidInTank(tank).getAmount()));
				return _retval.get();
			}
		}.getFluidTankLevel(world, new BlockPos((int) x, (int) y, (int) z), 1) <= new Object() {
			public int getFluidTankCapacity(LevelAccessor level, BlockPos pos, int tank) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
							.ifPresent(capability -> _retval.set(capability.getTankCapacity(tank)));
				return _retval.get();
			}
		}.getFluidTankCapacity(world, new BlockPos((int) x, (int) y, (int) z), 1) / 6 * 2) {
			return true;
		}
		return false;
	}
}
