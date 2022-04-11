package me.shuang.annodemo001.util;

import lombok.extern.slf4j.Slf4j;
import me.shuang.annodemo001.meta.annotation.CustomColumnName;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lishuang
 * @since 2022/04/11 18:54:07
 */
@Slf4j
public class MapConvertUtil {
    public static <T> T convert(Map<String, Object> map, Class<T> clazz) {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();
            List<Field> fields = Arrays.stream(clazz.getDeclaredFields())
                    .filter(field -> field.isAnnotationPresent(CustomColumnName.class))
                    .peek(field -> {
                        Object val = map.get(field.getAnnotation(CustomColumnName.class).value());
                        field.setAccessible(true);
                        try {
                            field.set(instance, val);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    })
                    .collect(Collectors.toList());
            log.info("共检测到{}个可转换的字段", fields.size());
            log.info(JsonUtil.toJson(instance));
            return instance;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }

    }
}
