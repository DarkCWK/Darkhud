package com.github.darkcwk.darkhud.command;

import static net.minecraft.util.Util.getOperatingSystem;

import java.nio.file.Path;

import com.github.darkcwk.darkhud.util.Constant;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;

public class EditCommand implements Command<FabricClientCommandSource> {
    public static final EditCommand LT_EDIT_COMMAND = new EditCommand(Constant.LT_FILE_PATH);

    public static final EditCommand RT_EDIT_COMMAND = new EditCommand(Constant.RT_FILE_PATH);

    public static final EditCommand LB_EDIT_COMMAND = new EditCommand(Constant.LB_FILE_PATH);

    public static final EditCommand RB_EDIT_COMMAND = new EditCommand(Constant.RB_FILE_PATH);

    private Path path;

    public EditCommand(Path path) {
        this.path = path;
    }

    @Override
    public int run(CommandContext<FabricClientCommandSource> context) throws CommandSyntaxException {
        getOperatingSystem().open(path.toFile());

        return 1;
    }
}
