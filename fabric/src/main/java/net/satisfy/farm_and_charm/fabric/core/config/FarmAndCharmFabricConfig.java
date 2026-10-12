package net.satisfy.farm_and_charm.fabric.core.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "farm_and_charm")
@Config.Gui.Background("farm_and_charm:textures/block/fertilized_farmland_top.png")
public class FarmAndCharmFabricConfig implements ConfigData {
    @ConfigEntry.Gui.CollapsibleObject
    public FarmingSettings farming = new FarmingSettings();

    @ConfigEntry.Gui.CollapsibleObject
    public WaterSettings water = new WaterSettings();

    @ConfigEntry.Gui.CollapsibleObject
    public AnimalsSettings animals = new AnimalsSettings();

    @ConfigEntry.Gui.CollapsibleObject
    public KitchenSettings kitchen = new KitchenSettings();

    @ConfigEntry.Gui.CollapsibleObject
    public InfoTooltipSettings infoTooltips = new InfoTooltipSettings();

    @ConfigEntry.Gui.CollapsibleObject
    public EffectsSettings effects = new EffectsSettings();

    @ConfigEntry.Gui.CollapsibleObject
    public MiscSettings misc = new MiscSettings();

    @ConfigEntry.Gui.CollapsibleObject
    public FoodSettings food = new FoodSettings();

    public static class FarmingSettings {
        @ConfigEntry.Gui.Tooltip
        public boolean enableRainGrowthEffect = true;

        @ConfigEntry.Gui.Tooltip
        public boolean enableFireflies = true;

        @ConfigEntry.Gui.Tooltip
        public float rainGrowthMultiplier = 0.5f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 100)
        public int bigCropChance = 3;

        @ConfigEntry.Gui.Tooltip
        public boolean enableBonemealEffect = true;

        @ConfigEntry.Gui.Tooltip
        public boolean enableFertilizer = true;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 1, max = 16)
        public int fertilizedSoilRange = 5;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 1, max = 600)
        public int scarecrowGrowthInterval = 25;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 1, max = 16)
        public int scarecrowRange = 8;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 100)
        public int wildCropDropChance = 60;
    }

    public static class WaterSettings {
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 1, max = 16)
        public int waterSprinklerRange = 8;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 1, max = 32)
        public int wellGroundwaterDepth = 6;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 100)
        public int wellRainFillChance = 17;
    }

    public static class AnimalsSettings {
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 1, max = 16)
        public int feedingTroughRange = 8;

        @ConfigEntry.Gui.Tooltip
        public boolean enableDogFoodTaming = true;

        @ConfigEntry.Gui.Tooltip
        public boolean enableCatTamingChance = true;

        @ConfigEntry.Gui.Tooltip
        public boolean enableHorseTaming = true;

        @ConfigEntry.Gui.Tooltip
        public boolean enableHorseEffects = true;

        @ConfigEntry.Gui.Tooltip
        public boolean enableChickenEffects = true;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 1, max = 16)
        public int chickenCoopMaxChickens = 3;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 1, max = 64)
        public int chickenCoopMaxEggs = 9;

        @ConfigEntry.Gui.Tooltip
        public boolean enableDogBegging = true;

        @ConfigEntry.Gui.Tooltip
        public boolean enableCatBegging = true;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 4, max = 32)
        public int petBowlSearchRange = 16;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 23999)
        public int feedingTimeMiddayStart = 5800;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 23999)
        public int feedingTimeMiddayEnd = 6200;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 23999)
        public int feedingTimeEveningStart = 11500;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 23999)
        public int feedingTimeEveningEnd = 12500;
    }

    public static class KitchenSettings {
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 1, max = 20)
        public int ironCleaverChops = 5;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 1, max = 20)
        public int diamondCleaverChops = 3;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 1, max = 20)
        public int netheriteCleaverChops = 1;

        @ConfigEntry.Gui.Tooltip
        public boolean cleaverHeadDrops = true;

        @ConfigEntry.Gui.Tooltip
        public boolean cookingExperience = true;

        @ConfigEntry.Gui.Tooltip
        public float cookingExperienceMultiplier = 1.0f;
    }

    public static class InfoTooltipSettings {
        @ConfigEntry.Gui.Tooltip
        public boolean needDungarees = false;

        @ConfigEntry.Gui.Tooltip
        public boolean showCuttingBoardInfo = true;

        @ConfigEntry.Gui.Tooltip
        public boolean showMincerInfo = true;

        @ConfigEntry.Gui.Tooltip
        public boolean showCraftingBowlInfo = true;

        @ConfigEntry.Gui.Tooltip
        public boolean showSiloInfo = true;

        @ConfigEntry.Gui.Tooltip
        public boolean showWaterSprinklerInfo = true;

        @ConfigEntry.Gui.Tooltip
        public boolean showScarecrowInfo = true;
    }

    public static class EffectsSettings {
        @ConfigEntry.Gui.CollapsibleObject
        public ChickenEffectSettings chickenEffect = new ChickenEffectSettings();

        @ConfigEntry.Gui.CollapsibleObject
        public FeastEffectSettings feastEffect = new FeastEffectSettings();

        @ConfigEntry.Gui.CollapsibleObject
        public SustenanceEffectSettings sustenanceEffect = new SustenanceEffectSettings();

        @ConfigEntry.Gui.CollapsibleObject
        public SatiationEffectSettings satiationEffect = new SatiationEffectSettings();

        public static class ChickenEffectSettings {
            @ConfigEntry.Gui.Tooltip
            @ConfigEntry.BoundedDiscrete(min = 10, max = 600)
            public int chickenEffectTickInterval = 120;

            @ConfigEntry.Gui.Tooltip
            @ConfigEntry.BoundedDiscrete(min = 0, max = 100)
            public int chickenEffectEggChance = 20;

            @ConfigEntry.Gui.Tooltip
            @ConfigEntry.BoundedDiscrete(min = 0, max = 100)
            public int chickenEffectFeatherChance = 20;
        }

        public static class FeastEffectSettings {
            @ConfigEntry.Gui.Tooltip
            @ConfigEntry.BoundedDiscrete(min = 10, max = 200)
            public int feastEffectSatiationInterval = 40;

            @ConfigEntry.Gui.Tooltip
            @ConfigEntry.BoundedDiscrete(min = 50, max = 600)
            public int feastEffectSustenanceInterval = 200;

            @ConfigEntry.Gui.Tooltip
            @ConfigEntry.BoundedDiscrete(min = 1, max = 5)
            public int feastEffectHealAmount = 1;
        }

        public static class SustenanceEffectSettings {
            @ConfigEntry.Gui.Tooltip
            @ConfigEntry.BoundedDiscrete(min = 50, max = 600)
            public int sustenanceEffectInterval = 200;

            @ConfigEntry.Gui.Tooltip
            @ConfigEntry.BoundedDiscrete(min = 1, max = 5)
            public int sustenanceEffectHealAmount = 1;

            @ConfigEntry.Gui.Tooltip
            @ConfigEntry.BoundedDiscrete(min = 1, max = 20)
            public int sustenanceEffectFoodIncrement = 1;
        }

        public static class SatiationEffectSettings {
            @ConfigEntry.Gui.Tooltip
            @ConfigEntry.BoundedDiscrete(min = 10, max = 200)
            public int satiationEffectInterval = 40;

            @ConfigEntry.Gui.Tooltip
            @ConfigEntry.BoundedDiscrete(min = 1, max = 5)
            public int satiationEffectHealAmount = 1;
        }
    }

    public static class MiscSettings {
        @ConfigEntry.Gui.Tooltip
        public boolean animations = true;
    }

    public static class FoodSettings {
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int oatPancakeNutrition = 5;

        @ConfigEntry.Gui.Tooltip
        public float oatPancakeSaturation = 0.6f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int roastedCornNutrition = 5;

        @ConfigEntry.Gui.Tooltip
        public float roastedCornSaturation = 0.5f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int potatoWithRoastMeatNutrition = 7;

        @ConfigEntry.Gui.Tooltip
        public float potatoWithRoastMeatSaturation = 0.7f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int bakedLambHamNutrition = 8;

        @ConfigEntry.Gui.Tooltip
        public float bakedLambHamSaturation = 0.9f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int farmersBreakfastNutrition = 12;

        @ConfigEntry.Gui.Tooltip
        public float farmersBreakfastSaturation = 1.2f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int stuffedChickenNutrition = 8;

        @ConfigEntry.Gui.Tooltip
        public float stuffedChickenSaturation = 0.8f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int stuffedRabbitNutrition = 9;

        @ConfigEntry.Gui.Tooltip
        public float stuffedRabbitSaturation = 0.9f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int grandmothersStrawberryCakeNutrition = 4;

        @ConfigEntry.Gui.Tooltip
        public float grandmothersStrawberryCakeSaturation = 0.7f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int farmersBreadNutrition = 6;

        @ConfigEntry.Gui.Tooltip
        public float farmersBreadSaturation = 0.8f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int farmerSaladNutrition = 7;

        @ConfigEntry.Gui.Tooltip
        public float farmerSaladSaturation = 0.6f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int goulashNutrition = 8;

        @ConfigEntry.Gui.Tooltip
        public float goulashSaturation = 0.9f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int simpleTomatoSoupNutrition = 6;

        @ConfigEntry.Gui.Tooltip
        public float simpleTomatoSoupSaturation = 0.6f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int barleySoupNutrition = 5;

        @ConfigEntry.Gui.Tooltip
        public float barleySoupSaturation = 0.8f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int onionSoupNutrition = 7;

        @ConfigEntry.Gui.Tooltip
        public float onionSoupSaturation = 0.6f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int potatoSoupNutrition = 5;

        @ConfigEntry.Gui.Tooltip
        public float potatoSoupSaturation = 0.6f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int pastaWithOnionSauceNutrition = 6;

        @ConfigEntry.Gui.Tooltip
        public float pastaWithOnionSauceSaturation = 0.7f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int cornGritsNutrition = 6;

        @ConfigEntry.Gui.Tooltip
        public float cornGritsSaturation = 0.5f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int oatmealWithStrawberriesNutrition = 4;

        @ConfigEntry.Gui.Tooltip
        public float oatmealWithStrawberriesSaturation = 0.8f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int sausageWithOatPattyNutrition = 8;

        @ConfigEntry.Gui.Tooltip
        public float sausageWithOatPattySaturation = 0.9f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int lambWithCornNutrition = 8;

        @ConfigEntry.Gui.Tooltip
        public float lambWithCornSaturation = 0.8f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int beefPattyWithVegetablesNutrition = 6;

        @ConfigEntry.Gui.Tooltip
        public float beefPattyWithVegetablesSaturation = 0.8f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int barleyPattiesWithPotatoesNutrition = 5;

        @ConfigEntry.Gui.Tooltip
        public float barleyPattiesWithPotatoesSaturation = 0.9f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int baconWithEggsNutrition = 6;

        @ConfigEntry.Gui.Tooltip
        public float baconWithEggsSaturation = 0.7f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int chickenWrappedInBaconNutrition = 9;

        @ConfigEntry.Gui.Tooltip
        public float chickenWrappedInBaconSaturation = 0.9f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int cookedSalmonNutrition = 7;

        @ConfigEntry.Gui.Tooltip
        public float cookedSalmonSaturation = 0.9f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int cookedCodNutrition = 7;

        @ConfigEntry.Gui.Tooltip
        public float cookedCodSaturation = 0.9f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int roastedChickenNutrition = 5;

        @ConfigEntry.Gui.Tooltip
        public float roastedChickenSaturation = 0.8f;
    }

    @Override
    public void validatePostLoad() {
        farming.rainGrowthMultiplier = Math.max(0.0f, Math.min(2.0f, farming.rainGrowthMultiplier));
    }
}
