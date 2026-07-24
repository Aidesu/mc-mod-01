package com.example.examplemod.registry;

import com.example.examplemod.mod01;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.item.SwordItem;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(mod01.MODID);

    public static final DeferredItem<BlockItem> EXAMPLE_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("example_block", ModBlocks.EXAMPLE_BLOCK);

    public static final DeferredItem<Item> RAW_BASTNASITE = ITEMS.registerSimpleItem("raw_bastnasite", new Item.Properties());
    public static final DeferredItem<BlockItem> BASTNASITE_ORE_ITEM = ITEMS.registerSimpleBlockItem("bastnasite_ore", ModBlocks.BASTNASITE_ORE);
    public static final DeferredItem<Item> BASTNASITE_DUST = ITEMS.registerSimpleItem("bastnasite_dust", new Item.Properties());

    public static final DeferredItem<Item> RAW_BAUXITE = ITEMS.registerSimpleItem("raw_bauxite", new Item.Properties());
    public static final DeferredItem<BlockItem> BAUXITE_ORE_ITEM = ITEMS.registerSimpleBlockItem("bauxite_ore", ModBlocks.BAUXITE_ORE);

    public static final DeferredItem<Item> ALUMINUM_INGOT = ITEMS.registerSimpleItem("aluminum_ingot", new Item.Properties());
    public static final DeferredItem<BlockItem> ALUMINUM_INGOT_ITEM = ITEMS.registerSimpleBlockItem("aluminum_block", ModBlocks.ALUMINUM_BLOCK);
    public static final DeferredItem<Item> ALUMINUM_HAMMER = ITEMS.registerSimpleItem("aluminum_hammer", new Item.Properties());

    public static final DeferredItem<Item> ALUMINUM_SWORD = ITEMS.register("aluminum_sword",
            () -> new SwordItem(
                    ModTiers.ALUMINIUM,
                    new Item.Properties().attributes(SwordItem.createAttributes(ModTiers.ALUMINIUM, 3.0f, -2.4f))
            )
    );

    public static final DeferredItem<BlockItem> REFLOW_OVEN_ITEM = ITEMS.registerSimpleBlockItem("reflow_oven", ModBlocks.REFLOW_OVEN);

    public static final DeferredItem<Item> TUNGSTEN_APPLE = ITEMS.registerSimpleItem("tungsten_apple",
            new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationModifier(1.2f).build()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}