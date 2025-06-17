package com.duperknight.mysticalmoai.block.entity;

import com.duperknight.mysticalmoai.MysticalMoai;
import com.duperknight.mysticalmoai.block.MysticalMoaiBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class MysticalMoaiBlockEntities {
    
    public static final BlockEntityType<MoaiEyeBlockEntity> MOAI_EYE_BLOCK_ENTITY = 
            Registry.register(Registries.BLOCK_ENTITY_TYPE, 
                    Identifier.of(MysticalMoai.MOD_ID, "moai_eye"), 
                    FabricBlockEntityTypeBuilder.create(MoaiEyeBlockEntity::new, MysticalMoaiBlocks.MOAI_EYE).build());
    
    public static void registerBlockEntities() {
        MysticalMoai.LOGGER.info("Registering Block Entities for " + MysticalMoai.MOD_ID);
    }
}
