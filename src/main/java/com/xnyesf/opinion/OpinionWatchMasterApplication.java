package com.xnyesf.opinion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class OpinionWatchMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpinionWatchMasterApplication.class, args);
    }

}
