package com.github.darkcwk.darkhud.data.darkhud.player;

import com.github.darkcwk.darkhud.data.common.ItemData;

import net.minecraft.client.MinecraftClient;

public class HandData {
    private static final MinecraftClient client = MinecraftClient.getInstance();

    private ItemData main;

    private ItemData off;

    public ItemData getMain() {
        return main;
    }

    public ItemData getOff() {
        return off;
    }

    public void update() {
        if (this.main == null) {
            this.main = new ItemData();
        }
        this.main.update(client.player.getMainHandStack());

        if (this.off == null) {
            this.off = new ItemData();
        }
        this.off.update(client.player.getOffHandStack());
    }
}
