package com.example.musicserve;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.musicserve.mapper")
public class MusicServeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicServeApplication.class, args);
    }

}
