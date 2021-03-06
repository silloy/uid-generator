package com.baidu.fsg.uid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
public class UidApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(UidApplication.class);
        application.run(args);
    }

}
