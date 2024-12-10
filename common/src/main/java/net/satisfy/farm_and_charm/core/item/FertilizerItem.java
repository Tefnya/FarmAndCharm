package net.satisfy.farm_and_charm.core.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FertilizerItem extends Item {
    public FertilizerItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        if (!world.isClientSide && world instanceof ServerLevel serverWorld) {
            List<BlockPos> potentialPositions = new ArrayList<>();
            for (int x = -2; x <= 2; ++x) {
                for (int z = -2; z <= 2; ++z) {
                    BlockPos blockPos = pos.offset(x, 0, z);
                    if (world.getBlockState(blockPos).is(BlockTags.CROPS) || world.getBlockState(blockPos).is(BlockTags.BAMBOO_PLANTABLE_ON)) {
                        potentialPositions.add(blockPos);
                    }
                }
            }

            Random random = new Random();
            int targets = random.nextInt(5) + 2;
            boolean applied = false;

            for (int i = 0; i < targets && !potentialPositions.isEmpty(); i++) {
                BlockPos targetPos = potentialPositions.remove(random.nextInt(potentialPositions.size()));
                BlockState blockState = world.getBlockState(targetPos);
                if (blockState.getBlock() instanceof BonemealableBlock bonemealableBlock) {
                    if (bonemealableBlock.isValidBonemealTarget(world, targetPos, blockState, false)) {
                        if (bonemealableBlock.isBonemealSuccess(world, world.random, targetPos, blockState)) {
                            bonemealableBlock.performBonemeal(serverWorld, world.random, targetPos, blockState);
                            serverWorld.sendParticles(ParticleTypes.HAPPY_VILLAGER, targetPos.getX() + 0.5, targetPos.getY() + 1.0, targetPos.getZ() + 0.5, 10, 0.5, 0.5, 0.5, 0.0);
                            world.levelEvent(2005, targetPos, 0);
                            applied = true;
                        }
                    }
                }
            }

            if (applied) {
                context.getItemInHand().shrink(1);
                return InteractionResult.sidedSuccess(world.isClientSide());
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BRUSH;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(player.getItemInHand(hand));
    }
}
