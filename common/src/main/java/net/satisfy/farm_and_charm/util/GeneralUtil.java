package net.satisfy.farm_and_charm.util;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import org.jetbrains.annotations.Nullable;

public class GeneralUtil {

    public static void putBlockPos(CompoundTag compoundTag, BlockPos blockPos) {
        if (blockPos != null) {
            int[] positions = new int[]{blockPos.getX(), blockPos.getY(), blockPos.getZ()};
            compoundTag.putIntArray("block_pos", positions);
        }
    }

    public static @Nullable BlockPos readBlockPos(CompoundTag compoundTag) {
        if (!compoundTag.contains("block_pos")) {
            return null;
        } else {
            int[] positions = compoundTag.getIntArray("block_pos");
            return new BlockPos(positions[0], positions[1], positions[2]);
        }
    }
}
