package net.satisfy.farm_and_charm.core.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.satisfy.farm_and_charm.platform.PlatformHelper;

public class SustenanceEffect extends MobEffect {

    public SustenanceEffect() {
        super(MobEffectCategory.BENEFICIAL, 0);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.getCommandSenderWorld().isClientSide && entity instanceof Player player) {
            int interval = PlatformHelper.getSustenanceEffectInterval();
            int healAmount = PlatformHelper.getSustenanceEffectHealAmount();
            int foodIncrement = PlatformHelper.getSustenanceEffectFoodIncrement();

            if (entity.tickCount % interval == 0) {
                FoodData foodData = player.getFoodData();
                if (foodData.getFoodLevel() == 20) {
                    player.heal(healAmount);
                } else if (foodData.getFoodLevel() < 20) {
                    foodData.setFoodLevel(Math.min(foodData.getFoodLevel() + foodIncrement, 20));
                }
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % PlatformHelper.getSustenanceEffectInterval() == 0;
    }
}
