package org.humor.zxc.simple.spring.extendpoint;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Date: 2021/9/18
 * Time: 3:20 下午
 *
 * @author xuzz
 */
@Configuration
public class CustomConfig {

    @Bean(initMethod = "start", destroyMethod = "destroy")
    public CustomBean customBean() {
        return new CustomBean();
    }

    @Bean(name = "customFactoryBean")
    public CustomFactoryBean customFactoryBean() {
        return new CustomFactoryBean();
    }

    @Bean(name = "userBean")
    public UserBean userBean() {
        return new UserBean();
    }
}
