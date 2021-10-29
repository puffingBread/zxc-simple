package org.humor.zxc.simple.app.controller;

import org.humor.zxc.simple.app.service.CustomWiredService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Date: 2020/11/4
 * Time: 2:20 下午
 *
 * @author xuzz
 */
@RestController
public class CustomWiredController {

    @Resource
    private CustomWiredService customWiredService;

    @GetMapping("/custom")
    public String wired() {
        return customWiredService.hello();
    }
}
