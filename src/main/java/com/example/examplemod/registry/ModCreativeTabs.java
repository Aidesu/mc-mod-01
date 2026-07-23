package com.example.examplemod.registry;

import com.example.examplemod.mod01;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, mod01.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB =
            CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mod01"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> ModItems.TUNGSTEN_APPLE.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.TUNGSTEN_APPLE.get());
                        output.accept(ModItems.RAW_BASTNASITE.get());
                        output.accept(ModItems.BASTNASITE_DUST.get());
                        output.accept(ModItems.BASTNASITE_ORE_ITEM.get());
                        output.accept(ModItems.RAW_BAUXITE.get());
                        output.accept(ModItems.BAUXITE_ORE_ITEM.get());
                        output.accept(ModItems.ALUMINUM_INGOT.get());
                        output.accept(ModItems.ALUMINUM_INGOT_ITEM.get());
                        output.accept(ModItems.ALUMINUM_SWORD.get());
                        output.accept(ModItems.ALUMINUM_HAMMER.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}