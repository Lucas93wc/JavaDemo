package com.lucas.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassTestForMethod {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        try {
            Employee employee = new Employee("小明", "18", "写代码", 1, "Java攻城狮", 100000, "5");
            Method sayHello = employee.getClass().getMethod("sayHello");
            // 打印 sayHello 的方法信息
            System.out.println(sayHello);

            // 让 employee 执行 sayHello 方法
            sayHello.invoke(employee);

            double x = 3.0;
            // 获取 MethodTableTest 的square方法
            Method square = ClassTestForMethod.class.getMethod("square", double.class);
            // 调用类方法 square 求平方，方法参数 x；静态方法类实例可以为null
            double y1 = (double) square.invoke(null, x);
            System.out.printf("square    %-10.4f -> %10.4f%n", x, y1);

            // 获取 Math 的 sqrt 方法
            Method sqrt = Math.class.getMethod("sqrt", double.class);
            // 调用类方法 sqrt 求根，方法参数 x
            double y2 = (double) sqrt.invoke(null, x);
            System.out.printf("sqrt      %-10.4f -> %10.4f%n", x, y2);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    // static静态方法 计算乘方
    public static double square(double x) {
        return x * x;
    }
}
