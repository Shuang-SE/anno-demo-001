package me.shuang.annodemo001.demo.impl;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import me.shuang.annodemo001.demo.IDemo;
import me.shuang.annodemo001.meta.annotation.ManagedBySpring;

/**
 * @author lishuang
 * @since 2022年4月11日 12点50分
 */
@Slf4j
@ManagedBySpring
@Data
public class DemoB implements IDemo {
    private String name = this.getClass().getCanonicalName();

    @Override
    public String invoke() {
        log.info("DemoB is Invoked");
        return getName();
    }
}
