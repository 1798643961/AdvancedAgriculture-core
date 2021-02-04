package xyz.icedtech.advagri.item;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import xyz.icedtech.advagri.block.AdvAgriBlocks;

import java.util.HashMap;
import java.util.Objects;


public class ForgingHammer extends Item {

    public HashMap<BlockPos, Integer> blockArrayList = new HashMap<>();

    public ForgingHammer(Settings settings) {
        super(settings);
    }


    //Todo: 2/4/21 11:34 PM
    // User: suibing
    // Aims: Use forging hammer 9 times,then the block will change into 9 plates
    // Desc: As aims
    // Stat: False
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        Block block = context.getWorld().getBlockState(context.getBlockPos()).getBlock();
        BlockPos blockPos = context.getBlockPos();


        if (matchMetalBlock(block)) {
            if (!blockArrayList.containsKey(context.getBlockPos())) {//不存在但是是可敲打方块
                blockArrayList.put(context.getBlockPos(), 1);
                return ActionResult.SUCCESS;
            } else if (blockArrayList.get(context.getBlockPos()) >= 18) {//存在但是敲打次数超过了9次
                blockArrayList.remove(blockPos);
                if (matchMetalBlock(block)) {
                    new ItemEntity(context.getWorld(), blockPos.getX(), blockPos.getY(), blockPos.getZ()).dropStack(dropPlate(block));
                    context.getWorld().breakBlock(blockPos, false);
                }
                return ActionResult.SUCCESS;
            } else {//敲打累增
                blockArrayList.put(blockPos, blockArrayList.get(context.getBlockPos()) + 1);
                return ActionResult.SUCCESS;
            }
        }

        return ActionResult.PASS;
    }


    public boolean matchMetalBlock(Block block) {
        return block == AdvAgriBlocks.getInstance().ALUMINIUM_BLOCK
                || block == AdvAgriBlocks.getInstance().BRONZE_BLOCK
                || block == AdvAgriBlocks.getInstance().COPPER_BLOCK
                || block == AdvAgriBlocks.getInstance().LEAD_BLOCK
                || block == AdvAgriBlocks.getInstance().SILVER_BLOCK
                || block == AdvAgriBlocks.getInstance().NICKEL_BLOCK
                || block == AdvAgriBlocks.getInstance().ZINC_BLOCK
                || block == AdvAgriBlocks.getInstance().STEEL_BLOCK
                || block == AdvAgriBlocks.getInstance().TUNGSTEN_BLOCK
                || block == AdvAgriBlocks.getInstance().TITANIUM_BLOCK
                || block == AdvAgriBlocks.getInstance().TIN_BLOCK
                || block == Blocks.GOLD_BLOCK
                || block == Blocks.IRON_BLOCK;
    }

    public ItemStack dropPlate(Block block) {
        AdvAgriBlocks advAgriBlocks = AdvAgriBlocks.getInstance();
        AdvAgriItems advAgriItems = AdvAgriItems.getInstance();

        if (Objects.equals(advAgriBlocks.ALUMINIUM_BLOCK.toString(), block.toString())) {
            return new ItemStack(advAgriItems.ALUMINIUM_PLATE, 9);
        } else if (Objects.equals(advAgriBlocks.BRONZE_BLOCK.toString(), block.toString())) {
            return new ItemStack(advAgriItems.BRONZE_PLATE, 9);
        } else {
            throw new IllegalStateException("Unexpected value: " + block.toString());
        }
    }
}