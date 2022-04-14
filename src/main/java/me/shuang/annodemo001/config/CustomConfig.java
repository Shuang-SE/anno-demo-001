package me.shuang.annodemo001.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.shuang.annodemo001.util.JsonUtil;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * @author lishuang
 * @since 2022/04/12 15:27:10
 */
@Slf4j
@Data
@NoArgsConstructor
@Configuration
@ConfigurationProperties("custom")
public class CustomConfig {
    private List<Info> infos;

    private Map<String, String> infoMapping;

    @PostConstruct
    private void init() {
        log.info(infoMapping.toString());
    }

    @Data
    @NoArgsConstructor
    private static class Info {
        private String info;

    }
}
