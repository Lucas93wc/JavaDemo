package com.lucas.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author Lucas
 * @Description TODO
 * @date 2021-06-10 15:47
 */
public class Test01 {
    public static void main(String[] args) {

//        test01();
        test02();

    }

    public static void test02 () {
        Class<Father> fatherClass = Father.class;

        // 获取类注解属性
        // isAnnotationPresent函数判断某个类上是否配置了某个注解
        boolean annotationPresent = fatherClass.isAnnotationPresent(MyFirstTestAnnotation.class);
        if (annotationPresent) {
            MyFirstTestAnnotation annotation = fatherClass.getAnnotation(MyFirstTestAnnotation.class);
            System.out.println(annotation.name());
            System.out.println(annotation.age());
        }

        // 获取方法注解属性
        try {

            annotationPresent = fatherClass.isAnnotationPresent(MyFirstTestAnnotation.class);
            if (annotationPresent) {
                MyFirstTestAnnotation annotation = fatherClass.getAnnotation(MyFirstTestAnnotation.class);
                // 此代码说明，注解就是接口，注解的属性其实是接口的方法
                for (Method declaredField : MyFirstTestAnnotation.class.getDeclaredMethods()) {
                    System.out.println(declaredField.getName());
//                    declaredField.invoke(annotation, null);
                }
            }

            People declaredAnnotation = PlayGame.class.getDeclaredAnnotation(People.class);
            for (Game game : declaredAnnotation.value()) {
                System.out.println(game.value());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 测试派生类是否可以继承基类注解
    public static void test01 () {
        Class<Son> sonClass = Son.class;
        Annotation[] annotations = sonClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
            //@javase.annotationTest.MyFirstTestAnnotation()
        }
    }
}
