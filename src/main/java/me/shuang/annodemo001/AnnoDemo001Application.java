package me.shuang.annodemo001;

import me.shuang.annodemo001.service.DemoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class AnnoDemo001Application {

    public static void main(String[] args) {
        SpringApplication.run(AnnoDemo001Application.class, args);
    }

}
