package com.lucas.annotation;

import java.lang.annotation.*;

/**
 * @author Lucas
 * @Description TODO
 * @date 2021-06-10 19:14
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface People {
    Game[] value();
}
