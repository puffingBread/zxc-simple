package org.humor.zxc.simple.proxy;

import org.humor.zxc.simple.proxy.impl.CMSendMsgServiceImpl;
import org.humor.zxc.simple.proxy.impl.CUSendMsgServiceImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: 2020/9/7
 * Time: 4:04 下午
 *
 * @author xuzz
 */
public class SendMsgProxy implements SendMsgService {

    private SendMsgService sendMsgService;

    public SendMsgProxy(SendMsgService sendMsgService) {
        this.sendMsgService = sendMsgService;
    }

    @Override
    public void send(String msg) {
        System.out.println("send msg proxy start, time=" + System.currentTimeMillis());
        sendMsgService.send(msg);
        System.out.println("send msg proxy end, time=" + System.currentTimeMillis());
    }

    public static void main(String[] args) {
        CMSendMsgServiceImpl cmSendMsgService = new CMSendMsgServiceImpl();

        SendMsgProxy sendMsgProxy = new SendMsgProxy(cmSendMsgService);
        sendMsgProxy.send("hello, this is first test!");

        sendMsgProxy = new SendMsgProxy(new CUSendMsgServiceImpl());
        sendMsgProxy.send("hello, this is second test!");
    }
}
