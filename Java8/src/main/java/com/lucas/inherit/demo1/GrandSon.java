package com.lucas.inherit.demo1;

/**
 * @author Lucas
 * @Description TODO
 * @date 2023-11-06 13:54
 */
public class GrandSon extends Son {
    public static void main(String[] args) {
        GrandSon grandSon = new GrandSon();
        grandSon.service("com/lucas", "hello");
    }

    protected void doService(String req, String resp) {
        System.out.println("GrandSon doService: "+ req +" - "+ resp);
    }

}
