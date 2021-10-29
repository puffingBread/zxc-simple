package org.humor.zxc.simple.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import org.humor.zxc.simple.proxy.cglib.interceptor.SendMsgInterceptor;

/**
 * Date: 2020/9/7
 * Time: 5:02 下午
 *
 * @author xuzz
 */
public class CGLibProxyFactory {

    public static Object getProxy(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new SendMsgInterceptor());
        return enhancer.create();
    }

    public static void main(String[] args) {
        AliSmsService aliSmsService = (AliSmsService) CGLibProxyFactory.getProxy(AliSmsService.class);
        aliSmsService.send("cglib test, time = " + System.currentTimeMillis());
    }

}
