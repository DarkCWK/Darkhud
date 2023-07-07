package com.github.darkcwk.darkhud.data.darkhud.player;

import com.github.darkcwk.darkhud.data.common.ItemData;

import net.minecraft.client.MinecraftClient;

public class ArmorData {
    private static final MinecraftClient client = MinecraftClient.getInstance();

    private ItemData helmet;

    private ItemData chestplate;

    private ItemData leggings;

    private ItemData boots;

    public ItemData getHelmet() {
        return helmet;
    }

    public ItemData getChestplate() {
        return chestplate;
    }

    public ItemData getLeggings() {
        return leggings;
    }

    public ItemData getBoots() {
        return boots;
    }

    public void update() {
        if (this.helmet == null) {
            this.helmet = new ItemData();
        }
        this.helmet.update(client.player.getInventory().getArmorStack(3));

        if (this.chestplate == null) {
            this.chestplate = new ItemData();
        }
        this.chestplate.update(client.player.getInventory().getArmorStack(2));

        if (this.leggings == null) {
            this.leggings = new ItemData();
        }
        this.leggings.update(client.player.getInventory().getArmorStack(1));

        if (this.boots == null) {
            this.boots = new ItemData();
        }
        this.boots.update(client.player.getInventory().getArmorStack(0));
    }

}
