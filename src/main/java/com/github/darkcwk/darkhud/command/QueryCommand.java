package com.github.darkcwk.darkhud.command;

import com.github.darkcwk.darkhud.util.ConfigUtil;
import com.github.darkcwk.darkhud.util.Constant;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class QueryCommand implements Command<FabricClientCommandSource> {
    private static final MinecraftClient client = MinecraftClient.getInstance();

    public static final QueryCommand LT_TOGGLE_COMMAND = new QueryCommand(Constant.LT_ENABLE_KEY);

    public static final QueryCommand RT_TOGGLE_COMMAND = new QueryCommand(Constant.RT_ENABLE_KEY);

    public static final QueryCommand LB_TOGGLE_COMMAND = new QueryCommand(Constant.LB_ENABLE_KEY);

    public static final QueryCommand RB_TOGGLE_COMMAND = new QueryCommand(Constant.RB_ENABLE_KEY);

    private String key;

    public QueryCommand(String key) {
        this.key = key;
    }

    @Override
    public int run(CommandContext<FabricClientCommandSource> context) throws CommandSyntaxException {
        client.player.sendMessage(Text.of(key + " 的值是 " + ConfigUtil.getAsBoolean(key)));
        return 1;
    }
}
