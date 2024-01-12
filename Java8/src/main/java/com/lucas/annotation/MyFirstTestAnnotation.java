package com.lucas.annotation;

import java.lang.annotation.*;

/**
 * 测试注解的类
 *
 * @author Lucas
 * @Description TODO
 * @date 2021-06-10 15:36
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyFirstTestAnnotation {
    String name() default "cat";

    int age() default 18;
}
