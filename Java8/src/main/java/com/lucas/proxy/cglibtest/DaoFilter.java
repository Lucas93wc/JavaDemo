package com.lucas.proxy.cglibtest;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

public class DaoFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        if ("select".equals(method.getName())) {
            return 0;   // Callback 列表第1个拦截器
        }
        return 1;   // Callback 列表第2个拦截器，return 2 则为第3个，以此类推
    }
}
