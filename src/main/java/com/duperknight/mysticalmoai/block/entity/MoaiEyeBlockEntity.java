package com.duperknight.mysticalmoai.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class MoaiEyeBlockEntity extends BlockEntity {
    private int glowColor = 0x00FFFF; // Default cyan
    
    public MoaiEyeBlockEntity(BlockPos pos, BlockState state) {
        super(MysticalMoaiBlockEntities.MOAI_EYE_BLOCK_ENTITY, pos, state);
    }
    
    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        nbt.putInt("GlowColor", this.glowColor);
    }
    
    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        int oldColor = this.glowColor;
        this.glowColor = nbt.getInt("GlowColor").orElse(0x00FFFF);
        
        // Sync to client if color changed
        if (world != null && !world.isClient && oldColor != this.glowColor) {
            world.updateListeners(pos, getCachedState(), getCachedState(), 3);
        }
    }
    
    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }
    
    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }
    
    public int getGlowColor() {
        return glowColor;
    }
    
    public void setGlowColor(int glowColor) {
        this.glowColor = glowColor;
        markDirty();
        if (world != null && !world.isClient) {
            // Update both server and client
            world.updateListeners(pos, getCachedState(), getCachedState(), 3);
        }
        if (world != null && world.isClient) {
            // Force client-side block re-render
            world.updateListeners(pos, getCachedState(), getCachedState(), 8);
        }
    }
}
