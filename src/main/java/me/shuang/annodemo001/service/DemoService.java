package me.shuang.annodemo001.service;

import me.shuang.annodemo001.demo.IDemo;
import me.shuang.annodemo001.util.DemoUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lishuang
 * @since 2022年4月11日 12点50分
 */
@Service
public class DemoService {

    @Resource
    DemoUtil demoUtil;

    public ConcurrentHashMap<String, IDemo> getMapInfo() {
        return demoUtil.getDemoMap();
    }

    public String invoke(String beanName) {
        return demoUtil.getDemo(beanName).invoke();
    }

}
