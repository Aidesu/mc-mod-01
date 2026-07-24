package com.example.examplemod.item;

import com.example.examplemod.mod01;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(mod01.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
