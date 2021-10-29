package org.humor.zxc.simple.spring.extendpoint;

import org.humor.zxc.simple.annotation.CustomLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Date: 2021/9/18
 * Time: 3:10 下午
 *
 * @author xuzz
 */
@CustomLog
public class CustomBean {

    private static final Logger logger = LoggerFactory.getLogger(CustomBean.class);

    public void start() {
        logger.info("======CustomBean.start======");
    }

    public void destroy() {
        logger.info("======CustomBean.destroy======");
    }
}
