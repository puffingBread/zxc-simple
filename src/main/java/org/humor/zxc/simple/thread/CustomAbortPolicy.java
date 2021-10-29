package org.humor.zxc.simple.thread;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Date: 2021/10/13
 * Time: 11:32 上午
 *
 * @author xuzz
 */
public class CustomAbortPolicy implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

    }
}
