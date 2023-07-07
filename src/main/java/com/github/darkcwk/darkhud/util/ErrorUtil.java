package com.github.darkcwk.darkhud.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.darkcwk.darkhud.exception.NotDirectoriesException;
import com.github.darkcwk.darkhud.exception.NotFileException;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.crash.CrashReport;

public class ErrorUtil {
    private static final MinecraftClient client = MinecraftClient.getInstance();

    private static final Logger log = LoggerFactory.getLogger("Darkhud");

    public static void sendError(String message, Exception e) {
        if (client.player != null) {
            StringBuffer buffer = new StringBuffer()
                    .append("§4§l")
                    .append(e.getLocalizedMessage())
                    .append("\n")
                    .append("═".repeat(message.length()))
                    .append("\n")
                    .append(message);

            client.player.sendMessage(Text.of(buffer.toString()));
        }

        log.error(message, e);
    }

    public static void sendErrorWithStop(String message, Exception e) {
        sendError(message, e);
        client.setCrashReportSupplierAndAddDetails(CrashReport.create(e, message));
        client.stop();
    }

    public static void existsFileOrDefault(Path path, String defaultClasspath)
            throws NotFileException, NotDirectoriesException, IOException {
        if (!Files.exists(path)) {
            existsDirectoriesOrCreate(path.getParent());

            Files.copy(ErrorUtil.class.getClassLoader().getResourceAsStream(defaultClasspath), path);
        } else if (!Files.isRegularFile(path)) {
            throw new NotFileException(path);
        }
    }

    public static void existsDirectoriesOrCreate(Path path) throws NotDirectoriesException, IOException {
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        } else if (!Files.isDirectory(path)) {
            throw new NotDirectoriesException(path);
        }
    }
}
