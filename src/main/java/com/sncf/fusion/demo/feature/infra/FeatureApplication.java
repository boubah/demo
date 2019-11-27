package com.sncf.fusion.demo.feature.infra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class FeatureApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeatureApplication.class, args);
    }
}
