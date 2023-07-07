package com.github.darkcwk.darkhud.data.util;

public class CastUtil {
    /**
     * 请确保可以进行转换
     * 
     * @param <T> 要转换的目标类
     * @param obj 要转换的对象
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T cast(Object obj) {
        return (T) obj;
    }
}
