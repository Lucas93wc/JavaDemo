package com.lucas.proxy.cglibtest;

import com.lucas.proxy.UserDao;
import net.sf.cglib.proxy.Enhancer;

public class CGLIBTest {
    public static void main(String[] args) {
        test01();
    }

    public static void test01() {
        LogInterceptor daoProxy = new LogInterceptor();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDao.class);  // 设置超类，cglib是通过继承来实现的

        enhancer.setCallback(daoProxy);

        UserDao dao = (UserDao)enhancer.create();   // 创建代理类
        dao.update();
        dao.select();

    }
}
