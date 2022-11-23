package com.mjr.extraplanets.items.armor;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Nullable;

import org.lwjgl.input.Keyboard;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.api.item.IModularArmor;
import com.mjr.extraplanets.api.item.IPressureSuit;
import com.mjr.extraplanets.api.item.IRadiationSuit;
import com.mjr.extraplanets.client.model.ArmorCustomModel;
import com.mjr.extraplanets.client.model.ArmorSpaceSuitModel;
import com.mjr.extraplanets.items.armor.bases.ElectricArmorBase;
import com.mjr.extraplanets.items.armor.modules.Module;
import com.mjr.extraplanets.items.armor.modules.ModuleHelper;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

import micdoodle8.mods.galacticraft.api.item.IArmorGravity;
import micdoodle8.mods.galacticraft.api.item.IBreathableArmor;
import micdoodle8.mods.galacticraft.api.item.ISensorGlassesArmor;
import micdoodle8.mods.galacticraft.core.util.EnumColor;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Tier3SpaceSuitArmor extends ElectricArmorBase implements IPressureSuit, IRadiationSuit, IArmorGravity, IBreathableArmor, IModularArmor, ISensorGlassesArmor {
	public static HashMap<EntityEquipmentSlot, ArmorSpaceSuitModel> models = new HashMap<EntityEquipmentSlot, ArmorSpaceSuitModel>();
	public String name;

	public Tier3SpaceSuitArmor(String name, ArmorMaterial material, EntityEquipmentSlot placement) {
		super(material, 0, placement);
		this.setCreativeTab(ExtraPlanets.ItemsTab);
		this.name = name;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		if (stack.getItem() == ExtraPlanets_Armor.TIER_3_SPACE_SUIT_HELMET || stack.getItem() == ExtraPlanets_Armor.TIER_3_SPACE_SUIT_CHEST || stack.getItem() == ExtraPlanets_Armor.TIER_3_SPACE_SUIT_BOOTS) {
			return Constants.TEXTURE_PREFIX + "textures/model/armor/tier1_space_suit_main.png";
		} else if (stack.getItem() == ExtraPlanets_Armor.TIER_3_SPACE_SUIT_LEGINGS) {
			return Constants.TEXTURE_PREFIX + "textures/model/armor/tier1_space_suit_main.png";
		} else if (stack.getItem() == ExtraPlanets_Armor.TIER_3_SPACE_SUIT_GRAVITY_BOOTS) {
			return Constants.TEXTURE_PREFIX + "textures/model/armor/tier1_space_suit_main.png";
		} else {
			return null;
		}
	}

	@Override
	public int getArmorTier() {
		return 3;
	}

	@Override
	public int gravityOverrideIfLow(EntityPlayer p) {
		for (int i = 0; i < 4; i++)
			if (p.inventory.armorInventory.get(i) != null)
				if (p.inventory.armorInventory.get(i).getItem() == ExtraPlanets_Armor.TIER_3_SPACE_SUIT_GRAVITY_BOOTS)
					return 55;
		return 0;
	}

	@Override
	public int gravityOverrideIfHigh(EntityPlayer p) {
		for (int i = 0; i < 4; i++)
			if (p.inventory.armorInventory.get(i) != null)
				if (p.inventory.armorInventory.get(i).getItem() == ExtraPlanets_Armor.TIER_3_SPACE_SUIT_GRAVITY_BOOTS)
					return 75;
		return 0;
	}

	@Override
	public boolean handleGearType(EnumGearType gearType) {
		return true;
	}

	@Override
	public boolean canBreathe(ItemStack helmetInSlot, EntityPlayer playerWearing, EnumGearType type) {
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, @Nullable World world, List<String> list, ITooltipFlag flagIn) {
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			list.add(EnumColor.AQUA + TranslateUtilities.translate("space.suit.information"));
			list.add(EnumColor.AQUA + TranslateUtilities.translate("space.suit.information.2"));
			list.add(EnumColor.YELLOW + TranslateUtilities.translate("space.suit.information.extra"));
			list.add(EnumColor.YELLOW + TranslateUtilities.translate("space.suit.information.extra.2"));
			list.add(EnumColor.AQUA + TranslateUtilities.translate("space.suit.information.extra.3"));
			list.add(EnumColor.AQUA + TranslateUtilities.translate("space.suit.information.extra.4"));
		} else
			list.add(EnumColor.YELLOW + TranslateUtilities.translateWithFormat("item_desc.spacesuit.shift.name", GameSettings.getKeyDisplayString(FMLClientHandler.instance().getClient().gameSettings.keyBindSneak.getKeyCode())));
		if (Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)) {
			list.add(EnumColor.ORANGE + TranslateUtilities.translate("gui.module_list.name") + ":");
			for (Module module : ModuleHelper.getModules(itemStack))
				list.add(EnumColor.GREY + TranslateUtilities.translate("gui.module." + module.getName() + ".name"));
		} else
			list.add(EnumColor.AQUA + TranslateUtilities.translateWithFormat("item_desc.spacesuit.module.shift.name", GameSettings.getKeyDisplayString(FMLClientHandler.instance().getClient().gameSettings.keyBindSprint.getKeyCode())));
		super.addInformation(itemStack, world, list, flagIn);
	}

	public static ModelBiped fillingArmorModel(ModelBiped model, EntityLivingBase entityLiving) {
		if (model == null)
			return model;
		model.bipedHead.showModel = model.bipedHeadwear.showModel = model.bipedBody.showModel = model.bipedRightArm.showModel = model.bipedLeftArm.showModel = model.bipedRightLeg.showModel = model.bipedLeftLeg.showModel = false;
		model.isSneak = entityLiving.isSneaking();
		model.isRiding = entityLiving.isRiding();
		model.isChild = entityLiving.isChild();
		return model;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
		if(models.get(armorSlot) == null)
			models.put(armorSlot, new ArmorSpaceSuitModel(armorSlot));
		ModelBiped armorModel = models.get(armorSlot);
		if (itemStack.getItem() instanceof Tier3SpaceSuitArmor) {
			armorModel = fillingArmorModel(armorModel, entityLiving);
			if (hasColor(itemStack) && armorModel instanceof ArmorCustomModel)
				((ArmorCustomModel) armorModel).color = getColor(itemStack);
		}
		return armorModel;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void renderHelmetOverlay(ItemStack stack, EntityPlayer player, ScaledResolution resolution, float partialTicks) {
		ItemStack helmet = player.inventory.armorInventory.get(3);
		ItemStack chest = player.inventory.armorInventory.get(2);
		ItemStack leggins = player.inventory.armorInventory.get(1);
		ItemStack boots = player.inventory.armorInventory.get(0);

		if (helmet.isEmpty() == false && helmet.getItem() instanceof IModularArmor)
			for (Module hemletModules : ModuleHelper.getModules(helmet)) {
				if (hemletModules.isActive())
					if (ModuleHelper.hasPower(helmet, ModuleHelper.getModuleUseCost(hemletModules)))
						hemletModules.renderHelmetOverlay(stack, player, resolution, partialTicks);
			}
		if (chest.isEmpty() == false && chest.getItem() instanceof IModularArmor)
			for (Module chestModules : ModuleHelper.getModules(chest)) {
				if (chestModules.isActive())
					if (ModuleHelper.hasPower(chest, ModuleHelper.getModuleUseCost(chestModules)))
						chestModules.renderHelmetOverlay(stack, player, resolution, partialTicks);
			}
		if (leggins.isEmpty() == false && leggins.getItem() instanceof IModularArmor)
			for (Module legginsModules : ModuleHelper.getModules(leggins)) {
				if (legginsModules.isActive())
					if (ModuleHelper.hasPower(leggins, ModuleHelper.getModuleUseCost(legginsModules)))
						legginsModules.renderHelmetOverlay(stack, player, resolution, partialTicks);
			}
		if (boots.isEmpty() == false && boots.getItem() instanceof IModularArmor)
			for (Module bootsModules : ModuleHelper.getModules(boots)) {
				if (bootsModules.isActive())
					if (ModuleHelper.hasPower(boots, ModuleHelper.getModuleUseCost(bootsModules)))
						bootsModules.renderHelmetOverlay(stack, player, resolution, partialTicks);
			}
	}

	@Override
	public float getMaxElectricityStored(ItemStack theItem) {
		return 10000 * 50;
	}
}
