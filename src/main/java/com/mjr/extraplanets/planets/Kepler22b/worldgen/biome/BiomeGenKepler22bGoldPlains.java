package com.mjr.extraplanets.planets.Kepler22b.worldgen.biome;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.Kepler22bBiomes;

public class BiomeGenKepler22bGoldPlains extends Kepler22bBiomes {
	public BiomeGenKepler22bGoldPlains(BiomeProperties properties) {
		super(properties);
		this.topBlock = ExtraPlanets_Blocks.GOLD_GRIT.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.GOLD_GRIT.getDefaultState();
		this.getBiomeDecorator().goldTreesPerChunk = 10;
		this.getBiomeDecorator().goldSpheresPerChunk = 2;
	}
	
	@Override
	public void registerTypes() {
		BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.LUSH);
	}
}