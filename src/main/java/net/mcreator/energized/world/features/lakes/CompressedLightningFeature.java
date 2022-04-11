
package net.mcreator.energized.world.features.lakes;

public class CompressedLightningFeature extends LakeFeature {
	public static final CompressedLightningFeature FEATURE = (CompressedLightningFeature) new CompressedLightningFeature()
			.setRegistryName("energized:compressed_lightning");
	public static final ConfiguredFeature<?, ?> CONFIGURED_FEATURE = FEATURE
			.configured(new BlockStateConfiguration(EnergizedModBlocks.COMPRESSED_LIGHTNING.defaultBlockState()))
			.rangeUniform(VerticalAnchor.aboveBottom(0), VerticalAnchor.belowTop(0)).squared().rarity(5);

	public static final Set<ResourceLocation> GENERATE_BIOMES = null;

	public CompressedLightningFeature() {
		super(BlockStateConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<BlockStateConfiguration> context) {
		WorldGenLevel world = context.level();
		ResourceKey<Level> dimensionType = world.getLevel().dimension();
		boolean dimensionCriteria = false;

		if (dimensionType == Level.OVERWORLD)
			dimensionCriteria = true;

		if (!dimensionCriteria)
			return false;

		return super.place(context);
	}
}
