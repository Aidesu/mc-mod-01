package com.example.examplemod.registry;

import com.example.examplemod.mod01;
import com.mojang.serialization.MapCodec; // <-- Ajout pour le Codec
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
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

    public static final DeferredBlock<Block> REFLOW_OVEN = BLOCKS.register("reflow_oven",
            () -> new ReflowOvenBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .strength(3.5f)
                    .sound(SoundType.METAL)
                    .noOcclusion()));

    public static class ReflowOvenBlock extends HorizontalDirectionalBlock {
        public static final MapCodec<ReflowOvenBlock> CODEC = simpleCodec(ReflowOvenBlock::new);

        public ReflowOvenBlock(Properties properties) {
            super(properties);
            this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
        }

        @Override
        protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
            return CODEC;
        }

        @Override
        public BlockState getStateForPlacement(BlockPlaceContext context) {
            return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
        }

        @Override
        protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
            builder.add(FACING);
        }
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}