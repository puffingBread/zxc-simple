package org.humor.zxc.simple;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Date: 2020/10/4
 * Time: 9:24 下午
 *
 * @author xuzz
 */
@SpringBootApplication
public class ZxcSimpleApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZxcSimpleApplication.class).run(args);
    }
}
