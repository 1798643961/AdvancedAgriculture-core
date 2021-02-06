package xyz.icedtech.advagri.item;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class BambooChopper extends Item {
    public BambooChopper(Settings settings) {
        super(settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        Direction minerFacing = miner.getHorizontalFacing();
        if (minerFacing.equals(Direction.EAST)) {//Z-2,X
            breakBambooEAST(pos, world);
        } else if (minerFacing.equals(Direction.NORTH)) {//X-2,Z
            breakBambooNORTH(pos, world);
        } else if (minerFacing.equals(Direction.SOUTH)) {//X+2,Z
            breakBambooSOUTH(pos, world);
        } else if (minerFacing.equals(Direction.WEST)) {//Z+2,X
            breakBambooWEST(pos, world);
        }
        return super.postMine(stack, world, state, pos, miner);
    }

    private void breakBambooEAST(BlockPos blockPos, World world) {
        for (int X = 0; X <= 4; X++) {
            for (int Z = -2; Z <= 2; Z++) {
                world.breakBlock(new BlockPos(blockPos.getX() + X, blockPos.getY(), blockPos.getZ() + Z), true);
            }
        }
    }

    private void breakBambooNORTH(BlockPos blockPos, World world) {
        for (int X = -2; X <= 2; X++) {
            for (int Z = 0; Z >= -4; Z--) {
                world.breakBlock(new BlockPos(blockPos.getX() + X, blockPos.getY(), blockPos.getZ() + Z), true);
            }
        }
    }

    private void breakBambooSOUTH(BlockPos blockPos, World world) {
        for (int X = 2; X >= -2; X--) {
            for (int Z = 0; Z <= 4; Z++) {
                world.breakBlock(new BlockPos(blockPos.getX() + X, blockPos.getY(), blockPos.getZ() + Z), true);
            }
        }
    }

    private void breakBambooWEST(BlockPos blockPos, World world) {
        for (int X = 0; X >= -4; X--) {
            for (int Z = 2; Z >= -2; Z--) {
                world.breakBlock(new BlockPos(blockPos.getX() + X, blockPos.getY(), blockPos.getZ() + Z), true);
            }
        }
    }
}
