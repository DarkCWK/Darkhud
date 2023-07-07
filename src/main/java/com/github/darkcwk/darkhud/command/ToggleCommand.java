package com.github.darkcwk.darkhud.command;

import java.io.IOException;

import com.github.darkcwk.darkhud.util.ConfigUtil;
import com.github.darkcwk.darkhud.util.Constant;
import com.github.darkcwk.darkhud.util.ErrorUtil;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class ToggleCommand implements Command<FabricClientCommandSource> {
    private static final MinecraftClient client = MinecraftClient.getInstance();

    public static final ToggleCommand LT_TOGGLE_COMMAND = new ToggleCommand(Constant.LT_ENABLE_KEY);

    public static final ToggleCommand RT_TOGGLE_COMMAND = new ToggleCommand(Constant.RT_ENABLE_KEY);

    public static final ToggleCommand LB_TOGGLE_COMMAND = new ToggleCommand(Constant.LB_ENABLE_KEY);

    public static final ToggleCommand RB_TOGGLE_COMMAND = new ToggleCommand(Constant.RB_ENABLE_KEY);

    private String key;

    public ToggleCommand(String key) {
        this.key = key;
    }

    @Override
    public int run(CommandContext<FabricClientCommandSource> context) throws CommandSyntaxException {
        try {
            ConfigUtil.setAndSave(key, Boolean.toString(!ConfigUtil.getAsBoolean(key)));
        } catch (IOException e) {
            ErrorUtil.sendError("无法保存配置! 更改已恢复!", e);
            return -1;
        }

        client.player.sendMessage(Text.of("配置已更改!"));

        return 1;
    }
}
