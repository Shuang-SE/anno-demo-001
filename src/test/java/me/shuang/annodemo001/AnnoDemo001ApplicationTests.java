package me.shuang.annodemo001;

import me.shuang.annodemo001.demo.CustomClass;
import me.shuang.annodemo001.util.MapConvertUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class AnnoDemo001ApplicationTests {

    @Test
    void contextLoads() {
        Map<String, Object> map = new HashMap<>() {{
            put("fieldA", "1");
            put("fieldB", "2");
        }};
        CustomClass convert = MapConvertUtil.convert(map, CustomClass.class);
    }

}
