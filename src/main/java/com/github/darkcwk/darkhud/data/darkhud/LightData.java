package com.github.darkcwk.darkhud.data.darkhud;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;

public class LightData {
    private static final MinecraftClient client = MinecraftClient.getInstance();

    private int block;

    private int sky;

    private int total;

    public int getBlock() {
        return block;
    }

    public int getSky() {
        return sky;
    }

    public int getTotal() {
        return total;
    }

    public void update() {
        BlockPos blockPos = client.cameraEntity.getBlockPos();

        this.block = client.world.getLightLevel(LightType.BLOCK, blockPos);
        this.sky = client.world.getLightLevel(LightType.SKY, blockPos);

        client.world.calculateAmbientDarkness();
        
        this.total = client.world.getLightLevel(blockPos, client.world.getAmbientDarkness());
    }
}
