package com.tsu.mslyp.sys.controller;

import com.tsu.mslyp.common.ResultEntity;
import com.tsu.mslyp.sys.entity.EcharsInfo;
import com.tsu.mslyp.sys.entity.Stu;
import com.tsu.mslyp.sys.service.IStuService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/sys/stu")
@Slf4j
public class StuController {
    @Resource
    private IStuService stuService;
    @RequestMapping("listAll")
    public ResultEntity<List<Stu>> findAll() {
//        pageNum 第几页 ，pageSize 每页有多少条
//        List<Stu> list = stuService.list();
        List<Stu> all = stuService.findAll();
        return ResultEntity.success(all);
    }
    @RequestMapping("list")
    public ResultEntity<List<Stu>> findStuList(int pageNum, int pageSize) {
        // pageNum: 第几页  pageSize: 每页几条
        //List<Stu> list = stuService.list();
        ResultEntity<List<Stu>> listResultEntity = stuService.selectByPage(pageNum, pageSize);
        return listResultEntity;
    }
    @RequestMapping("add")
    public ResultEntity addStu(@RequestBody Stu stu) {
        boolean save = stuService.save(stu);
        if (!save) {
            return ResultEntity.fail("操作失败");
        }
        return ResultEntity.success();
    }
    @PostMapping("edit")
    public ResultEntity editStu(@RequestBody Stu stu) {
        log.info("--------------------- "+stu.toString());
        boolean save = stuService.updateById(stu);
        if (!save) {
            return ResultEntity.fail("修改失败");
        }
        return ResultEntity.success();
    }
    @PostMapping("delete")
    public ResultEntity deleteStu(@RequestBody Stu stu) {
        boolean save = stuService.removeById(stu);
        if (!save) {
            return ResultEntity.fail("删除失败");
        }
        return ResultEntity.success("删除成功");
    }
    //    查询各专业有多少人：
    //    查询各专业有多少人：
    @RequestMapping("echarsInfo")
    public ResultEntity echarsInfo() {
        List<EcharsInfo> list = stuService.getEcharsInfo();
        return ResultEntity.success(list);
    }
}
