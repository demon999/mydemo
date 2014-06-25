package com.snow.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BaseBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		System.out.println("===========进入beforeAdvice()============ \n");

        System.out.print("准备在" + target + "对象上用");
        System.out.print(method + "方法进行对 '");
        System.out.print(args[0] + "'进行删除！\n\n");

        System.out.println("要进入切入点方法了 \n");

	}

}
