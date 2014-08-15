/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2014
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.RotaryCraft.ModInterface.Lua;

import Reika.DragonAPI.ModInteract.Lua.LuaMethod;
import Reika.RotaryCraft.Auxiliary.Interfaces.PressureTE;

import net.minecraft.tileentity.TileEntity;

public class LuaGetPressure extends LuaMethod {

	public LuaGetPressure() {
		super("getPressure", PressureTE.class);
	}

	@Override
	public Object[] invoke(TileEntity te, Object[] args) throws Exception {
		return new Object[]{((PressureTE)te).getPressure()};
	}

	@Override
	public String getDocumentation() {
		return "Returns the internal pressure of the machine.\nArgs: None\nReturns: Pressure";
	}

	@Override
	public String getArgsAsString() {
		return "";
	}

	@Override
	public ReturnType getReturnType() {
		return ReturnType.INTEGER;
	}

}