package com.tsu.mslyp.sys.controller;

import com.tsu.mslyp.common.ResultEntity;
import com.tsu.mslyp.sys.entity.User;
import com.tsu.mslyp.sys.service.IUserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author monica
 * @since 2023-03-28
 */
@RestController
@RequestMapping("/sys/user")
@Slf4j
@CrossOrigin
public class UserController {
    @Resource
    private IUserService userService;
    @RequestMapping("list")
    public ResultEntity<List<User>> userList() {
        List<User> list = userService.list();
        log.info(list.toString());
        return ResultEntity.success(list);
    }
}
