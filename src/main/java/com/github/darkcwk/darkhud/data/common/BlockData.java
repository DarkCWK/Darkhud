package com.github.darkcwk.darkhud.data.common;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import net.minecraft.block.BlockState;

public class BlockData {
    private BlockState blockState;

    private boolean has;

    private String name;

    private Map<String, PropertyData> properties;

    public boolean isHas() {
        return has;
    }

    public String getName() {
        return name;
    }

    public Map<String, PropertyData> getProperties() {
        return properties;
    }

    public void update(BlockState blockState) {
        if (Objects.equals(blockState, this.blockState)) {
            return;
        }
        this.blockState = blockState;

        if (blockState == null) {
            this.blockState = null;
            this.has = false;

            return;
        }

        this.has = true;

        this.name = blockState.getBlock().getName().getString();

        this.properties = blockState.getProperties().stream()
                .collect(Collectors.toMap(
                        (item) -> item.getName(),
                        (item) -> new PropertyData(blockState.get(item), item.getValues())));
    }
}
