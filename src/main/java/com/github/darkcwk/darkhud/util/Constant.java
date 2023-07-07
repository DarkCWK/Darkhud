package com.github.darkcwk.darkhud.util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Constant {
    public static final Path CONFIG_PATH = Paths.get("./config/darkhud");
    
    public static final Path CONFIG_FILE_PATH = CONFIG_PATH.resolve("darkhud.properties");
    public static final String DEFAULT_CONFIG_FILE_CLASSPATH = "default/darkhud.properties";

    public static final String LT_ENABLE_KEY = "lt.enabled";
    public static final String RT_ENABLE_KEY = "rt.enabled";
    public static final String LB_ENABLE_KEY = "lb.enabled";
    public static final String RB_ENABLE_KEY = "rb.enabled";

    public static final Path TEMPLATE_PATH = CONFIG_PATH.resolve("template");

    public static final String LT_FILE_NAME = "lt.ftl";
    public static final Path LT_FILE_PATH = TEMPLATE_PATH.resolve("lt.ftl");
    public static final String DEFAULT_LT_FILE_CLASSPATH = "default/template/lt.ftl";

    public static final String RT_FILE_NAME = "rt.ftl";
    public static final Path RT_FILE_PATH = TEMPLATE_PATH.resolve("rt.ftl");
    public static final String DEFAULT_RT_FILE_CLASSPATH = "default/template/rt.ftl";

    public static final String LB_FILE_NAME = "lb.ftl";
    public static final Path LB_FILE_PATH = TEMPLATE_PATH.resolve("lb.ftl");
    public static final String DEFAULT_LB_FILE_CLASSPATH = "default/template/lb.ftl";

    public static final String RB_FILE_NAME = "rb.ftl";
    public static final Path RB_FILE_PATH = TEMPLATE_PATH.resolve("rb.ftl");
    public static final String DEFAULT_RB_FILE_CLASSPATH = "default/template/rb.ftl";
}
