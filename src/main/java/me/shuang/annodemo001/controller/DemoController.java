package me.shuang.annodemo001.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import me.shuang.annodemo001.demo.IDemo;
import me.shuang.annodemo001.service.DemoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lishuang
 * @since 2022年4月11日 12点50分
 */
@Api(tags = {"注解测试"})
@RestController
@RequestMapping("/api/v0/demo")
public class DemoController {

    @Resource
    DemoService demoService;

    @ApiOperation("返回完整的Map信息")
    @GetMapping("/annotation")
    public ConcurrentHashMap<String, IDemo> getClassesManagedByAnnotation() {
        return demoService.getMapInfo();
    }

    @ApiOperation("调用被注解@ManagedBySpring特定Bean的方法")
    @PostMapping("/annotation/{beanName}")
    public String invokeDemoBean(@ApiParam(value = "beanName, 使用/api/v0/demo/annotation中返回的key作为参数") @PathVariable String beanName) {
        return demoService.invoke(beanName);
    }
}
