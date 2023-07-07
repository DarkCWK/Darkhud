package com.github.darkcwk.darkhud.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Properties;

public class ConfigUtil {
    private static final Properties config;

    static {
        // 检查配置文件位置
        try {
            ErrorUtil.existsFileOrDefault(Constant.CONFIG_FILE_PATH, Constant.DEFAULT_CONFIG_FILE_CLASSPATH);
        } catch (IOException e) {
            ErrorUtil.sendErrorWithStop("未找到配置文件!", e);
        }

        // 检查模板文件位置
        try {
            ErrorUtil.existsFileOrDefault(Constant.LT_FILE_PATH, Constant.DEFAULT_LT_FILE_CLASSPATH);
            ErrorUtil.existsFileOrDefault(Constant.RT_FILE_PATH, Constant.DEFAULT_RT_FILE_CLASSPATH);
            ErrorUtil.existsFileOrDefault(Constant.LB_FILE_PATH, Constant.DEFAULT_LB_FILE_CLASSPATH);
            ErrorUtil.existsFileOrDefault(Constant.RB_FILE_PATH, Constant.DEFAULT_RB_FILE_CLASSPATH);
        } catch (IOException e) {
            ErrorUtil.sendErrorWithStop("未找到模板文件!", e);
        }

        // 加载配置
        config = new Properties();
        try {
            config.load(Files.newBufferedReader(Constant.CONFIG_FILE_PATH, StandardCharsets.UTF_8));
        } catch (IOException e) {
            ErrorUtil.sendErrorWithStop("无法加载配置文件!", e);
        }
    }

    public static void setAndSave(String key, String value) throws IOException {
        String originValue = config.getProperty(key);
        
        config.setProperty(key, value);
        try {
            config.store(Files.newBufferedWriter(Constant.CONFIG_FILE_PATH), "Darkhud 配置文件");
        } catch (IOException e) {
            config.setProperty(key, originValue);
            throw e;
        }
    }

    public static boolean getAsBoolean(String key) {
        return Boolean.parseBoolean(config.getProperty(key));
    }
}
