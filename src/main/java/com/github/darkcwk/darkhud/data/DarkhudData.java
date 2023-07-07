package com.github.darkcwk.darkhud.data;

import com.github.darkcwk.darkhud.api.Data;
import com.github.darkcwk.darkhud.data.darkhud.LightData;
import com.github.darkcwk.darkhud.data.darkhud.PlayerData;
import com.github.darkcwk.darkhud.data.darkhud.StyleData;

import net.minecraft.client.MinecraftClient;
import net.minecraft.server.integrated.IntegratedServer;

public class DarkhudData implements Data {
    private static final MinecraftClient client = MinecraftClient.getInstance();

    // 样式
    private StyleData style;

    // 游戏帧率
    private int fps;

    // 服务器每 tick 时间;
    private float mspt;

    // 服务器每秒 tick;
    private int tps;

    // 服务器延迟
    private int latency;

    // 当前区块 id
    private String biomeId;

    // 当前维度 id
    private String dimensionId;

    // 是否下雨
    private boolean raining;

    // 是否雷暴雨
    private boolean thundering;

    // 是否单人游戏
    private boolean singleplayer;

    // 当日时间
    private int time;

    // 亮度信息
    private LightData light;

    // 玩家信息
    private PlayerData player;

    public StyleData getStyle() {
        return style;
    }

    public int getFps() {
        return fps;
    }

    public float getMspt() {
        return mspt;
    }

    public int getTps() {
        return tps;
    }

    public int getLatency() {
        return latency;
    }

    public String getBiomeId() {
        return biomeId;
    }

    public String getDimensionId() {
        return dimensionId;
    }

    public boolean isRaining() {
        return raining;
    }

    public boolean isThundering() {
        return thundering;
    }

    public boolean isSingleplayer() {
        return singleplayer;
    }

    public int getTime() {
        return time;
    }

    public LightData getLight() {
        return light;
    }

    public PlayerData getPlayer() {
        return player;
    }

    @Override
    public void update() {
        this.style = new StyleData();

        this.fps = client.getCurrentFps();

        IntegratedServer server = client.getServer();
        if (server == null) {
            this.mspt = -1;
            this.tps = -1;
        } else {
            this.mspt = server.getTickTime();
            this.tps = (int) (mspt <= 50 ? 20 : 1000 / mspt);
        }

        this.latency = client.getNetworkHandler().getPlayerListEntry(client.player.getUuid()).getLatency();

        this.biomeId = client.world.getBiome(client.cameraEntity.getBlockPos()).getKey().get().getValue().toString();

        this.dimensionId = client.world.getRegistryKey().getValue().toString();

        this.raining = client.world.isRaining();

        this.thundering = client.world.isThundering();

        this.singleplayer = client.isInSingleplayer();

        this.time = (int) (client.world.getTimeOfDay() % 24000);

        if (this.light == null) {
            this.light = new LightData();
        }
        this.light.update();

        if (this.player == null) {
            this.player = new PlayerData();
        }
        this.player.update();
    }
}
