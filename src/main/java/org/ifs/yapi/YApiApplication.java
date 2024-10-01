package org.ifs.yapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author wangsong
 * @date 2024/10/01
 */
@SpringBootApplication
@MapperScan(basePackages = {"org.ifs.yapi.mapper"})
public class YApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(YApiApplication.class, args);
    }
}
