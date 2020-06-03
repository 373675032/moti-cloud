package com.moti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class MotiCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(MotiCloudApplication.class, args);
    }
}
