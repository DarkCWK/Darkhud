package com.github.darkcwk.darkhud.exception;

import java.io.IOException;
import java.nio.file.Path;

public class NotFileException extends IOException {
    public NotFileException(Path path) {
        super("因为 " + path + " 存在但不是文件!");
    }

    public NotFileException(Path path, Throwable throwable) {
        super("因为 " + path + " 存在但不是文件!", throwable);
    }
}
