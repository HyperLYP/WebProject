package com.tsu.mslyp;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class GenerateCode {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db_ms01?useUnicode=true&characterEncoding=UTF-8";
        String username = "root";
        String password = "123456";
        //生成代码的路径：
        String pathGenerate = "C:\\code\\mslyp\\src\\main\\java";
        //模块名：
        String modeName = "sys";
        //xml文件的生成目录：
        String filePath = "C:\\code\\mslyp\\src\\main\\resources\\mapper\\"+modeName;
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("monica") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式 --生成的代码会有swagger相关注解！
                            .outputDir(pathGenerate); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.tsu.mslyp") // 设置父包名
                            .moduleName(modeName) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, filePath)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("tb_user,tb_major,tb_stu") // 设置需要生成的表名
                            .addTablePrefix("tb_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}