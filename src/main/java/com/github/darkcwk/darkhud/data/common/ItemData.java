package com.github.darkcwk.darkhud.data.common;

import java.util.Objects;

import net.minecraft.item.ItemStack;

public class ItemData {
    private ItemStack itemStack;

    private boolean has;

    private String name;

    private NbtData nbt;

    private int maxDamage;

    public boolean isHas() {
        return has;
    }

    public String getName() {
        return name;
    }

    public NbtData getNbt() {
        return nbt;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void update(ItemStack itemStack) {
        if(Objects.equals(itemStack, this.itemStack)){
            return;
        }
        this.itemStack = itemStack;

        if (itemStack.isEmpty()) {
            this.has = false;
            return;
        }

        this.has = true;

        this.name = itemStack.getName().getString();

        if (this.nbt == null) {
            this.nbt = new NbtData();
        }
        this.nbt.update(itemStack.getNbt());

        this.maxDamage = itemStack.getMaxDamage();
    }
}
