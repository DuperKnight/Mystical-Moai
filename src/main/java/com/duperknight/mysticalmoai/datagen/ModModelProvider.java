package com.duperknight.mysticalmoai.datagen;

import com.duperknight.mysticalmoai.block.MysticalMoaiBlocks;
import com.duperknight.mysticalmoai.item.MysticalMoaiItems;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(MysticalMoaiBlocks.RAW_PINK_GARNET_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(MysticalMoaiBlocks.PINK_GARNET_BLOCK);
        
        // Skip MoaiEye for now - handled manually due to complex overlay system
        // blockStateModelGenerator.excludeFromSimpleItemModelGeneration(MysticalMoaiBlocks.MOAI_EYE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // Items
        itemModelGenerator.register(MysticalMoaiItems.PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(MysticalMoaiItems.RAW_PINK_GARNET, Models.GENERATED);

        // Skip MoaiEye block item - handled manually
    }
}
