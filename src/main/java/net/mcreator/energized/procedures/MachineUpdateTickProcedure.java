package net.mcreator.energized.procedures;

import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicInteger;

public class MachineUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double posX = 0;
		double drainValue = 0;
		double posY = 0;
		double posZ = 0;
		if ((new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(world, new BlockPos(x, y, z), "State")).equals("on")) {
			if (new Object() {
				public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
					AtomicInteger _retval = new AtomicInteger(0);
					BlockEntity _ent = level.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
								.ifPresent(capability -> _retval.set(capability.getFluidInTank(tank).getAmount()));
					return _retval.get();
				}
			}.getFluidTankLevel(world, new BlockPos(x, y, z), 1) >= 5) {
				drainValue = new Object() {
					public int drainTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
									.ifPresent(capability -> _retval.set(capability.drain(amount, IFluidHandler.FluidAction.SIMULATE).getAmount()));
						return _retval.get();
					}
				}.drainTankSimulate(world, new BlockPos(x, y, z), 5);
				{
					BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
					int _amount = (int) drainValue;
					if (_ent != null)
						_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
								.ifPresent(capability -> capability.drain(_amount, IFluidHandler.FluidAction.EXECUTE));
				}
				posX = x - 2;
				posZ = z - 2;
				posY = y - 2;
				for (int index0 = 0; index0 < (int) (5); index0++) {
					for (int index1 = 0; index1 < (int) (5); index1++) {
						if (((world.getBlockState(new BlockPos(posX, posY, posZ))).getBlock().getStateDefinition()
								.getProperty("age")instanceof IntegerProperty _ip
										? (world.getBlockState(new BlockPos(posX, posY, posZ))).getValue(_ip)
										: -1) < 7) {
							{
								int _value = (int) (((world.getBlockState(new BlockPos(posX, posY, posZ))).getBlock().getStateDefinition()
										.getProperty("age")instanceof IntegerProperty _ip
												? (world.getBlockState(new BlockPos(posX, posY, posZ))).getValue(_ip)
												: -1)
										+ 1);
								BlockPos _pos = new BlockPos((int) posX, (int) posY, (int) posZ);
								BlockState _bs = world.getBlockState(_pos);
								Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("age");
								if (_property instanceof IntegerProperty _integerProp && _property.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
						}
						posZ = posZ + 1;
					}
					posZ = z - 2;
					posX = posX + 1;
				}
			}
		}
	}
}
