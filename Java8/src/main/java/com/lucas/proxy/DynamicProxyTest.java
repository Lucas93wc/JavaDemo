package com.lucas.proxy;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {
        test01();
    }

    public static void test01() {
        UserServiceImpl userService = new UserServiceImpl();
        ClassLoader classLoader = userService.getClass().getClassLoader();
        Class<?>[] interfaces = userService.getClass().getInterfaces();
        LogHandler logHandler = new LogHandler(userService);

        UserService proxy = (UserService) Proxy.newProxyInstance(classLoader, interfaces, logHandler);
        proxy.select();
        proxy.update();
    }
}
