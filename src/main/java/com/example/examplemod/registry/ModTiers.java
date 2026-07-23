package com.example.examplemod.registry;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModTiers {
    public static final Tier ALUMINIUM = new SimpleTier(
            BlockTags.INCORRECT_FOR_IRON_TOOL, // Niveau de minage
            1500,                              // Durabilité
            7.0f,                              // Vitesse de minage
            2.5f,                              // Dégâts d'attaque bonus
            14,                                // Enchantabilité
            () -> Ingredient.of(ModItems.ALUMINUM_INGOT.get()) // Élément de réparation
    );
}