[Unreleased] - 2025.02.07

* The StoveBlockEntity needs testing with Candlelight to ensure compatibility. 
* Additionally, cart movement could be significantly improved, particularly when navigating inclines and declines. 
* Rename **Fertilizer** to **Compost** and restore its original **Bone Meal functionality**.
    - Adjust **recipes** accordingly to reflect this change.

* Introduce a new **Fertilizer** item with the current FertilizerItem Functionality.

**Added**
* Added the ability to retrieve items from the MincerBlock by Shift-Right Clicking

**Changed**
* Strawberry crop now only drops an Item when age == MAX_AGE
* Tomato crop now only drops an Item when age == MAX_AGE

**Fixed**
* Added an additional check for a valid recipe before increasing the Stirring value in CraftingBowlBlockEntity
* StoveBlockEntity now properly processes EffectBlockItem and applies stored effects to the crafted result
* Properly registered StorageBlockEntity & StorageBlockRenderer