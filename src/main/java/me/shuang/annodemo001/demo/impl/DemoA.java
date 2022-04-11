package me.shuang.annodemo001.demo.impl;

import me.shuang.annodemo001.demo.IDemo;
import me.shuang.annodemo001.meta.annotation.ManageBySpring;

/**
 * @author lishuang
 * @since 2022年4月11日 12点50分
 */
@ManageBySpring
public class DemoA implements IDemo {
    @Override
    public void invoke() {
        System.out.println("DemoA");
    }
}
