package me.shuang.annodemo001.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author lishuang
 * @since 2022/04/11 14:16:26
 */
@Slf4j
@Component
public class JsonUtil {
    private static ObjectMapper objectMapper;

    public JsonUtil(ObjectMapper objectMapper) {
        JsonUtil.objectMapper = objectMapper;
    }

    public static String toJson(Object obj) {
        if (obj == null) {
            return null;
        }
        if (objectMapper == null) {
            throw new NullPointerException("objectMapper is not injected yet.");
        }
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("Json 转换异常", e);
            return null;
        }
    }

    public static <T> T parseObject(String json, Class<T> clazz) {
        if (objectMapper == null) {
            throw new NullPointerException("objectMapper is not injected yet.");
        }
        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            log.error("Json 转换异常", e);
            return null;
        }
    }
}
