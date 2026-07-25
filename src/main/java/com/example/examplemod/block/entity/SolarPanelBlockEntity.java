package com.example.examplemod.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.energy.EnergyStorage;
import net.neoforged.neoforge.energy.IEnergyStorage;

public class SolarPanelBlockEntity extends RandomizableContainerBlockEntity {
    private NonNullList<ItemStack> items = NonNullList.withSize(1, ItemStack.EMPTY);
    private final EnergyStorage energyStorage;

    public SolarPanelBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
        this.energyStorage = new EnergyStorage(1000);
    }

    public IEnergyStorage getEnergyStorage() {
        return this.energyStorage;
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.examplemod.solar_panel");
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> nonNullList) {
        this.items = nonNullList;
    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory inventory) {
        return null;
    }

    @Override
    public int getContainerSize() {
        return this.items.size();
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);

        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);

        if (!this.tryLoadLootTable(tag)) {
            ContainerHelper.loadAllItems(tag, this.items, registries);
        }

        if (tag.contains("EnergyStorage")) {
            this.energyStorage.deserializeNBT(registries, tag.get("EnergyStorage"));
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);

        if (!this.trySaveLootTable(tag)) {
            ContainerHelper.saveAllItems(tag, this.items, registries);
        }

        tag.put("EnergyStorage", this.energyStorage.serializeNBT(registries));
    }

    public static void tickServer(Level level, BlockPos pos, BlockState state, SolarPanelBlockEntity blockEntity) {
        if (level.isClientSide) return;

        int skyLight = level.getBrightness(LightLayer.SKY, pos.above()) - level.getSkyDarken();

        if (skyLight > 0) {
            int received = blockEntity.energyStorage.receiveEnergy(1, false);
            if (received > 0) {
                blockEntity.setChanged();
            }
        }
    }
}