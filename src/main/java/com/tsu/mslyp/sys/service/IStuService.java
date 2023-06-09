package com.tsu.mslyp.sys.service;

import com.tsu.mslyp.common.ResultEntity;
import com.tsu.mslyp.sys.entity.EcharsInfo;
import com.tsu.mslyp.sys.entity.Stu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author monica
 * @since 2023-04-26
 */
public interface IStuService extends IService<Stu> {
    ResultEntity<List<Stu>> selectByPage(int pageNum, int pageSize);

    List<Stu> findAll();
    List<EcharsInfo> getEcharsInfo();
}
