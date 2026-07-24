package com.example.examplemod.worldgen;

import com.example.examplemod.mod01;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
    // C'est cette ligne qui manquait ou n'était pas publique :
    public static final ResourceKey<PlacedFeature> BAUXITE_ORE_PLACED_KEY = registerKey("bauxite_ore_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        Holder<ConfiguredFeature<?, ?>> bauxiteOreConfigured = context.lookup(Registries.CONFIGURED_FEATURE)
                .getOrThrow(ModConfiguredFeatures.BAUXITE_ORE_KEY);

        register(context, BAUXITE_ORE_PLACED_KEY, bauxiteOreConfigured,
                OrePlacement.commonOrePlacement(16, // Nombre de veines par chunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80)) // Hauteur min et max
                ));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(mod01.MODID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    public static class OrePlacement {
        public static List<PlacementModifier> modifiers(PlacementModifier p_195347_, PlacementModifier p_195348_) {
            return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
        }

        public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
            return modifiers(CountPlacement.of(p_195344_), p_195345_);
        }
    }
}