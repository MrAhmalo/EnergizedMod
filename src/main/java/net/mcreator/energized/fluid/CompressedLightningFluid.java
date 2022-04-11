
package net.mcreator.energized.fluid;

public abstract class CompressedLightningFluid extends ForgeFlowingFluid {

	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> EnergizedModFluids.COMPRESSED_LIGHTNING,
			() -> EnergizedModFluids.FLOWING_COMPRESSED_LIGHTNING,
			FluidAttributes.builder(new ResourceLocation("energized:blocks/compressedlightningfluidtexture"),
					new ResourceLocation("energized:blocks/compressedlightningfluidtexture"))

	).explosionResistance(100f)

			.bucket(() -> EnergizedModItems.COMPRESSED_LIGHTNING_BUCKET).block(() -> (LiquidBlock) EnergizedModBlocks.COMPRESSED_LIGHTNING);

	private CompressedLightningFluid() {
		super(PROPERTIES);
	}

	public static class Source extends CompressedLightningFluid {
		public Source() {
			super();
			setRegistryName("compressed_lightning");
		}

		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends CompressedLightningFluid {
		public Flowing() {
			super();
			setRegistryName("flowing_compressed_lightning");
		}

		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}

}
