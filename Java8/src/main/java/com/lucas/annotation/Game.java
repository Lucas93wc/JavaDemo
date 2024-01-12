package com.lucas.annotation;

import java.lang.annotation.*;

/**
 * @author Lucas
 * @Description TODO
 * @date 2021-06-10 19:15
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(People.class)
public @interface Game {
    String value() default "";
}
