package org.humor.zxc.simple.proxy.jdk.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * TODO ADD DESCRIPTION
 * Date: 2020/8/17
 * Time: 11:40 上午
 *
 * @author xuzz
 */
public class MsgInvocationHandler implements InvocationHandler {

    private Object target;

    public MsgInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before send msg, time=" + System.currentTimeMillis());
        Object result = method.invoke(target, args);
        System.out.println("after send msg, time=" + System.currentTimeMillis());
        return result;
    }
}
