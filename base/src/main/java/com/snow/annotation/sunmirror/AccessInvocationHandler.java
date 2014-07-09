package com.snow.annotation.sunmirror;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 14-7-3.
 */
public class AccessInvocationHandler<T> implements InvocationHandler {

    final T accessObj;
    public AccessInvocationHandler(T accessObj) {
        this.accessObj = accessObj;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RequiredRoles annotation = method.getAnnotation(RequiredRoles.class); //通过反射API获取注解
        if (annotation != null) {
            String[] roles = annotation.value();
//            String role = AccessControl.getCurrentRole();
//            if (!Arrays.asList(roles).contains(role)) {
//                throw new AccessControlException("The user is not allowed to invoke this method.");
//            }
        }
        return method.invoke(accessObj, args);
    }

}
