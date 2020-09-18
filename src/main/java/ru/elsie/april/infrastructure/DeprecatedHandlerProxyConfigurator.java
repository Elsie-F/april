package ru.elsie.april.infrastructure;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DeprecatedHandlerProxyConfigurator implements ProxyConfigurator {
    @Override
    public Object replaceWithProxyIfNeeded(Object t, Class implClass) {
        if (implClass.isAnnotationPresent(Deprecated.class)) {
            // можно ещё проверять, есть ли в интерфейсах методы
            if (implClass.getInterfaces().length == 0) {
                return Enhancer.create(implClass, (net.sf.cglib.proxy.InvocationHandler) (proxy, method, args) -> getInvokationHandlerLogic(t, method, args));
            }
            return Proxy.newProxyInstance(implClass.getClassLoader(), implClass.getInterfaces(), (proxy, method, args) -> getInvokationHandlerLogic(t, method, args));
        } else {
            return t;
        }
    }

    private Object getInvokationHandlerLogic(Object t, Method method, Object[] args) throws IllegalAccessException, InvocationTargetException {
        System.out.println("** you are using method of a deprecated class **");
        return method.invoke(t, args);
    }
}
