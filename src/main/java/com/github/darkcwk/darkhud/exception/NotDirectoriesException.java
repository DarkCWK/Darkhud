package com.github.darkcwk.darkhud.exception;

import java.io.IOException;
import java.nio.file.Path;

public class NotDirectoriesException extends IOException {
    public NotDirectoriesException(Path path) {
        super("因为" + path + "存在但不是文件夹!");
    }

    public NotDirectoriesException(Path path, String message, Throwable throwable) {
        super("因为" + path + "存在但不是文件夹!", throwable);
    }
}
