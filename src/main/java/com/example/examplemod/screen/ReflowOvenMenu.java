package com.example.examplemod.screen;

import com.example.examplemod.registry.ModBlocks;
import com.example.examplemod.registry.ModMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.SlotItemHandler;

public class ReflowOvenMenu extends AbstractContainerMenu {
    private final ContainerLevelAccess access;

    public ReflowOvenMenu(int containerId, Inventory playerInventory, FriendlyByteBuf extraData) {
        this(containerId, playerInventory, ContainerLevelAccess.NULL, new ItemStackHandler(3));
    }

    public ReflowOvenMenu(int containerId, Inventory playerInventory, ContainerLevelAccess access, ItemStackHandler inventory) {
        super(ModMenuTypes.REFLOW_OVEN_MENU.get(), containerId);
        this.access = access;

        this.addSlot(new SlotItemHandler(inventory, 0, 56, 17));
        // Slot 1 : Carburant
        this.addSlot(new SlotItemHandler(inventory, 1, 56, 53));
        // Slot 2 : Résultat
        this.addSlot(new SlotItemHandler(inventory, 2, 116, 35));

        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }

        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(playerInventory, col, 8 + col * 18, 142));
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (index < 3) {
                if (!this.moveItemStackTo(itemstack1, 3, 39, true)) return ItemStack.EMPTY;
            } else if (!this.moveItemStackTo(itemstack1, 0, 3, false)) {
                return ItemStack.EMPTY;
            }
            if (itemstack1.isEmpty()) slot.setByPlayer(ItemStack.EMPTY);
            else slot.setChanged();
        }
        return itemstack;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.access, player, ModBlocks.REFLOW_OVEN.get());
    }
}