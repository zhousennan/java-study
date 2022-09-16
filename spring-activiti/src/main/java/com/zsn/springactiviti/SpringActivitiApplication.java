package com.zsn.springactiviti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication

@MapperScan("com.zsn.springactiviti.reposity")
public class SpringActivitiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringActivitiApplication.class, args);
    }

}
