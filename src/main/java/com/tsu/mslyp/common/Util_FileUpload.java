package com.tsu.mslyp.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
public class Util_FileUpload {
    //    返回值是：生成的新的名字
    public static String uploadImg(MultipartFile file, String uploadLocation) {
        if (file.isEmpty()) {
            return "";
        }
        String originalFilename = file.getOriginalFilename();//获取文件名
        String suffix = originalFilename.substring(originalFilename.lastIndexOf('.'));
        // 创建一个不重复的名字
        String fileName = UUID.randomUUID() + suffix;
        //判断存储路径是否存在！
        File dir = new File(uploadLocation);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        //使用方法直接存储即可！
        try {
            file.transferTo(new File(uploadLocation + fileName));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        return fileName;
    }
}
