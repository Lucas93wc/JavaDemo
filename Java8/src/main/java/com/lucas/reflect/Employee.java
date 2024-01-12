package com.lucas.reflect;

public class Employee extends Person {
    public static Integer totalNum = 0; // 员工数
    public int empNo;   // 员工编号 公有
    protected String position;  // 职位 保护
    String years;   //入职年份 默认
    private int salary; // 工资   私有

    public Employee() {
    }

    public Employee(String name, String age, String hobby, int empNo, String position, int salary, String years) {
        super(name, age, hobby, "man");
        this.empNo = empNo;
        this.position = position;
        this.salary = salary;
        this.years = years;
        Employee.totalNum++;
    }

    public void sayHello() {
        System.out.println(String.format("Hello, 我是 %s, 今年 %s 岁, 爱好是%s, 我目前的工作是%s, 月入%s元\n", name, age, getHobby(), position, salary));
    }
    private void work() {
        System.out.println(String.format("My name is %s, 工作中勿扰.", name));
    }

    public static Integer getTotalNum() {
        return totalNum;
    }

    public static void setTotalNum(Integer totalNum) {
        Employee.totalNum = totalNum;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNo=" + empNo +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
