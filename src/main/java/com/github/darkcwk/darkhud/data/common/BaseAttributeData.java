package com.github.darkcwk.darkhud.data.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.github.darkcwk.darkhud.data.util.ObjectWrapperUtil;

import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class BaseAttributeData implements TemplateHashModel {
    private Map<String, TemplateModel> cache = new HashMap<>();

    private DefaultAttributeContainer defaultAttribute;

    @Override
    public TemplateModel get(String key) throws TemplateModelException {
        TemplateModel cacheModel = cache.get(key);
        if (cacheModel != null) {
            return cacheModel;
        }

        EntityAttribute entityAttribute = Registries.ATTRIBUTE.get(Identifier.tryParse(key));
        if (entityAttribute == null) {
            this.cache.put(key, null);
            return null;
        }

        try {
            double baseValue = defaultAttribute.getBaseValue(entityAttribute);

            TemplateModel model = ObjectWrapperUtil.wrap(baseValue);
            this.cache.put(key, model);
            return model;
        } catch (IllegalArgumentException e) {
            this.cache.put(key, null);
            return null;
        }
    }

    @Override
    public boolean isEmpty() throws TemplateModelException {
        return false;
    }

    public void update(DefaultAttributeContainer defaultAttribute) {
        if (Objects.equals(defaultAttribute, this.defaultAttribute)) {
            return;
        }
        this.defaultAttribute = defaultAttribute;

        cache.clear();
    }
}
