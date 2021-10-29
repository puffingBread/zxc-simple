package org.humor.zxc.simple.spring.extendpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Date: 2021/9/17
 * Time: 5:35 下午
 *
 * @author xuzz
 */
@Component
public class CustomInitializer implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean,
        BeanFactoryPostProcessor, InstantiationAwareBeanPostProcessor, BeanPostProcessor, DisposableBean {

    private static final Logger logger = LoggerFactory.getLogger(CustomInitializer.class);


    @Override
    public void setBeanName(String name) {
        logger.info("======1.BeanNameAware setBeanName======");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        logger.info("======2.BeanFactoryAware setBeanFactory======");
        int[] a = new int[]{1, 2};
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("======3.ApplicationContextAware setApplicationContext======");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("======4.InitializingBean afterPropertiesSet======");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        logger.info("======5.BeanFactoryPostProcessor postProcessBeanFactory======");
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        logger.info("======6.1.InstantiationAwareBeanPostProcessor postProcessBeforeInstantiation======");
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        logger.info("======6.2.InstantiationAwareBeanPostProcessor postProcessAfterInstantiation======");
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        logger.info("======6.3.InstantiationAwareBeanPostProcessor postProcessProperties======");
        return null;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        logger.info("======6.4.InstantiationAwareBeanPostProcessor postProcessPropertyValues======");
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("======7.1.BeanPostProcessor postProcessBeforeInitialization======");
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("======7.2.BeanPostProcessor postProcessAfterInitialization======");
        return null;
    }

    @Override
    public void destroy() throws Exception {
        logger.info("======8.DisposableBean destroy======");
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = new ListNode();

            while (l1.next != null && l2.next != null) {
                result.val = l1.val + l2.val;
                result.next = new ListNode();
                return addTwoNumbers(l1.next, l2.next);
            }
            return result;
        }
    }


}
