package com.snow.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class BaseAfterReturnAdvice implements AfterReturningAdvice {

	public void afterReturning(Object returnValue, Method method, Object[] args,
			Object target) throws Throwable {
		System.out.println("==========进入afterReturning()=========== \n");
        System.out.println("切入点方法执行完了 \n");

        System.out.print(args[0] + "在");
        System.out.print(target + "对象上被");
        System.out.print(method + "方法删除了");
        System.out.print("只留下：" + returnValue + "\n\n");

	}

}
