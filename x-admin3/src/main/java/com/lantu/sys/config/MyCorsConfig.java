package com.lantu.sys.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @Author: sqj
 * @Date: 2023-6-13 14:48
 */

@Configuration
public class MyCorsConfig {
    @Bean
    public CorsFilter corsFilter(){
        //1.添加CORS配置信息
        CorsConfiguration config = new CorsConfiguration();
        //允许的域，不要写*，否则cookie就无法使用了，该URL地址为请求的前端服务器
        config.addAllowedOrigin("http://localhost:8888");
        //是否发送Cookie信息
        config.setAllowCredentials(true);

        //允许的请求方式
        config.addAllowedMethod("*");
        //允许所有的请求头信息
        config.addAllowedHeader("*");

        //2.添加映射路径，我们拦截一切请求
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);

        //3.返回新的CorsFilter.
        return new CorsFilter(configSource);
    }
}


