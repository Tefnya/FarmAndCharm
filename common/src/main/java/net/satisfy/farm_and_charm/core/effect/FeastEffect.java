package net.satisfy.farm_and_charm.core.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.satisfy.farm_and_charm.platform.PlatformHelper;

import java.util.Objects;

public class FeastEffect extends MobEffect {
    public FeastEffect() {
        super(MobEffectCategory.BENEFICIAL, 0);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide() && entity instanceof Player player) {
            int satiationInterval = PlatformHelper.getFeastEffectSatiationInterval();
            int sustenanceInterval = PlatformHelper.getFeastEffectSustenanceInterval();
            int healAmount = PlatformHelper.getFeastEffectHealAmount();

            int duration = this.getDuration(entity, this);
            if (duration % satiationInterval == 0) {
                if (!player.getFoodData().needsFood() &&
                        !player.hasEffect(MobEffects.REGENERATION) &&
                        player.getFoodData().getSaturationLevel() > 0f) {
                    player.heal(healAmount + amplifier);
                }
            }

            if (duration % sustenanceInterval == 0) {
                FoodData foodData = player.getFoodData();
                if (foodData.getFoodLevel() >= 20) {
                    player.heal(healAmount);
                } else {
                    foodData.setFoodLevel(Math.min(foodData.getFoodLevel() + 1, 20));
                }
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        int satiationInterval = PlatformHelper.getFeastEffectSatiationInterval();
        int sustenanceInterval = PlatformHelper.getFeastEffectSustenanceInterval();
        return duration % satiationInterval == 0 || duration % sustenanceInterval == 0;
    }

    private int getDuration(LivingEntity entity, MobEffect effect) {
        return entity.getEffect(effect) != null ? Objects.requireNonNull(entity.getEffect(effect)).getDuration() : 0;
    }
}
