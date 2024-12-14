package net.satisfy.farm_and_charm.core.registry;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.satisfy.farm_and_charm.core.util.FarmAndCharmIdentifier;

public interface ModelRegistry {
    ModelLayerLocation CART = new ModelLayerLocation(new FarmAndCharmIdentifier("supply_cart"), "main");
    ModelLayerLocation PLOW = new ModelLayerLocation(new FarmAndCharmIdentifier("plow"), "main");
}
