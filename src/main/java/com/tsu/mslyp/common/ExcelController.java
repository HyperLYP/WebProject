package com.tsu.mslyp.common;

import com.alibaba.excel.EasyExcel;
import com.tsu.mslyp.sys.entity.Stu;
import com.tsu.mslyp.sys.service.IStuService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("excel")
@Slf4j
public class ExcelController {
    @Resource
    private IStuService service;
    @PostMapping("upload")
    public ResultEntity<List<Stu>> upload(@RequestPart("file") MultipartFile file) throws IOException {
        // 核心实现: 一行代码即可！
        List<Stu> list= EasyExcel
                .read(file.getInputStream())
                .head(Stu.class)
                .sheet()
                .doReadSync();
        log.info(list.toString());
//           执行存储
        boolean b = service.saveBatch(list);
        if(b){
            return ResultEntity.success(list);
        }
        return ResultEntity.fail("存储到数据库失败");
    }
}
