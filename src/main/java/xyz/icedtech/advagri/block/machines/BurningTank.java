package xyz.icedtech.advagri.block.machines;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;
import xyz.icedtech.advagri.entities.block.BurningTankEntity;

public class BurningTank extends Block implements BlockEntityProvider {
    public BurningTank(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new BurningTankEntity();
    }
}
