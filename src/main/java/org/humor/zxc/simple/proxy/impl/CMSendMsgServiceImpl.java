package org.humor.zxc.simple.proxy.impl;

import org.humor.zxc.simple.proxy.SendMsgService;

/**
 * TODO ADD DESCRIPTION
 * Date: 2020/8/17
 * Time: 11:35 上午
 *
 * @author xuzz
 */
public class CMSendMsgServiceImpl implements SendMsgService {

    @Override
    public void send(String msg) {
        System.out.println("CM send msg, msg=" + msg);
    }
}
