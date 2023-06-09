package com.tsu.mslyp.sys.mapper;

import com.tsu.mslyp.sys.entity.EcharsInfo;
import com.tsu.mslyp.sys.entity.Stu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author monica
 * @since 2023-04-26
 */
public interface StuMapper extends BaseMapper<Stu> {
    List<Stu> findAll();
    List<EcharsInfo> getEcharsInfo();
}
