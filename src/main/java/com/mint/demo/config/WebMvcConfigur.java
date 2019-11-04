package com.mint.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by IntelliJ IDEA.
 * User: liuhao
 * Date: 2019/11/04
 * Time: 13:35
 */
@Configuration
public class WebMvcConfigur implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations("file:C:/Users/liuhao/IdeaProjects/demo/src/main/resources/static/");
    }
}
