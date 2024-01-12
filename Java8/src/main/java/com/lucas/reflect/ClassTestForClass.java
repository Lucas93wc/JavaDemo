package com.lucas.reflect;

import java.lang.reflect.*;
import java.util.Date;

public class ClassTestForClass {
    public static void main(String[] args) {
        try {
            //获取class类型的几种方式
            getClassTypes();

            System.out.println("\n========================\n");

            //通过反射创建类实例
            getNewInstanceByReflect();

            System.out.println("\n========================\n");

            //打印类信息
            printClassInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printClassInfo() throws ClassNotFoundException {
        Class<?> c1 = Class.forName("com.lucas.reflect.Employee");
        Class<?> superclass = c1.getSuperclass();

        // 获取权限修饰符
        String modifier = Modifier.toString(c1.getModifiers());
        if (modifier.length() > 0 ) System.out.print(modifier + " ");

        // 获取全限定类路径
        System.out.print("class " + c1.getName());
        //获取基类全限定路径
        if (superclass != null && superclass != Object.class) System.out.print(" extends " + superclass.getName());
        System.out.println(" {");

        // 打印属性
        printFields(c1);
        //打印构造方法
        printConstructors(c1);
        // 打印方法
        printMethods(c1);

        System.out.println("}");
    }

    public static void printFields(Class cl) {
        Field[] declaredFields = cl.getDeclaredFields();
        for (Field field : declaredFields) {
            //获取属性字段类型
            Class<?> type = field.getType();
            System.out.print("    ");
            //获取属性字段权限修饰符：public static、public、private...
            String s = Modifier.toString(field.getModifiers());
            if (s.length() > 0) s += " ";
            s += type.getName() + " ";
            s += field.getName() + ";\n";
            System.out.println(s);
        }
    }

    public static void printConstructors(Class cl) {
        Constructor[] declaredConstructors = cl.getDeclaredConstructors();
        for (Constructor c : declaredConstructors) {
            String name = c.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");

            System.out.print(name + "(");
            Class[] parameterTypes = c.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if (i > 0) System.out.print(", ");

                System.out.print(parameterTypes[i].getName());
            }

            System.out.println(");\n" );
        }
    }

    public static void printMethods(Class cl) {
        Method[] declaredMethods = cl.getDeclaredMethods();
        for (Method method : declaredMethods) {
            Class<?> returnType = method.getReturnType();
            System.out.print("    ");
            String modifier = Modifier.toString(method.getModifiers());
            if (modifier.length() > 0) System.out.print(modifier + " ");
            System.out.print(returnType.getName() + " "+ method.getName() + "(");
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(parameterTypes[i].getName());
            }

            System.out.println(");\n");
        }

    }


    // 通过反射创建实例
    public static void getNewInstanceByReflect() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Date> c = Date.class;
        // 第一种：使用Class对象的newInstance()方法来创建Class对象对应类的实例
        Date date1 = (Date) c.newInstance();
        System.out.println(date1);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 第二种：先通过Class对象获取指定的Constructor对象，
        // 再调用Constructor对象的newInstance()方法来创建实例
        Constructor<Date> constructor = c.getConstructor(long.class);
        Date date2 = (Date) constructor.newInstance(System.currentTimeMillis());
        System.out.println(date2);
    }

    // 获取Class对象的三种方法
    public static void getClassTypes() throws ClassNotFoundException {
        Class<?> c1 = Class.forName("com.lucas.reflect.Employee");
        Class<Employee> c2 = Employee.class;
        Employee employee = new Employee("小明", "18", "写代码", 1, "Java攻城狮", 100000, "5");
        Class<? extends Employee> c3 = employee.getClass();

        if (c1 == c2 && c2 == c3) {
            System.out.println("相同的类型");
            System.out.println(c1);
        }
    }

}
