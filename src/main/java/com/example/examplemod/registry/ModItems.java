package com.example.examplemod.registry;

import com.example.examplemod.item.HammerItem;
import com.example.examplemod.item.WireCutterItem;
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

    public static final DeferredItem<Item> RAW_QUARTZITE = ITEMS.registerSimpleItem("raw_quartzite", new Item.Properties());
    public static final DeferredItem<Item> CRUSHED_QUARTZITE = ITEMS.registerSimpleItem("crushed_quartzite", new Item.Properties());
    public static final DeferredItem<Item> QUARTZITE_POWDER = ITEMS.registerSimpleItem("quartzite_powder", new Item.Properties());
    public static final DeferredItem<Item> ENRICHED_QUARTZITE = ITEMS.registerSimpleItem("enriched_quartzite", new Item.Properties());
    public static final DeferredItem<BlockItem> QUARTZITE_ORE_ITEM = ITEMS.registerSimpleBlockItem("quartzite_ore", ModBlocks.QUARTZITE_ORE);

    public static final DeferredItem<Item> RAW_BAUXITE = ITEMS.registerSimpleItem("raw_bauxite", new Item.Properties());
    public static final DeferredItem<BlockItem> BAUXITE_ORE_ITEM = ITEMS.registerSimpleBlockItem("bauxite_ore", ModBlocks.BAUXITE_ORE);


    public static final DeferredItem<Item> COPPER_WIRE = ITEMS.registerSimpleItem("copper_wire", new Item.Properties());
    public static final DeferredItem<Item> SOLDER_WIRE = ITEMS.registerSimpleItem("solder_wire", new Item.Properties());

//    public static final DeferredItem<Item> SILICON_WAFER = ITEMS.registerSimpleItem("silicon_wafer", new Item.Properties());
//    public static final DeferredItem<Item> MICROCHIP = ITEMS.registerSimpleItem("microchip", new Item.Properties());
//    public static final DeferredItem<Item> PCB = ITEMS.registerSimpleItem("pcb", new Item.Properties());
//    public static final DeferredItem<Item> MOTHERBOARD = ITEMS.registerSimpleItem("motherboard", new Item.Properties());
//
//    public static final DeferredItem<Item> TIN_INGOT = ITEMS.registerSimpleItem("tin_ingot", new Item.Properties());


    public static final DeferredItem<Item> MG_SI = ITEMS.registerSimpleItem("mg_si", new Item.Properties());
    public static final DeferredItem<Item> EG_SI = ITEMS.registerSimpleItem("eg_si", new Item.Properties());
    public static final DeferredItem<Item> CRUDE_SILICA = ITEMS.registerSimpleItem("crude_silica", new Item.Properties());
    public static final DeferredItem<Item> PURIFIED_SILICA = ITEMS.registerSimpleItem("purified_silica", new Item.Properties());


    public static final DeferredItem<Item> ALUMINUM_PLATE = ITEMS.registerSimpleItem("aluminum_plate", new Item.Properties());
    public static final DeferredItem<Item> COPPER_PLATE = ITEMS.registerSimpleItem("copper_plate", new Item.Properties());
    public static final DeferredItem<Item> IRON_PLATE = ITEMS.registerSimpleItem("iron_plate", new Item.Properties());

    public static final DeferredItem<Item> ALUMINUM_INGOT = ITEMS.registerSimpleItem("aluminum_ingot", new Item.Properties());
    public static final DeferredItem<BlockItem> ALUMINUM_INGOT_ITEM = ITEMS.registerSimpleBlockItem("aluminum_block", ModBlocks.ALUMINUM_BLOCK);

    public static final DeferredItem<Item> WIRE_CUTTER = ITEMS.register("wire_cutter",
            () -> new WireCutterItem(new Item.Properties()
                    .durability(25)
                    .stacksTo(1)));

    public static final DeferredItem<Item> ALUMINUM_HAMMER = ITEMS.register("aluminum_hammer",
            () -> new HammerItem(new Item.Properties()
                    .durability(100)
                    .stacksTo(1)));

    public static final DeferredItem<Item> ALUMINUM_SWORD = ITEMS.register("aluminum_sword",
            () -> new SwordItem(
                    ModTiers.ALUMINIUM,
                    new Item.Properties().attributes(SwordItem.createAttributes(ModTiers.ALUMINIUM, 3.0f, -2.0f))
            )
    );

    public static final DeferredItem<Item> MG_SI_SWORD = ITEMS.register("mg_si_sword",
            () -> new SwordItem(
                    ModTiers.MG_SI,
                    new Item.Properties().attributes(SwordItem.createAttributes(ModTiers.ALUMINIUM, 5.5f, -1.8f))
            )
    );

    public static final DeferredItem<Item> EG_SI_SWORD = ITEMS.register("eg_si_sword",
            () -> new SwordItem(
                    ModTiers.EG_SI,
                    new Item.Properties().attributes(SwordItem.createAttributes(ModTiers.ALUMINIUM, 8.5f, -1.4f))
            )
    );

    public static final DeferredItem<BlockItem> REFLOW_OVEN_ITEM = ITEMS.registerSimpleBlockItem("reflow_oven", ModBlocks.REFLOW_OVEN);
    public static final DeferredItem<BlockItem> SOLAR_PANEL = ITEMS.registerSimpleBlockItem("solar_panel", ModBlocks.SOLAR_PANEL);


    public static final DeferredItem<Item> TUNGSTEN_APPLE = ITEMS.registerSimpleItem("tungsten_apple",
            new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationModifier(1.2f).build()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}