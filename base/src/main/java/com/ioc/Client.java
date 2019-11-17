package com.ioc;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-30 18:22
 */
public class Client {
    public static void main(String[] args) {
        AppContext appContext = new AppContext();
        Bizable bean = (Bizable) appContext.getBean("com.ioc.Biz");
        bean.print();
    }
}
