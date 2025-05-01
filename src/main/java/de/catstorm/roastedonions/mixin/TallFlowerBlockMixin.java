package de.catstorm.roastedonions.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TallFlowerBlock.class)
public class TallFlowerBlockMixin {
    //TODO: fix this
    @Inject(method = "isValidBonemealTarget", at = @At("HEAD"), cancellable = true)
    public void isValidBonemealTarget(LevelReader p_256234_, BlockPos p_57304_, BlockState p_57305_, boolean p_57306_, CallbackInfoReturnable<Boolean> cir) {
        if (p_57305_.getBlock().equals(Blocks.SUNFLOWER)) cir.setReturnValue(false);
    }
}