package com.mjr.extraplanets.blocks.treasureChest;

import micdoodle8.mods.galacticraft.core.blocks.BlockT1TreasureChest;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.mjr.extraplanets.tile.TileEntityT10TreasureChest;

public class T10TreasureChest extends BlockT1TreasureChest {
	public T10TreasureChest(String assetName) {
		super(assetName);
		this.setUnlocalizedName(assetName);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityT10TreasureChest();
	}
}