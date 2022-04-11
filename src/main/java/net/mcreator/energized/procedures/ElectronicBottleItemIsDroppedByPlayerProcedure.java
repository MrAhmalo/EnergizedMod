package net.mcreator.energized.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class ElectronicBottleItemIsDroppedByPlayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.ELECTRIC_SPARK, x, y, z, 15, 3, 3, 3, 0.05);
	}
}
