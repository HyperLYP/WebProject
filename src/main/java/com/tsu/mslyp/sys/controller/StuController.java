package com.tsu.mslyp.sys.controller;

import com.tsu.mslyp.common.ResultEntity;
import com.tsu.mslyp.sys.entity.Stu;
import com.tsu.mslyp.sys.service.IStuService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author monica
 * @since 2023-04-26
 */
@Controller
@RestController
@RequestMapping("/sys/stu")
public class StuController {
    @Resource
    private IStuService stuService;
    @RequestMapping("list")
    public ResultEntity<List<Stu>> findStuList() {
        List<Stu> list = stuService.list();
        return ResultEntity.success(list);
    }
}
