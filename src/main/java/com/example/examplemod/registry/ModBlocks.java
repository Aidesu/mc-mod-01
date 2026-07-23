package com.example.examplemod.registry;

import com.example.examplemod.mod01;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(mod01.MODID);

    public static final DeferredBlock<Block> EXAMPLE_BLOCK = BLOCKS.registerSimpleBlock("example_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE));

    public static final DeferredBlock<Block> BASTNASITE_ORE = BLOCKS.registerSimpleBlock("bastnasite_ore", BlockBehaviour.Properties.of()
            .strength(3.0f, 3.0f).requiresCorrectToolForDrops().mapColor(MapColor.COLOR_ORANGE));

    public static final DeferredBlock<Block> BAUXITE_ORE = BLOCKS.registerSimpleBlock("bauxite_ore", BlockBehaviour.Properties.of()
            .strength(3.0f, 3.0f).requiresCorrectToolForDrops().mapColor(MapColor.COLOR_YELLOW));

    public static final DeferredBlock<Block> ALUMINUM_BLOCK = BLOCKS.registerSimpleBlock("aluminum_block", BlockBehaviour.Properties.of()
            .strength(3.0f, 3.0f).requiresCorrectToolForDrops().mapColor(MapColor.COLOR_YELLOW));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}