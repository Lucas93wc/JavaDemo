package com.lucas.thread.create;

public class TestForLambda {
    // 3、静态内部类
    static class Like2 implements ILike {
        @Override
        public void show() {
            System.out.println("this is Like2");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like1();
        like.show();

        like = new Like2();
        like.show();

        // 4、局部内部类
        class Like3 implements ILike {
            @Override
            public void show() {
                System.out.println("this is Like3");
            }
        }
        like = new Like3();
        like.show();

        // 5、匿名内部类
        like = new ILike() {
            @Override
            public void show() {
                System.out.println("this is Like4");
            }
        };
        like.show();

        // 6、lambda表达式
        like = () -> {
            System.out.println("this is Like5");
        };
        like.show();

    }
}

// 1、定义一个函数式接口
interface ILike {
    void show();
}

// 2、内部类
class Like1 implements ILike {
    @Override
    public void show() {
        System.out.println("this is Like1");
    }
}





































