package starhnl1.world;


import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.CompositeFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MinableConfig;
import net.minecraft.world.gen.placement.CountRange;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraftforge.registries.ForgeRegistries;
import starhnl1.lists.BlockList;

/**
 * Generates Ore for the world
 * @author HNL2000
 *
 */
public class OreGeneration 
{
	public static void setupOreGeneration()
	{
		for(Biome biome : ForgeRegistries.BIOMES)
		{
			CountRangeConfig copper_ore_placement = new CountRangeConfig(20, 30, 30, 80);
			biome.addFeature(Decoration.UNDERGROUND_ORES, new CompositeFeature<>(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, BlockList.copper_ore.getDefaultState(), 10), new CountRange(), copper_ore_placement));
			CountRangeConfig silver_ore_placement = new CountRangeConfig(8, 10, 10, 50);
			biome.addFeature(Decoration.UNDERGROUND_ORES, new CompositeFeature<>(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, BlockList.silver_ore.getDefaultState(), 7), new CountRange(), silver_ore_placement));
			CountRangeConfig titanium_ore_placement = new CountRangeConfig(6, 10, 10, 30);
			biome.addFeature(Decoration.UNDERGROUND_ORES, new CompositeFeature<>(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, BlockList.titanium_ore.getDefaultState(), 5), new CountRange(), titanium_ore_placement));
		}
	}
}
