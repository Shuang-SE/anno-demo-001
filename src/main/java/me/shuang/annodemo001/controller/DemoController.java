package me.shuang.annodemo001.controller;

import me.shuang.annodemo001.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lishuang
 * @since 2022年4月11日 12点50分
 */
@RestController
@RequestMapping("/api/v0/demo")
public class DemoController {

    @Resource
    DemoService demoService;

    @GetMapping("/annotation")
    public String getClassesManagedByAnnotation() {
        return demoService.output();
    }
}
