package de.catstorm.roastedonions.Block;

import de.catstorm.roastedonions.RoastedOnions;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;

public class SunflowerCrop extends CropBlock {
    public int maxAge;

    public SunflowerCrop(Properties p_52247_, int maxAge) {
        super(p_52247_);
        this.maxAge = maxAge + 1;
    }

    @Override
    public int getMaxAge() {
        return maxAge;
    }

    public boolean mayPlaceOn(BlockState p_52302_) {
        RoastedOnions.LOGGER.info(":3");
        return p_52302_.is(Blocks.GRASS_BLOCK);
    }

    @Override
    public boolean canSurvive(BlockState p_52282_, LevelReader p_52283_, BlockPos p_52284_) {
        return true;
    }

    @Override
    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (serverLevel.isAreaLoaded(blockPos, 1)) {
            if (serverLevel.getRawBrightness(blockPos, 0) >= 9) {
                int i = this.getAge(blockState);
                if (i < this.getMaxAge()) {
                    float f = getGrowthSpeed(this, serverLevel, blockPos);
                    if (ForgeHooks.onCropsGrowPre(serverLevel, blockPos, blockState, randomSource.nextInt((int)(25.0F / f) + 1) == 0)) {
                        serverLevel.setBlock(blockPos, this.getStateForAge(i + 1), 2);
                        if (i >= this.getMaxAge()-1) DoublePlantBlock.placeAt(serverLevel, Blocks.SUNFLOWER.defaultBlockState(), blockPos, 2);
                        ForgeHooks.onCropsGrowPost(serverLevel, blockPos, blockState);
                    }
                }
            }
        }
    }

    @Override
    public void growCrops(Level level, BlockPos blockPos, BlockState blockState) {
        int i = this.getAge(blockState) + this.getBonemealAgeIncrease(level);
        int j = this.getMaxAge();
        if (i > j) {
            i = j;
        }

        if (i >= j-1) DoublePlantBlock.placeAt(level, Blocks.SUNFLOWER.defaultBlockState(), blockPos, 0);
        else level.setBlock(blockPos, this.getStateForAge(i), 2);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return RoastedOnions.sunflower_seed_item.get();
    }
}