package com.example.examplemod.registry;

import com.example.examplemod.mod01;
import com.example.examplemod.screen.ReflowOvenMenu;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(BuiltInRegistries.MENU, mod01.MODID);

    public static final DeferredHolder<MenuType<?>, MenuType<ReflowOvenMenu>> REFLOW_OVEN_MENU =
            MENUS.register("reflow_oven_menu", () -> IMenuTypeExtension.create(ReflowOvenMenu::new));

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}