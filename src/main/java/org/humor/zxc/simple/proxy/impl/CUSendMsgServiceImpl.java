package org.humor.zxc.simple.proxy.impl;

import org.humor.zxc.simple.proxy.SendMsgService;

/**
 * TODO ADD DESCRIPTION
 * Date: 2020/9/7
 * Time: 4:06 下午
 *
 * @author xuzz
 */
public class CUSendMsgServiceImpl implements SendMsgService {

    @Override
    public void send(String msg) {
        System.out.println("CU send msg, msg=" + msg);
    }
}
