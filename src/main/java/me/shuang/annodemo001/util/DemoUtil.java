package me.shuang.annodemo001.util;

import me.shuang.annodemo001.common.Initializeable;
import me.shuang.annodemo001.demo.IDemo;
import me.shuang.annodemo001.meta.annotation.ManagedBySpring;
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

    private static final ConcurrentHashMap<String, IDemo> DEMO_MAP = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, IDemo> getDemoMap() {
        return DEMO_MAP;
    }

    public IDemo getDemo(String name) {
        IDemo bean = DEMO_MAP.get(name);
        if (bean == null) {
            throw new IllegalArgumentException("不存在的bean name, 请确认入参正确后重试！");
        }
        return bean;
    }

    @Override
    @PostConstruct
    public void init() {
        DEMO_MAP.putAll(BeanCollectUtil.collect(ManagedBySpring.class, IDemo.class));
    }

}
