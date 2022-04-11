package me.shuang.annodemo001.config.injector;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lishuang
 * @since 2022/04/11 14:16:56
 */
@Configuration
public class ObjectMapperInjector {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
