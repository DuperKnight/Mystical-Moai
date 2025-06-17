package com.duperknight.mysticalmoai.client;

import com.duperknight.mysticalmoai.block.MoaiEyeBlock;
import com.duperknight.mysticalmoai.block.MysticalMoaiBlocks;
import com.duperknight.mysticalmoai.block.entity.MoaiEyeBlockEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.render.RenderLayer;

public class MysticalMoaiClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // Register block color provider for the glow effect
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (state.get(MoaiEyeBlock.ACTIVE) && world != null && pos != null && tintIndex == 0) {
                // Get color from the block entity for tint index 0 (glow layer)
                if (world.getBlockEntity(pos) instanceof MoaiEyeBlockEntity blockEntity) {
                    return blockEntity.getGlowColor();
                }
            }
            return 0xFFFFFF; // White (no tint) for other layers
        }, MysticalMoaiBlocks.MOAI_EYE);

        // Use cutout render layer for MoaiEye to support transparency without letting light through
        BlockRenderLayerMap.INSTANCE.putBlock(MysticalMoaiBlocks.MOAI_EYE, RenderLayer.getCutout());
    }
}
