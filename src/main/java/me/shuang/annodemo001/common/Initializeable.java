package me.shuang.annodemo001.common;

import javax.annotation.PostConstruct;

/**
 * @author lishuang
 * @since 2022年4月11日 12点50分
 */
public interface Initializeable {
    default void init() {
    }
}
