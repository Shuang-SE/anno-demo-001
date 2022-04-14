package me.shuang.annodemo001;

import lombok.extern.slf4j.Slf4j;
import me.shuang.annodemo001.config.CustomConfig;
import me.shuang.annodemo001.demo.CustomClass;
import me.shuang.annodemo001.util.JsonUtil;
import me.shuang.annodemo001.util.MapConvertUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@SpringBootTest
class AnnoDemo001ApplicationTests {

    @Resource
    CustomConfig customConfig;

    @Test
    void contextLoads() {
        Map<String, Object> map = new HashMap<>() {{
            put("fieldA", "1");
            put("fieldB", "2");
        }};
        CustomClass convert = MapConvertUtil.convert(map, CustomClass.class);
    }

    @Test
    void test() {
        MapConvertUtil.convert(CustomClass.class);
    }

}
