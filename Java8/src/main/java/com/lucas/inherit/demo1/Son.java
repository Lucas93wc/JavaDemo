package com.lucas.inherit.demo1;

/**
 * @author Lucas
 * @Description TODO
 * @date 2023-11-06 13:32
 */
public class Son extends Father {

    @Override
    protected void service(String req, String resp) {
        System.out.println("Son service before: "+ req);
        super.service(req, resp);
        System.out.println("Son service after: "+ resp);
    }

    @Override
    protected void doGet(String req, String resp) {
        System.out.println("Son doGet: "+ req +" - "+ resp);
    }
}
