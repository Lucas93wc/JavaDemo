package com.lucas.trycatchfinally;

/**
 * @author Lucas
 * @Description TODO
 * @date 2022-01-26 16:51
 */
public class test {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("1");
        System.out.println("函数结果" + test01(sb));
        System.out.println("sb:" + sb);

        System.out.println(test02());
    }

    public static StringBuilder test01(StringBuilder sb) {
        try {
            sb.append("2");
            int j = 10 / 0 ;
            return sb;
        } catch (Exception e) {
            sb.append("3");
            return sb;
        } finally {
            sb.append("4");
//            return sb;
        }
    }

    public static int test02() {
        int i = 0;
        try {
            i = 1;
            int j = 10 / 0 ;
            return i;
        } catch (Exception e) {
            i = 2;
            return i;
        } finally {
            i = 3;
//            return i;
        }
    }
}
