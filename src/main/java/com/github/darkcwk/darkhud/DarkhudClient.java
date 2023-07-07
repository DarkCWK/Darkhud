package com.github.darkcwk.darkhud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.darkcwk.darkhud.data.DarkhudData;
import com.github.darkcwk.darkhud.listener.ClientCommandRegistrationListener;
import com.github.darkcwk.darkhud.listener.HudRenderListener;
import com.github.darkcwk.darkhud.util.DataUtil;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class DarkhudClient implements ClientModInitializer {
    private static final Logger log = LoggerFactory.getLogger("Darkhud");

    @Override
    public void onInitializeClient() {
        log.info("onInitializeClient");

        HudRenderCallback.EVENT.register(HudRenderListener.HUD_RENDER_LISTENER);

        ClientCommandRegistrationCallback.EVENT
                .register(ClientCommandRegistrationListener.CLIENT_COMMAND_REGISTRATION_LISTENER);

        // 注册数据
        DataUtil.register("darkhud", new DarkhudData());
    }
}