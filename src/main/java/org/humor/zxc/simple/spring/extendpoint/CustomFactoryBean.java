package org.humor.zxc.simple.spring.extendpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

/**
 * Date: 2021/9/18
 * Time: 3:15 下午
 *
 * @author xuzz
 */
public class CustomFactoryBean implements FactoryBean<CustomBean> {

    private static final Logger logger = LoggerFactory.getLogger(CustomFactoryBean.class);

    @Override
    public CustomBean getObject() throws Exception {
        logger.info("======CustomFactoryBean.getObject======");
        return new CustomBean();
    }

    @Override
    public Class<?> getObjectType() {
        logger.info("======CustomFactoryBean.getObjectType======");
        return CustomBean.class;
    }
}
