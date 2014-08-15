/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2014
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.RotaryCraft.Items;

import Reika.DragonAPI.Libraries.World.ReikaWorldHelper;
import Reika.RotaryCraft.Base.ItemBasic;
import Reika.RotaryCraft.Blocks.BlockCanola;
import Reika.RotaryCraft.Registry.BlockRegistry;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class ItemCanolaSeed extends ItemBasic implements IPlantable {

	public ItemCanolaSeed(int tex) {
		super(tex);
		this.setMaxDamage(0);
		hasSubtypes = true;
	}

	@Override
	public boolean onItemUse(ItemStack items, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10) {
		if (items.getItemDamage() > 0)
			return false;
		if (!ReikaWorldHelper.softBlocks(world.getBlock(x, y, z))) {
			if (side == 0)
				--y;
			if (side == 1)
				++y;
			if (side == 2)
				--z;
			if (side == 3)
				++z;
			if (side == 4)
				--x;
			if (side == 5)
				++x;
		}
		Block idbelow = world.getBlock(x, y-1, z);
		if ((!ReikaWorldHelper.softBlocks(world.getBlock(x, y, z))) || !BlockCanola.isValidFarmBlock(world, x, y, z, idbelow))
			return false;
		if (!player.canPlayerEdit(x, y, z, 0, items))
			return false;
		else
		{
			if (!player.capabilities.isCreativeMode)
				--items.stackSize;
			world.setBlock(x, y, z, BlockRegistry.CANOLA.getBlockInstance());
			return true;
		}
	}

	@Override
	public int getItemSpriteIndex(ItemStack item) {
		return 80+item.getItemDamage();
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		return EnumPlantType.Crop;
	}

	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z) {
		return BlockRegistry.CANOLA.getBlockInstance();
	}

	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
		return 0;
	}
}