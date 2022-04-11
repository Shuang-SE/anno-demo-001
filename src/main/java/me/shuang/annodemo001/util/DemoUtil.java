package me.shuang.annodemo001.util;

import me.shuang.annodemo001.common.Initializeable;
import me.shuang.annodemo001.demo.IDemo;
import me.shuang.annodemo001.meta.annotation.ManageBySpring;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lishuang
 * @since 2022年4月11日 12点21分
 */
@Component
@DependsOn("springContextUtil")
public class DemoUtil implements Initializeable {

    private static final ConcurrentHashMap<String, Object> DEMO_MAP = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, Object> getDemoMap() {
        return DEMO_MAP;
    }

    @Override
    @PostConstruct
    public void init() {
        DEMO_MAP.putAll(BeanCollectUtil.collect(ManageBySpring.class, IDemo.class));
    }

}
