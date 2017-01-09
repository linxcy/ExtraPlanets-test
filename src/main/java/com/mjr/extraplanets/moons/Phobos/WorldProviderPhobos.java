package com.mjr.extraplanets.moons.Phobos;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldProviderSpace;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.api.world.ISolarLevel;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;

import com.mjr.extraplanets.moons.ExtraPlanets_Moons;
import com.mjr.extraplanets.moons.Phobos.worldgen.ChunkProviderPhobos;
import com.mjr.extraplanets.moons.Phobos.worldgen.WorldChunkManagerPhobos;

public class WorldProviderPhobos extends WorldProviderSpace implements IGalacticraftWorldProvider, ISolarLevel {
	@Override
	public float getGravity() {
		return 0F;
	}

	@Override
	public double getMeteorFrequency() {
		return 0;
	}

	@Override
	public double getFuelUsageMultiplier() {
		return 1.0;
	}

	@Override
	public boolean canSpaceshipTierPass(int tier) {
		return tier >= 2;
	}

	@Override
	public float getFallDamageModifier() {
		return 1;
	}

	@Override
	public float getSoundVolReductionAmount() {
		return 1;
	}

	@Override
	public boolean hasBreathableAtmosphere() {
		return false;
	}

	@Override
	public float getThermalLevelModifier() {
		return -10;
	}

	@Override
	public float getWindLevel() {
		return 10.0F;
	}

	@Override
	public float getSolarSize() {
		return 1.0f;
	}

	@Override
	public CelestialBody getCelestialBody() {
		return ExtraPlanets_Moons.phobos;
	}

	@Override
	public Vector3 getFogColor() {
		float f = 1.0F - this.getStarBrightness(1.0F);
		return new Vector3(168F / 255F * f, 164F / 255F * f, 160F / 255F * f);
	}

	@Override
	public Vector3 getSkyColor() {
		float f = 1.0F - this.getStarBrightness(1.0F);
		return new Vector3(150 / 255.0F * f, 146 / 255.0F * f, 143 / 255.0F * f);
	}

	@Override
	public boolean canRainOrSnow() {
		return false;
	}

	@Override
	public boolean hasSunset() {
		return false;
	}

	@Override
	public long getDayLength() {
		return 24000;
	}

	@Override
	public boolean shouldForceRespawn() {
		return true;
	}

	@Override
	public Class<? extends IChunkProvider> getChunkProviderClass() {
		return ChunkProviderPhobos.class;
	}

	@Override
	public Class<? extends WorldChunkManager> getWorldChunkManagerClass() {
		return WorldChunkManagerPhobos.class;
	}

	@Override
	public double getSolarEnergyMultiplier() {
		return 0.8D;
	}

	@Override
	public String getDimensionName() {
		return "Phobos";
	}

	@Override
	public String getInternalNameSuffix() {
		return "_phobos";
	}

}