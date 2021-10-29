package org.humor.zxc.simple.spring.extendpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Date: 2021/9/18
 * Time: 3:23 下午
 *
 * @author xuzz
 */
public class UserBean {

    private static final Logger logger = LoggerFactory.getLogger(UserBean.class);

    @PostConstruct
    public void postConstruct() {
        logger.info("======UserBean.postConstruct======");
    }

    @PreDestroy
    public void preDestroy() {
        logger.info("======UserBean.preDestroy======");
    }
}
