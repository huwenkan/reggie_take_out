package com.huwenkang.reggie.common;

public class BaseContext {
    private static final ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    private BaseContext() {
    }


    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    public static Long getCurrentId() {
        return threadLocal.get();
    }
}
