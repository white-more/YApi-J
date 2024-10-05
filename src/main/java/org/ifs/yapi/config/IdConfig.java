package org.ifs.yapi.config;

import org.ifs.yapi.common.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IdConfig {

    @Bean
    public IdWorker idWorker() {
        return new IdWorker(0L, 0L, 0);
    }
}
