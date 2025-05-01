package de.catstorm.roastedonions.Item;

import de.catstorm.roastedonions.Block.SunflowerCrop;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;

public class SunflowerCropItem extends BlockItem {
    public SunflowerCropItem(Block p_40565_, Properties p_40566_) {
        super(p_40565_, p_40566_);
    }

    @Override
    protected boolean canPlace(BlockPlaceContext blockPlaceContext, BlockState blockState) {
        if (!((SunflowerCrop) getBlock()).mayPlaceOn(blockPlaceContext.getLevel().getBlockState(blockPlaceContext.getClickedPos().below()))) {
            return false;
        }
        Player player = blockPlaceContext.getPlayer();
        CollisionContext collisioncontext = player == null ? CollisionContext.empty() : CollisionContext.of(player);
        return (!this.mustSurvive() || blockState.canSurvive(blockPlaceContext.getLevel(), blockPlaceContext.getClickedPos())) && blockPlaceContext.getLevel().isUnobstructed(blockState, blockPlaceContext.getClickedPos(), collisioncontext);
    }
}
