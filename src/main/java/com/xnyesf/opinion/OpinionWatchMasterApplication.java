package com.xnyesf.opinion;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author CaoLiangBin
 * @Date 2024/11/30 12:52
 * @Version 1.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
public class OpinionWatchMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpinionWatchMasterApplication.class, args);
    }

}
