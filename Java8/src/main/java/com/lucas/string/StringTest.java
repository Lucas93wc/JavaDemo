package com.lucas.string;

/**
 * @author Lucas
 * @Description TODO
 * @date 2021-12-02 14:29
 */
public class StringTest {
    public static void main(String[] args) {
        test04();
//        test03();
//        test02();
    }

    public static void test04() {
        String s1 = "2024-06-13 14:09:17.500";
        System.out.println("原值: "+s1);
        String newStr = s1.replace("-", "").replace(":", "").replace(".", "").replace(".", "").replace(" ", "");
        System.out.println(newStr);

        System.out.println("原值: "+s1);
        String replacedString = s1.replaceAll("[-.: ]", "");
        System.out.println(replacedString);
    }

    public static void test03() {
        String s1 = new String("a") + new String("b");
//        System.out.println(s1 == "ab");


        String s2 = s1.intern();

        System.out.println(s1 == "ab");
        System.out.println(s2 == "ab");
    }

    public static void test02() {
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);

        String s3 = new String("xyz");
        String s4 = new String("xyz");
        System.out.println(s4 == s3);

        String s5 = new StringBuilder().append("aa").append("bb").toString();
        System.out.println(s5.intern() == s5);

        String s6 = new String("a") + new String("b");
        String s7 = "a" + new String("b");
        System.out.println(s6 == s7);

        System.out.println("done");
    }

    public static void test01() {
        String s7 = "a" + "b";
        String s1 = "a";
        String s2 = "b";
        String s3 = new String("a");
        String s4 = s1 + s2;
        String s5 = "ab";
        String s6 = s3.intern();

        System.out.println(s4 == s5);
        System.out.println(s1 == s3);
        System.out.println(s1 == s6);
        System.out.println(s5 == s7);
        System.out.println("done");
    }
}
