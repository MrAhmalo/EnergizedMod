
package net.mcreator.energized.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

import net.mcreator.energized.init.EnergizedModFluids;

public class CompressedLightningBlock extends LiquidBlock {
	public CompressedLightningBlock() {
		super(() -> (FlowingFluid) EnergizedModFluids.COMPRESSED_LIGHTNING.get(), BlockBehaviour.Properties.of(Material.LAVA).strength(100f)

		);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}
}
