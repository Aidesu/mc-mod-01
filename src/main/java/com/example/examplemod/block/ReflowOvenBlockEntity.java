package com.example.examplemod.block;

import com.example.examplemod.screen.ReflowOvenMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;

public class ReflowOvenBlockEntity extends BlockEntity implements MenuProvider {

    public final ItemStackHandler inventory = new ItemStackHandler(3);

    public ReflowOvenBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.REFLOW_OVEN_BE.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, ReflowOvenBlockEntity blockEntity) {
        if (level.isClientSide()) return;

        // TODO : Logique
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Reflow Oven");
    }

    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory playerInventory, Player player) {
        return new ReflowOvenMenu(containerId, playerInventory, ContainerLevelAccess.create(level, worldPosition), this.inventory);
    }
}