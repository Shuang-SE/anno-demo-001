package me.shuang.annodemo001.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.shuang.annodemo001.meta.annotation.CustomColumnName;

/**
 * @author lishuang
 * @since 2022/04/11 18:57:22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomClass {

    @CustomColumnName("fieldA")
    private String field1;

    @CustomColumnName("fieldB")
    private String field2;
}
