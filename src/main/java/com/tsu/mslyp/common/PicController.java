package com.tsu.mslyp.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("file")
@Slf4j
public class PicController {
    //引用配置文件：
    @Value("${file.uploadLocation}")
    private String uploadLocation;

    @PostMapping("upload")
    public ResultEntity upload(@RequestParam("file") MultipartFile file) {
//            获取原始名字 -- 重新命名 --- 指定保存文件夹 -- 保存操作！
        String fileName =  Util_FileUpload.uploadImg(file, uploadLocation);
        if("".equals(fileName)){
            return ResultEntity.fail("上传失败");
        }
        return ResultEntity.success(fileName);
    }
}
