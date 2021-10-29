package org.humor.zxc.simple.reflect;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * Date: 2020/9/30
 * Time: 10:40 上午
 *
 * @author xuzz
 */

public class ReflectHandler {


    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("org.humor.zxc.simple.proxy.SendMsgService");
        Field[] declaredFields = aClass.getDeclaredFields();
        Arrays.stream(declaredFields).map(field -> {
            field.setAccessible(Boolean.TRUE);
            return new HashMap();
        }).collect(Collectors.toList());
    }

}
