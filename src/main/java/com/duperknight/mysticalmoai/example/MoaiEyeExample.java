package com.duperknight.mysticalmoai.example;

import com.duperknight.mysticalmoai.block.MoaiEyeBlock;
import com.duperknight.mysticalmoai.block.MysticalMoaiBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Example class showing how to use the MoaiEye block programmatically
 */
public class MoaiEyeExample {
    
    public static void activateEye(World world, BlockPos pos) {
        if (world.getBlockState(pos).isOf(MysticalMoaiBlocks.MOAI_EYE)) {
            MoaiEyeBlock block = (MoaiEyeBlock) MysticalMoaiBlocks.MOAI_EYE;
            block.setActive(world, pos, true);
        }
    }
    
    public static void deactivateEye(World world, BlockPos pos) {
        if (world.getBlockState(pos).isOf(MysticalMoaiBlocks.MOAI_EYE)) {
            MoaiEyeBlock block = (MoaiEyeBlock) MysticalMoaiBlocks.MOAI_EYE;
            block.setActive(world, pos, false);
        }
    }
    
    public static void toggleEye(World world, BlockPos pos) {
        if (world.getBlockState(pos).isOf(MysticalMoaiBlocks.MOAI_EYE)) {
            MoaiEyeBlock block = (MoaiEyeBlock) MysticalMoaiBlocks.MOAI_EYE;
            block.toggleActive(world, pos);
        }
    }
    
    public static void setEyeColor(World world, BlockPos pos, int color) {
        // Set the glow color for a specific MoaiEye block
        if (world.getBlockState(pos).isOf(MysticalMoaiBlocks.MOAI_EYE)) {
            MoaiEyeBlock block = (MoaiEyeBlock) MysticalMoaiBlocks.MOAI_EYE;
            block.setGlowColor(world, pos, color);
        }
    }
    
    public static int getEyeColor(World world, BlockPos pos) {
        // Get the glow color for a specific MoaiEye block
        if (world.getBlockState(pos).isOf(MysticalMoaiBlocks.MOAI_EYE)) {
            MoaiEyeBlock block = (MoaiEyeBlock) MysticalMoaiBlocks.MOAI_EYE;
            return block.getGlowColor(world, pos);
        }
        return 0x00FFFF; // Default cyan
    }
    
    // Example colors you can use:
    public static final int RED = 0xFF0000;
    public static final int GREEN = 0x00FF00;
    public static final int BLUE = 0x0000FF;
    public static final int CYAN = 0x00FFFF;
    public static final int MAGENTA = 0xFF00FF;
    public static final int YELLOW = 0xFFFF00;
    public static final int PURPLE = 0x8000FF;
    public static final int ORANGE = 0xFF8000;
}
