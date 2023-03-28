package com.tsu.mslyp.sys.service.impl;

import com.tsu.mslyp.sys.entity.User;
import com.tsu.mslyp.sys.mapper.UserMapper;
import com.tsu.mslyp.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author monica
 * @since 2023-03-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
