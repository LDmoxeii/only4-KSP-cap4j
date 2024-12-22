package com.only4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author cap4j-ddd-codegen
 */
@SpringBootApplication
@EnableFeignClients
@EnableScheduling
@EnableJpaRepositories(basePackages = "com.only4.adapter.domain.repositories")
@EntityScan(basePackages = "com.only4.domain.aggregates")
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);

    }

}