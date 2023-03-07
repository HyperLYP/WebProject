package com.tsu.mslyp.controller;

import com.tsu.mslyp.common.ResultEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
    @RequestMapping("t1")
    public String t1() {
        return "测试接口";
    }
    @RequestMapping("t2")
    public ResultEntity t2() {
        return ResultEntity.success("测试成功");
    }
}
