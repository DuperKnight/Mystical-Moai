package com.duperknight.mysticalmoai;

import com.duperknight.mysticalmoai.block.MysticalMoaiBlocks;
import com.duperknight.mysticalmoai.block.entity.MysticalMoaiBlockEntities;
import com.duperknight.mysticalmoai.item.MysticalMoaiItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MysticalMoai implements ModInitializer {
    public static final String MOD_ID = "mysticalmoai";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        MysticalMoaiBlocks.registerModBlocks();
        MysticalMoaiItems.registerModItems();
        MysticalMoaiBlockEntities.registerBlockEntities();
    }
}
