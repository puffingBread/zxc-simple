package org.humor.zxc.simple.annotation;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.*;

/**
 * Date: 2020/11/3
 * Time: 8:24 下午
 *
 * @author xuzz
 */
//用于描述注解的使用范围
@Target({ElementType.FIELD, ElementType.METHOD})
//表示需要在什么级别保存该注释信息，用于描述注解的生命周期
@Retention(RetentionPolicy.RUNTIME)
//允许子类继承父类中的注解
@Inherited
//将注解包含在javadoc中
@Documented
public @interface CustomWired {

}
