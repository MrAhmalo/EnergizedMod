package net.mcreator.energized.procedures;

import net.minecraftforge.eventbus.api.Event;

@Mod.EventBusSubscriber
public class LightningCompressorLightningStruckProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinWorldEvent event) {
		Entity entity = event.getEntity();
		execute(event, event.getWorld(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LightningBolt) {
			if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == EnergizedModBlocks.LIGHTNING_COMPRESSOR) {
				{
					BlockEntity _ent = world.getBlockEntity(new BlockPos((int) x, (int) y, (int) z));
					int _amount = 1000;
					if (_ent != null)
						_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null).ifPresent(capability -> capability
								.fill(new FluidStack(EnergizedModFluids.COMPRESSED_LIGHTNING, _amount), IFluidHandler.FluidAction.EXECUTE));
				}
			}
		}
	}
}
