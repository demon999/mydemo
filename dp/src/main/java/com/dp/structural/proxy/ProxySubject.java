package com.dp.structural.proxy;

/**
 * Created by Administrator on 14-6-25.
 */
public class ProxySubject extends Subject {
    //以真实角色作为代理角色的属性
    private RealSubject realSubject;

    /**
     * 该方法封装了真实对象的request方法
     */
    @Override
    public void request() {
        preRequest();
        if( realSubject == null ){
            realSubject = new RealSubject();
        }
        //此处执行真实对象的request方法
        realSubject.request();
        postRequest();
    }

    private void preRequest(){
        //something you want to do before requesting
        System.out.println("preRequest---->");
    }
    private void postRequest(){
        //something you want to do after requesting
        System.out.println("postRequest---->");
    }

}
