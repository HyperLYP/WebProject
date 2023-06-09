package com.tsu.mslyp.sys.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tsu.mslyp.common.ResultEntity;
import com.tsu.mslyp.sys.entity.EcharsInfo;
import com.tsu.mslyp.sys.entity.Stu;
import com.tsu.mslyp.sys.mapper.StuMapper;
import com.tsu.mslyp.sys.service.IStuService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author monica
 * @since 2023-04-26
 */
@Service
public class StuServiceImpl extends ServiceImpl<StuMapper, Stu> implements IStuService {
    @Resource
    private StuMapper stuMapper;
    @Override
    public ResultEntity<List<Stu>> selectByPage(int pageNum, int pageSize) {
        Page<Stu> page = new Page<>(pageNum, pageSize);
        Page<Stu> stuPage = stuMapper.selectPage(page, null);
//        log.info(stuPage.getRecords().toString());
        return ResultEntity.success(stuPage.getRecords(),stuPage.getTotal());
    }

    @Override
    public List<Stu> findAll() {
        return stuMapper.findAll();
    }

    @Override
    public List<EcharsInfo> getEcharsInfo() {
        return stuMapper.getEcharsInfo();
    }
}
