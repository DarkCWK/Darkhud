package com.github.darkcwk.darkhud.data.common;

import com.github.darkcwk.darkhud.data.util.NbtTypeUtil;
import com.github.darkcwk.darkhud.data.util.ObjectWrapperUtil;

import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;

public class NbtData implements TemplateHashModel {
    private NbtCompound nbtCompound;

    @Override
    public TemplateModel get(String key) throws TemplateModelException {
        // 物品可能没有 NBT
        if (key.equals("has")) {
            return ObjectWrapperUtil.wrap(!(nbtCompound == null));
        }

        NbtElement nbtElement = nbtCompound.get(key);

        if (nbtElement == null) {
            return null;
        }

        return ObjectWrapperUtil.wrap(NbtTypeUtil.toObject(nbtElement));
    }

    @Override
    public boolean isEmpty() throws TemplateModelException {
        return false;
    }

    public void update(NbtCompound nbtCompound) {
        this.nbtCompound = nbtCompound;
    }
}
