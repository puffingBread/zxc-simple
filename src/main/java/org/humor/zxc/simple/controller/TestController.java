package org.humor.zxc.simple.controller;

import org.humor.zxc.simple.data.executor.BaseExecutor;
import org.humor.zxc.simple.data.executor.SimpleExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Date: 2021/1/28
 * Time: 10:50 上午
 *
 * @author xuzz
 */
@RestController
public class TestController {


    @Resource
    private BaseExecutor baseExecutor;

    @GetMapping("/test/query")
    public Object testQuery() {
        baseExecutor.init();
        String sql = "select * from t_art_works where id = 1318";
        return baseExecutor.query(sql, null);
    }

    @PutMapping("/test/update")
    public Object testUpdate(@RequestParam String remark) {


        return null;
    }
}
