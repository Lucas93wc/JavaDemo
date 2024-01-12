package com.lucas.enumtest;

public class EnumTest {
    public static void main(String[] args) {
        Size size = Enum.valueOf(Size.class, "SMALL");
        System.out.println("size："+ size.toString());
        System.out.println(size.getAbbr());
        System.out.println(size.ordinal());
        System.out.println("name："+ size.name());


        Size[] values = Size.values();
        for (Size value : values) {
            System.out.println(value.toString());
        }
    }
}
