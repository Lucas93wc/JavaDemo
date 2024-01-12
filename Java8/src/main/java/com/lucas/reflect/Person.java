package com.lucas.reflect;

public class Person {
    public String name; // 姓名 公有
    protected String age;   // 年龄 保护
    String sex; //性别 默认
    private String hobby;   // 爱好   私有

    public Person() {
    }

    public Person(String name, String age, String hobby, String sex) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
