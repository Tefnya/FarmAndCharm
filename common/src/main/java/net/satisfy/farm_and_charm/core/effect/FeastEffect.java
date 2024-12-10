package net.satisfy.farm_and_charm.core.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;

import java.util.Objects;

public class FeastEffect extends MobEffect {
    private static final int SATIATION_INTERVAL = 40;
    private static final int SUSTENANCE_INTERVAL = 200;

    public FeastEffect() {
        super(MobEffectCategory.BENEFICIAL, 0);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide() && entity instanceof Player player) {
            int duration = this.getDuration(entity, this);
            if (duration % SATIATION_INTERVAL == 0) {
                if (!player.getFoodData().needsFood() &&
                        !player.hasEffect(MobEffects.REGENERATION) &&
                        player.getFoodData().getSaturationLevel() > 0f) {
                    player.heal(1.0F + amplifier);
                }
            }

            if (duration % SUSTENANCE_INTERVAL == 0) {
                FoodData foodData = player.getFoodData();
                if (foodData.getFoodLevel() >= 20) {
                    player.heal(1.0F);
                } else {
                    foodData.setFoodLevel(Math.min(foodData.getFoodLevel() + 1, 20));
                }
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % SATIATION_INTERVAL == 0 || duration % SUSTENANCE_INTERVAL == 0;
    }

    private int getDuration(LivingEntity entity, MobEffect effect) {
        return entity.getEffect(effect) != null ? Objects.requireNonNull(entity.getEffect(effect)).getDuration() : 0;
    }
}
