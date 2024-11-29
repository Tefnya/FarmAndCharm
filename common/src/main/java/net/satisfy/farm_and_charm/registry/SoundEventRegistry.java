package net.satisfy.farm_and_charm.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.satisfy.farm_and_charm.FarmAndCharm;
import net.satisfy.farm_and_charm.util.FarmAndCharmIdentifier;

public class SoundEventRegistry {

    private static final Registrar<SoundEvent> SOUND_EVENTS = DeferredRegister.create(FarmAndCharm.MOD_ID, Registries.SOUND_EVENT).getRegistrar();

    public static final RegistrySupplier<SoundEvent> COOKING_POT_BOILING = create("cooking_pot_boiling");

    public static void init() {}

    private static RegistrySupplier<SoundEvent> create(String name) {
        ResourceLocation id = new FarmAndCharmIdentifier(name);
        return SOUND_EVENTS.register(id, () -> {
            return SoundEvent.createVariableRangeEvent(id);
        });
    }
}
