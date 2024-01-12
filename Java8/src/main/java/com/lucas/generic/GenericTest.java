package com.lucas.generic;

import java.util.Hashtable;

/**
 * @author Lucas
 * @Description TODO
 * @date 2021-06-04 16:36
 */
public class GenericTest {
    public static void main(String[] args) {
        test03();
    }

    public static void test03() {
        Hashtable<Fruit, Fruit> hashtable = new Hashtable<>();
        hashtable.put(new Fruit("1"), new Fruit("a"));
        hashtable.put(new Fruit("2"), new Fruit("b"));
        hashtable.put(new Fruit("3"), new Fruit("c"));

        hashtable.replaceAll( (k, v) -> new Apple("1"));
        hashtable.forEach((k, v) -> System.out.println(k + " : " + v));

//        hashtable.replaceAll(new BiFunction<Fruit, Fruit, Fruit>() {
//            @Override
//            public Fruit apply(Fruit o, Fruit o2) {
//                Fruit fruit = new Fruit();
//                fruit.id = o.id + o2.id;
//                return fruit;
//            }
//        });
//        hashtable.forEach((k, v) -> System.out.println(k + " : " + v));

//        hashtable.replaceAll(new BiFunction<Food, Food, Apple>() {
//            @Override
//            public Apple apply(Food o, Food o2) {
//                Apple apple = new Apple();
//                apple.idApple = o.idFood + o2.idFood;
//                return apple;
//            }
//        });
//        hashtable.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    // 此方法测试 <? extends T>
    // 不能往里存，只能往外取
    public static void test01() {
        Plate<? extends Fruit> fruitPlate2 = new Plate<RedApple>(new RedApple());
        Plate<? extends Fruit> fruitPlate = new Plate<Apple>(new Apple());
        Plate<? extends Fruit> fruitPlate1 = new Plate<Fruit>(new Fruit());
        // 编译报错，<? extends Fruit>此泛型写法只能创建Fruit及其子类
//        Plate<? extends Fruit> fruitPlate3 = new Plate<Food>(new Food());

        //不能存入任何元素
//        fruitPlate.setItem(new Apple());    //Error  编译错误
//        fruitPlate.setItem(new Fruit());    //Error  编译错误
        //错误内容：
        // 不兼容的类型: javase.generictest.Apple无法转换为capture#1, 共 ? extends javase.generictest.Fruit
        // fruitPlate 存放了Fruit及其子类，但是具体什么类型未知.
        // <? extends T> fruitPlate中放入的Apple被转换成 capture#1

        //其实编译器根据 ? extends Fruit 只知道：list中可以是Fruit或它的任何某种子类型对象，
        // 但具体是什么类型是不确定的，所以你add(new Fruit()); add(new Strawberry()); add(new Apple());
        // 编译器都是会报错的；
        //如果难理解，反过来理解：
        //比如fruits.add(new Strawberry())，这里是add一个Strawberry类型对象，
        // 而fruits要求add的对象类型必须是Fruit或它的任何某种子类型对象，
        // 这个某种类型能用Strawberry或Fruit或Apple来表示吗？


        // 读取出来的东西只能放在Fruit或它的父类里
//        Apple newFruit3 = fruitPlate.getItem();  //Error
        Fruit newFruit1=fruitPlate.getItem();
        Object newFruit2 = fruitPlate.getItem();
    }

    // 此方法测试 <? super T>
    // 不影响往里存，但往外取只能放在Object对象里
    public static void test02() {
        //编译报错：<? super Fruit>此泛型写法只能创建Fruit及其父类
//        Plate<? super Fruit> fruitPlate1 = new Plate<Apple>(new Apple());
        Plate<? super Fruit> fruitPlate = new Plate<Fruit>(new Fruit());
        Plate<? super Fruit> fruitPlate2 = new Plate<Food>(new Food());

        //存入元素正常
        fruitPlate.setItem(new Apple());
        fruitPlate.setItem(new Fruit());
//        fruitPlate.setItem(new Food());

        //List<? super Fruit>
        //假设：Fruit有子类A、B、C 那么 list.add(A);list.add(B);list.add(C);
        //这却是可以的，为什么呢：
        //因为他是这么存的：list.add((Fruit)A);list.add((Fruit)B); 自动强转了。
        //因为 小转大是隐性的，大转小才是强转需要加类型。
        //那这里为什么又不能存Fruit的父类呢？
        //因为   见假设1，它是？号，类型代表待定，不跑起来他也不知道你到底存的什么。
        //所以我们能手动add()进去的数据都必须是绝对安全的(最低级父类:本身)才能通过。
        //所以直接add父类也是不行的。


        //读取出来的东西只能存放在Object类里
        Object newFruit1 = fruitPlate.getItem();
        // 读取出来的东西只能放在Obejct类里
        // 存入 fruitPlate 中的类为 Fruit 及其父类，不确定类型
//        Fruit newFruit2 = fruitPlate.getItem();  //Error
//        Apple newFruit3 = fruitPlate.getItem();  //Error
    }
}
