package com.lucas.object;

public class ObjectTest {
    private String name = "aaa";

    public ObjectTest(String name) {
        System.out.println(this.name);
        this.name = name;
    }

    public static void main(String[] args) {
        ObjectTest test = new ObjectTest("bbb");
        System.out.println(test.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
