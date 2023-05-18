package com.tsu.mslyp.sys.controller;

import com.tsu.mslyp.common.ResultEntity;
import com.tsu.mslyp.sys.entity.Major;
import com.tsu.mslyp.sys.service.impl.MajorServiceImpl;
import jakarta.annotation.Resource;
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
@RestController
@RequestMapping("/sys/major")
public class MajorController {
    @Resource
    private MajorServiceImpl majorService;
    @RequestMapping("list")
    public ResultEntity<List<Major>> findList() {
        List<Major> list = majorService.list();
        return ResultEntity.success(list);
    }
}
