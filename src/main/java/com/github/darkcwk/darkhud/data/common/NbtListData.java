package com.github.darkcwk.darkhud.data.common;

import com.github.darkcwk.darkhud.data.util.ObjectWrapperUtil;

import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateSequenceModel;
import net.minecraft.nbt.NbtList;

public class NbtListData implements TemplateSequenceModel {
    private NbtList nbtList;

    @Override
    public TemplateModel get(int index) throws TemplateModelException {
        return ObjectWrapperUtil.wrap(nbtList.get(index));
    }

    @Override
    public int size() throws TemplateModelException {
        return nbtList.size();
    }

    public void update(NbtList nbtList) {
        this.nbtList = nbtList;
    }
}
