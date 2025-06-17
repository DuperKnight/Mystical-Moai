package com.duperknight.mysticalmoai.block;

import com.duperknight.mysticalmoai.block.entity.MoaiEyeBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MoaiEyeBlock extends BlockWithEntity {
    public static final MapCodec<MoaiEyeBlock> CODEC = createCodec(MoaiEyeBlock::new);
    public static final BooleanProperty ACTIVE = BooleanProperty.of("active");
    public static final EnumProperty<Direction.Axis> AXIS = Properties.AXIS;
    
    public MoaiEyeBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
            .with(ACTIVE, false)
            .with(AXIS, Direction.Axis.Y));
    }
    
    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }
    
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ACTIVE);
        builder.add(AXIS);
    }
    
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(AXIS, ctx.getSide().getAxis());
    }
    
    @Override
    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return PillarBlock.changeRotation(state, rotation);
    }
    
    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MoaiEyeBlockEntity(pos, state);
    }
    
    // Method to activate/deactivate the block
    public void setActive(World world, BlockPos pos, boolean active) {
        if (!world.isClient) {
            BlockState currentState = world.getBlockState(pos);
            world.setBlockState(pos, currentState.with(ACTIVE, active));
        }
    }
    
    // Method to toggle the active state
    public void toggleActive(World world, BlockPos pos) {
        if (!world.isClient) {
            BlockState currentState = world.getBlockState(pos);
            boolean isActive = currentState.get(ACTIVE);
            world.setBlockState(pos, currentState.with(ACTIVE, !isActive));
        }
    }
    
    // Method to check if block is active
    public boolean isActive(BlockState state) {
        return state.get(ACTIVE);
    }
    
    // Method to set glow color for specific block
    public void setGlowColor(World world, BlockPos pos, int color) {
        if (!world.isClient && world.getBlockEntity(pos) instanceof MoaiEyeBlockEntity blockEntity) {
            blockEntity.setGlowColor(color);
        }
    }
    
    // Method to get glow color for specific block
    public int getGlowColor(World world, BlockPos pos) {
        if (world.getBlockEntity(pos) instanceof MoaiEyeBlockEntity blockEntity) {
            return blockEntity.getGlowColor();
        }
        return 0x00FFFF; // Default cyan
    }
}
