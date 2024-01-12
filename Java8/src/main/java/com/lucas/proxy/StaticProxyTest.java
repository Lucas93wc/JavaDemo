package com.lucas.proxy;

public class StaticProxyTest {
    public static void main(String[] args) {
        test01();
    }

    public static void test01() {
        UserServiceImpl userService = new UserServiceImpl();
        UserServiceProxy userServiceProxy = new UserServiceProxy(userService);
        userServiceProxy.select();
        userServiceProxy.update();

    }
}
