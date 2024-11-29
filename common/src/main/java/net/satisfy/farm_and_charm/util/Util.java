package net.satisfy.farm_and_charm.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Tuple;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

public class Util {

    public static Collection<ServerPlayer> tracking(ServerLevel world, BlockPos pos) {
        Objects.requireNonNull(pos, "BlockPos cannot be null");
        return tracking(world, new ChunkPos(pos));
    }

    public static Collection<ServerPlayer> tracking(ServerLevel world, ChunkPos pos) {
        Objects.requireNonNull(world, "The world cannot be null");
        Objects.requireNonNull(pos, "The chunk pos cannot be null");
        return world.getChunkSource().chunkMap.getPlayers(pos, false);
    }

    public static Optional<Tuple<Float, Float>> getRelativeHitCoordinatesForBlockFace(BlockHitResult blockHitResult, Direction direction, Direction[] unAllowedDirections) {
        Direction direction2 = blockHitResult.getDirection();
        if (Arrays.stream(unAllowedDirections).toList().contains(direction2)) {
            return Optional.empty();
        } else if (direction != direction2 && direction2 != Direction.UP && direction2 != Direction.DOWN) {
            return Optional.empty();
        } else {
            BlockPos blockPos = blockHitResult.getBlockPos().relative(direction2);
            Vec3 vec3 = blockHitResult.getLocation().subtract((double)blockPos.getX(), (double)blockPos.getY(), (double)blockPos.getZ());
            float d = (float)vec3.x();
            float f = (float)vec3.z();
            float y = (float)vec3.y();
            if (direction2 == Direction.UP || direction2 == Direction.DOWN) {
                direction2 = direction;
            }

            Optional var10000;
            switch (direction2) {
                case NORTH:
                    var10000 = Optional.of(new Tuple((float)(1.0 - (double)d), y));
                    break;
                case SOUTH:
                    var10000 = Optional.of(new Tuple(d, y));
                    break;
                case WEST:
                    var10000 = Optional.of(new Tuple(f, y));
                    break;
                case EAST:
                    var10000 = Optional.of(new Tuple((float)(1.0 - (double)f), y));
                    break;
                case DOWN:
                case UP:
                    var10000 = Optional.empty();
                    break;
                default:
                    throw new IncompatibleClassChangeError();
            }

            return var10000;
        }
    }
}
