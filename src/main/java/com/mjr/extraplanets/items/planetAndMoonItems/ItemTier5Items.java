package com.mjr.extraplanets.items.planetAndMoonItems;

import java.util.List;

import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.ExtraPlanets;

public class ItemTier5Items extends Item {
	public static final String[] names = { "tier5engine", "tier5booster", "tier5Fin", "tier5HeavyDutyPlate", "compressedPalladium", "ingotPalladium", "compressedNickel", "ingotNickel", "redGem" };

	public ItemTier5Items(String assetName) {
		super();
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setUnlocalizedName(assetName);
		this.setCreativeTab(ExtraPlanets.ItemsTab);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return ClientProxyCore.galacticraftItem;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return this.getUnlocalizedName() + "." + ItemTier5Items.names[itemStack.getItemDamage()];
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int i = 0; i < ItemTier5Items.names.length; i++) {
			par3List.add(new ItemStack(par1, 1, i));
		}
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
		if (itemStack != null && itemStack.getItemDamage() == 3) {
			if (player.worldObj.isRemote) {
				list.add(EnumChatFormatting.GRAY + GCCoreUtil.translate("tier5.heavyDutyPlate.name"));
			}
		}
	}

}