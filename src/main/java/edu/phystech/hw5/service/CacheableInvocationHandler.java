package edu.phystech.hw5.service;

import edu.phystech.hw5.annotation.Cacheable;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author kzlv4natoly
 */

public class CacheableInvocationHandler implements InvocationHandler {
    private final Object target;
    private final ConcurrentMap<Method, ConcurrentMap<Object, Object>> cache = new ConcurrentHashMap<>();

    public CacheableInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Cacheable.class)) {
            ConcurrentMap<Object, Object> methodCache = cache.computeIfAbsent(method, k -> new ConcurrentHashMap<>());
            Object arg = args[0];
            if (methodCache.containsKey(arg)) {
                return methodCache.get(arg);
            } else {
                try {
                    Object result = method.invoke(target, args);
                    methodCache.put(arg, result);
                    return result;
                } catch (InvocationTargetException e) {
                    throw e.getCause();
                }
            }
        } else {
            try {
                return method.invoke(target, args);
            } catch (InvocationTargetException e) {
                throw e.getCause();
            }
        }
    }
}