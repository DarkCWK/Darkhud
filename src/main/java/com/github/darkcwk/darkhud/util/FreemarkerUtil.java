package com.github.darkcwk.darkhud.util;

import java.io.IOException;
import java.io.StringWriter;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class FreemarkerUtil {
    private static final Configuration configuration;
    static {
        configuration = new Configuration(Configuration.VERSION_2_3_32);

        try {
            configuration.setDefaultEncoding("UTF-8");
            configuration.setDirectoryForTemplateLoading(Constant.TEMPLATE_PATH.toFile());
            configuration.setTemplateUpdateDelayMilliseconds(0);
        } catch (IOException e) {
            ErrorUtil.sendErrorWithStop("配置 Freemarker 时出错!", e);
        }
    }

    public static String process(String templateName, Object model)
            throws TemplateNotFoundException,
            MalformedTemplateNameException,
            ParseException,
            TemplateException,
            IOException {
        // 无需关闭
        StringWriter out = new StringWriter();

        configuration.getTemplate(templateName).process(model, out);

        return out.toString();
    }
}
