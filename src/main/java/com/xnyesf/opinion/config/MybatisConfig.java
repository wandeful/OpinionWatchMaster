package com.xnyesf.opinion.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author CaoLiangBin
 * @date 2024年12月04日 23:16
 * @description Mybatis配置类
 */
//约定：MBG生成的放在mapper， 自定义的放在dao
@Configuration
@MapperScan({"com.xnyesf.opinion.dao", "com.xnyesf.opinion.mapper"})
public class MybatisConfig {

}
