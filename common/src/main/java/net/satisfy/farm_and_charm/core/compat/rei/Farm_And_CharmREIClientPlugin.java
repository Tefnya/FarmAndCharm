package net.satisfy.farm_and_charm.core.compat.rei;

import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.satisfy.farm_and_charm.core.compat.rei.cooking.CookingPotCategory;
import net.satisfy.farm_and_charm.core.compat.rei.cooking.CookingPotDisplay;
import net.satisfy.farm_and_charm.core.compat.rei.doughing.CraftingBowlCategory;
import net.satisfy.farm_and_charm.core.compat.rei.doughing.CraftingBowlDisplay;
import net.satisfy.farm_and_charm.core.compat.rei.mincing.MincingCategory;
import net.satisfy.farm_and_charm.core.compat.rei.mincing.MincingDisplay;
import net.satisfy.farm_and_charm.core.compat.rei.roasting.RoasterCategory;
import net.satisfy.farm_and_charm.core.compat.rei.roasting.RoasterDisplay;
import net.satisfy.farm_and_charm.core.compat.rei.silo.SiloCategory;
import net.satisfy.farm_and_charm.core.compat.rei.silo.SiloDisplay;
import net.satisfy.farm_and_charm.core.compat.rei.stove.StoveCategory;
import net.satisfy.farm_and_charm.core.compat.rei.stove.StoveDisplay;
import net.satisfy.farm_and_charm.core.recipe.*;
import net.satisfy.farm_and_charm.core.registry.ObjectRegistry;

import java.util.ArrayList;
import java.util.List;

public class Farm_And_CharmREIClientPlugin {
    public static void registerCategories(CategoryRegistry registry) {
        registry.add(new CookingPotCategory());
        registry.add(new StoveCategory());
        registry.add(new CraftingBowlCategory());
        registry.add(new RoasterCategory());
        registry.add(new SiloCategory());
        registry.add(new MincingCategory());
        registry.addWorkstations(MincingCategory.MINCING_DISPLAY, EntryStacks.of(ObjectRegistry.MINCER.get()));
        registry.addWorkstations(CraftingBowlCategory.CRAFTING_BOWL_DISPLAY, EntryStacks.of(ObjectRegistry.CRAFTING_BOWL.get()));
        registry.addWorkstations(CookingPotDisplay.COOKING_POT_DISPLAY, EntryStacks.of(ObjectRegistry.COOKING_POT.get()));
        registry.addWorkstations(StoveDisplay.STOVE_DISPLAY, EntryStacks.of(ObjectRegistry.STOVE.get()));
        registry.addWorkstations(RoasterDisplay.ROASTER_DISPLAY, EntryStacks.of(ObjectRegistry.ROASTER.get()));
        registry.addWorkstations(SiloCategory.SILO_DISPLAY, EntryStacks.of(ObjectRegistry.SILO_WOOD.get()), EntryStacks.of(ObjectRegistry.SILO_COPPER.get()));
    }

    public static void registerDisplays(DisplayRegistry registry) {
        registry.registerFiller(CookingPotRecipe.class, CookingPotDisplay::new);
        registry.registerFiller(MincerRecipe.class, MincingDisplay::new);
        registry.registerFiller(StoveRecipe.class, StoveDisplay::new);
        registry.registerFiller(CraftingBowlRecipe.class, CraftingBowlDisplay::new);
        registry.registerFiller(RoasterRecipe.class, RoasterDisplay::new);
        registry.registerFiller(SiloRecipe.class, SiloDisplay::new);

    }

    public static List<Ingredient> ingredients(Recipe<Container> recipe, ItemStack stack) {
        List<Ingredient> l = new ArrayList<>(recipe.getIngredients());
        l.add(0, Ingredient.of(stack.getItem()));
        return l;
    }
}
