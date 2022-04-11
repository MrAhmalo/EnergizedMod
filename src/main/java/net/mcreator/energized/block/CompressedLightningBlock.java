
package net.mcreator.energized.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class CompressedLightningBlock extends LiquidBlock {
	public CompressedLightningBlock() {
		super(EnergizedModFluids.COMPRESSED_LIGHTNING, BlockBehaviour.Properties.of(Material.LAVA).strength(100f)

		);
		setRegistryName("compressed_lightning");
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

}