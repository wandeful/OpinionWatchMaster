package com.xnyesf.opinion.config;

import com.xnyesf.opinion.util.scheduler.TimeFramework;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author CaoLiangBin
 * @date 2025年01月04日 18:27
 */
@Configuration
public class PublicBeanConfig {
    private static final Integer SCHEDULER_POOL_SIZE = 10;

    @Bean
    public TimeFramework generatorTimeFramework() {
        return new TimeFramework(SCHEDULER_POOL_SIZE);
    }
}
