package org.humor.zxc.simple.proxy.cglib.interceptor;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * TODO ADD DESCRIPTION
 * Date: 2020/9/7
 * Time: 4:53 下午
 *
 * @author xuzz
 */
public class SendMsgInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("before method, method name = " + method.getName() + ", time = " + System.currentTimeMillis());

        Object invoke = proxy.invokeSuper(obj, args);
        System.out.println("after method, method name = " + method.getName() + ", time = " + System.currentTimeMillis());

        return invoke;
    }
}
