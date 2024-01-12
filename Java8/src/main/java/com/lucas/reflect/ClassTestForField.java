package com.lucas.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ClassTestForField {
    private ArrayList<Object> visited = new ArrayList<>();

    public static void main(String[] args) {
        int size = 4;
        ArrayList<Integer> squares = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            squares.add(i * i);
        }
        // 创建一个上面定义的分析类ClassTestForField的对象
        ClassTestForField objectAnalyzer = new ClassTestForField();
        // 分析ArrayList<Integer>对象的实际值
        System.out.println(objectAnalyzer.toString(squares));

        System.out.println("****************************************");
        Employee employee = new Employee("小明", "18", "爱好写代码", 1, "Java攻城狮", 100, "5"); // 分析自定义类Employee的对象的实际值
        System.out.println(objectAnalyzer.toString(employee));
    }

    public String toString(Object obj) {
        if (obj == null) {
            return "null";
        }
        // 如果该对象已经处理过，则不再处理
        if (visited.contains(obj)) {
            return "...";
        }
        visited.add(obj);

        // 获取Class对象
        Class cl = obj.getClass();
        // 如果是String类型则直接转为String
        if (cl == String.class) {
            return (String) obj;
        }
        // 如果是数组
        if (cl.isArray()) {
            // 数组的元素的类型
            String r = cl.getComponentType() + "[]{\n";
            for (int i = 0; i < Array.getLength(obj); i++) {
                // 不是数组的第一个元素加逗号和换行，显示更加美观
                if (i > 0) {
                    r += ",\n";
                }
                r += "\t";
                Object val = Array.get(obj, i);
                // 判断Class是否为8种基本类型， 若结果为true，直接输出
                if (cl.getComponentType().isPrimitive()) {
                    r += val;
                } else {
                    // 不是8中基本类型时，说明是类，递归调用toString
                    r += toString(val);
                }
            }
            return r + "\n}";
        }
        // 既不是String，也不是数组时，输出该对象的类型和属性值
        String r = cl.getName();
        do {
            r += "[";
            // 获取该类自己定义的所有域，包括私有的，不包括父类的
            Field[] fields = cl.getDeclaredFields();
            // 访问私有的属性，需要打开这个设置，否则会报非法访问异常
            AccessibleObject.setAccessible(fields, true);
            for (Field f : fields) {
                // 通过 Modifier 可获取该域的修饰符，这里判断是否为 static
                if (!Modifier.isStatic(f.getModifiers())) {
                    if (!r.endsWith("[")) {
                        r += ",";
                    }
                    // 域名称
                    r += f.getName() + "=";
                    try {
                        // 域（属性）的类型
                        Class t = f.getType();
                        // 获取obj对象上该域的实际值
                        Object val = f.get(obj);
                        // 如果类型为8种基本类型，则直接输出
                        if (t.isPrimitive()) {
                            r += val;
                        } else {
                            // 不是8种基本类型，递归调用toString
                            r += toString(val);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            r += "]";
            // 继续打印超类的类信息
            cl = cl.getSuperclass();
        } while (cl != null);
        return r;
    }
}
