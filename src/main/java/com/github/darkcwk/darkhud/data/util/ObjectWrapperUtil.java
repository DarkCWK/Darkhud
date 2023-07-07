package com.github.darkcwk.darkhud.data.util;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.ObjectWrapper;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

public class ObjectWrapperUtil {
    private static final ObjectWrapper ow = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_32).build();

    public static final TemplateModel wrap(Object obj) throws TemplateModelException {
        return ow.wrap(obj);
    }
}
