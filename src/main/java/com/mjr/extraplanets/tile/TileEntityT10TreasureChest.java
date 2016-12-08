package com.mjr.extraplanets.tile;

import micdoodle8.mods.galacticraft.core.tile.TileEntityTreasureChest;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityT10TreasureChest extends TileEntityTreasureChest
{
    public TileEntityT10TreasureChest()
    {
        super(2);
    }

    public TileEntityT10TreasureChest(int tier)
    {
        super(tier);
    }

    public static TileEntityT10TreasureChest findClosest(Entity entity)
    {
        double distance = Double.MAX_VALUE;
        TileEntityT10TreasureChest chest = null;
        for (final TileEntity tile : entity.worldObj.loadedTileEntityList)
        {
            if (tile instanceof TileEntityT10TreasureChest)
            {
                double dist = entity.getDistanceSq(tile.getPos().getX() + 0.5, tile.getPos().getY() + 0.5, tile.getPos().getZ() + 0.5);
                if (dist < distance)
                {
                    distance = dist;
                    chest = (TileEntityT10TreasureChest) tile;
                }
            }
        }

        return chest;
    }
}