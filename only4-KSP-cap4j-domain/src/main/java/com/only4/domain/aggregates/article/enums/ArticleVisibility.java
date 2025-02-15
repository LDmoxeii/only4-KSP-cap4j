package com.only4.domain.aggregates.article.enums;

import lombok.Getter;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

import javax.persistence.AttributeConverter;
import java.util.HashMap;
import java.util.Map;

/**
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/15
 */
@Aggregate(aggregate = "Article", name = "ArticleVisibility", type = "enum", description = "")
public enum ArticleVisibility {

    /**
     * PRIVATE
     */
    PRIVATE(0, "PRIVATE"),
    /**
     * PUBLISH
     */
    PUBLISH(1, "PUBLISH"),
    /**
     * BANNED
     */
    BANNED(2, "BANNED"),

    ;
    @Getter
    private int code;
    @Getter
    private String name;

    ArticleVisibility(Integer code, String name) {
        this.code = code;
        this.name = name;
    }


    private static Map<Integer, ArticleVisibility> enums = null;

    public static ArticleVisibility valueOf(Integer code) {
        if (enums == null) {
            enums = new HashMap<>();
            for (ArticleVisibility val : ArticleVisibility.values()) {
                enums.put(val.code, val);
            }
        }
        if (enums.containsKey(code)) {
            return enums.get(code);
        }
        throw new RuntimeException("枚举类型ArticleVisibility枚举值转换异常，不存在的值" + code);
    }

    /**
     * JPA转换器
     */
    public static class Converter implements AttributeConverter<ArticleVisibility, Integer> {

        @Override
        public Integer convertToDatabaseColumn(ArticleVisibility val) {
            return val.code;
        }

        @Override
        public ArticleVisibility convertToEntityAttribute(Integer code) {
            return ArticleVisibility.valueOf(code);
        }
    }
}
