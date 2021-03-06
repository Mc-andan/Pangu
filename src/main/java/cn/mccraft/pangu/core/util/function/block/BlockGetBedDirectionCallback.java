package cn.mccraft.pangu.core.util.function.block;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

@FunctionalInterface
public interface BlockGetBedDirectionCallback {
  EnumFacing apply(IBlockState arg0, IBlockAccess arg1, BlockPos arg2);
}
