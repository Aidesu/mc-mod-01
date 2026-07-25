package com.example.examplemod.block;

import com.example.examplemod.block.entity.SolarPanelBlockEntity;
import com.example.examplemod.mod01;
import com.example.examplemod.registry.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, mod01.MODID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ReflowOvenBlockEntity>> REFLOW_OVEN_BE =
            BLOCK_ENTITIES.register("reflow_oven_be", () ->
                    BlockEntityType.Builder.of(ReflowOvenBlockEntity::new, ModBlocks.REFLOW_OVEN.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SolarPanelBlockEntity>> SOLAR_PANEL =
            BLOCK_ENTITIES.register("solar_panel", () ->
                    BlockEntityType.Builder.of(
                            (pos, state) -> new SolarPanelBlockEntity(ModBlockEntities.SOLAR_PANEL.get(), pos, state),
                            ModBlocks.SOLAR_PANEL.get()
                    ).build(null)
            );

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}