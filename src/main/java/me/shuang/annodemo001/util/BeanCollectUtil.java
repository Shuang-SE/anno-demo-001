package me.shuang.annodemo001.util;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author lishuang
 * @since 2022年4月11日 12点20分
 */
public class BeanCollectUtil {

    /**
     * collect all beans managed by spring and annotated with specific annotation and implements specific interface
     *
     * @param annotation specific annotation class.
     * @param clazz specific bean class, could be null.
     * @return a map contains all beans managed by spring and meet all the criteria, note that key of returned map is bean name.
     */
    public static Map<String, Object> collect(Class<? extends Annotation> annotation, Class<?> clazz) {
        return SpringContextUtil.getBeansWithAnnotation(annotation).entrySet().stream()
                .filter(entry -> Objects.isNull(clazz) || !entry.getValue().getClass().isInterface())
                .filter(entry -> Objects.isNull(clazz) || Arrays.asList(entry.getValue().getClass().getInterfaces()).contains(clazz))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
