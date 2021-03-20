package com.fanyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@EnableCaching
@SpringBootApplication
public class SpringbootbjApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootbjApplication.class, args);
    }

}
