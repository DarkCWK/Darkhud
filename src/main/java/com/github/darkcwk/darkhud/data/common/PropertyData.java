package com.github.darkcwk.darkhud.data.common;

import java.util.Collection;

public class PropertyData {
    private Object value;

    private Collection<?> values;

    public PropertyData(Object value, Collection<?> collection) {
        this.value = value;
        this.values = collection;
    }

    public Object getValue() {
        return value;
    }

    public Collection<?> getValues() {
        return values;
    }
}
