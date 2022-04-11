package me.shuang.annodemo001.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * @author lishuang
 * @since 2022年4月11日 12点21分
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        validateContextInjected();
        return applicationContext;
    }

    public static Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> annotation) {
        if (annotation == null) {
            return null;
        }
        validateContextInjected();
        return applicationContext.getBeansWithAnnotation(annotation);
    }

    public static void validateContextInjected() {
        if (applicationContext == null) {
            throw new IllegalStateException("application context未注入");
        }
    }
}
