package com.github.darkcwk.darkhud.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.github.darkcwk.darkhud.api.Data;

public class DataUtil {
    private static final Map<String, Data> root = new HashMap<>();

    public static final void register(String key, Data data) {
        root.put(key, data);
    }

    public static final Map<String, Data> getLatestData() {
        root.values().forEach(Data::update);
        return Collections.unmodifiableMap(root);
    }
}
