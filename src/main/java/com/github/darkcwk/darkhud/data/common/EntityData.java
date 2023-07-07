package com.github.darkcwk.darkhud.data.common;

import com.github.darkcwk.darkhud.data.util.CastUtil;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeRegistry;
import net.minecraft.nbt.NbtCompound;

public class EntityData {
    private boolean has;

    private String name;

    private NbtData nbt;

    private BaseAttributeData baseAttribute;

    public BaseAttributeData getBaseAttribute() {
        return baseAttribute;
    }

    public NbtData getNbt() {
        return nbt;
    }

    public String getName() {
        return name;
    }

    public boolean isHas() {
        return has;
    }

    public void update(Entity targetedEntity) {
        if (!(targetedEntity instanceof LivingEntity)) {
            this.has = false;
            return;
        }

        LivingEntity entity = (LivingEntity) targetedEntity;

        this.has = true;

        this.name = entity.getType().getName().getString();

        if (this.nbt == null) {
            this.nbt = new NbtData();
        }
        this.nbt.update(entity.writeNbt(new NbtCompound()));

        if (this.baseAttribute == null) {
            this.baseAttribute = new BaseAttributeData();
        }
        this.baseAttribute.update(DefaultAttributeRegistry.get(CastUtil.cast(entity.getType())));
    }
}
