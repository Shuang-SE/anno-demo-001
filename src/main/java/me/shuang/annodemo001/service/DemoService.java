package me.shuang.annodemo001.service;

import me.shuang.annodemo001.util.DemoUtil;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author lishuang
 * @since 2022年4月11日 12点50分
 */
@Service
public class DemoService {

    @Resource
    DemoUtil demoUtil;

    public String output() {
        return demoUtil.getDemoMap().toString();
    }

}
