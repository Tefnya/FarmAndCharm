package net.satisfy.farm_and_charm.core.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.satisfy.farm_and_charm.platform.PlatformHelper;

public class SatiationEffect extends MobEffect {
    public SatiationEffect() {
        super(MobEffectCategory.BENEFICIAL, 0);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity instanceof Player player) {
            int healAmount = PlatformHelper.getSatiationEffectHealAmount();
            if (player.getFoodData().needsFood() || player.hasEffect(MobEffects.REGENERATION) || player.getFoodData().getSaturationLevel() <= 0f) {
                return;
            }
            player.heal(healAmount + amplifier);
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        int interval = PlatformHelper.getSatiationEffectInterval();
        return duration % interval == 0;
    }
}
