package com.tsu.mslyp.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${file.staticAccessPath}")
    private String staticAccessPath;
    @Value("${file.uploadLocation}")
    private String uploadLocation;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //addResourceLocations 指的是文件放置的目录，addResoureHandler 指的是对外暴露的访问路径
        registry.addResourceHandler(staticAccessPath).addResourceLocations("file:" + uploadLocation);
    }
}