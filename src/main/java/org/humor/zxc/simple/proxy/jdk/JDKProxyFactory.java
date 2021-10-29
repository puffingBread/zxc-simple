package org.humor.zxc.simple.proxy.jdk;

import org.humor.zxc.simple.proxy.SendMsgService;
import org.humor.zxc.simple.proxy.impl.CMSendMsgServiceImpl;
import org.humor.zxc.simple.proxy.impl.CUSendMsgServiceImpl;
import org.humor.zxc.simple.proxy.jdk.handler.MsgInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * TODO ADD DESCRIPTION
 * Date: 2020/8/17
 * Time: 11:53 上午
 *
 * @author xuzz
 */
public class JDKProxyFactory {

    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new MsgInvocationHandler(target));
    }

    public static void main(String[] args) {
        String msg = "today is monday!";
        SendMsgService proxy = (SendMsgService) JDKProxyFactory.getProxy(new CMSendMsgServiceImpl());
        proxy.send(msg);

        proxy = (SendMsgService) JDKProxyFactory.getProxy(new CUSendMsgServiceImpl());
        proxy.send(msg);
    }
}
