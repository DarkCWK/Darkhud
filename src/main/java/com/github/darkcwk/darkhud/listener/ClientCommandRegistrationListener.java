package com.github.darkcwk.darkhud.listener;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

import com.github.darkcwk.darkhud.command.EditCommand;
import com.github.darkcwk.darkhud.command.QueryCommand;
import com.github.darkcwk.darkhud.command.ToggleCommand;
import com.mojang.brigadier.CommandDispatcher;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.command.CommandRegistryAccess;

public enum ClientCommandRegistrationListener implements ClientCommandRegistrationCallback {
    CLIENT_COMMAND_REGISTRATION_LISTENER;

    @Override
    public void register(CommandDispatcher<FabricClientCommandSource> dispatcher,
            CommandRegistryAccess registryAccess) {
        dispatcher.register(literal("darkhud")
                .then(literal("query")
                        .then(literal("lt").executes(QueryCommand.LT_TOGGLE_COMMAND))
                        .then(literal("rt").executes(QueryCommand.RT_TOGGLE_COMMAND))
                        .then(literal("lb").executes(QueryCommand.LB_TOGGLE_COMMAND))
                        .then(literal("rb").executes(QueryCommand.RB_TOGGLE_COMMAND)))
                .then(literal("toggle")
                        .then(literal("lt").executes(ToggleCommand.LT_TOGGLE_COMMAND))
                        .then(literal("rt").executes(ToggleCommand.RT_TOGGLE_COMMAND))
                        .then(literal("lb").executes(ToggleCommand.LB_TOGGLE_COMMAND))
                        .then(literal("rb").executes(ToggleCommand.RB_TOGGLE_COMMAND)))
                .then(literal("edit")
                        .then(literal("lt").executes(EditCommand.LT_EDIT_COMMAND))
                        .then(literal("rt").executes(EditCommand.RT_EDIT_COMMAND))
                        .then(literal("lb").executes(EditCommand.LB_EDIT_COMMAND))
                        .then(literal("rb").executes(EditCommand.RB_EDIT_COMMAND))));
    }
}
