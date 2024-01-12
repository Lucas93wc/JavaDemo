package com.lucas.inherit.demo1;

/**
 * @author Lucas
 * @Description TODO
 * @date 2023-11-06 13:26
 */
public abstract class Father {
    protected void service(String req, String resp) {
        System.out.println("Father service before: "+ req);
        doGet(req, resp);
        System.out.println("Father service after: "+ resp);
    }

    protected void doGet(String req, String resp) {
        System.out.println("Father doGet: "+ req +" - "+ resp);
    }

}
