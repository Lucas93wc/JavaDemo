package com.lucas.string;

import org.junit.Test;

/**
 * @author Lucas
 * @Description TODO
 * @date 2022-06-09 11:30
 */
public class StringTest {
    @Test
    public void test01() {
        " jva".stripTrailing();
        " jva".stripLeading();
        "jva".repeat(3);
        "a\nb\nc".lines().count();
    }
}
