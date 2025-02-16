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
@Aggregate(aggregate = "Article", name = "CommentVisibility", type = "enum", description = "")
public enum CommentVisibility {

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

    CommentVisibility(Integer code, String name) {
        this.code = code;
        this.name = name;
    }


    private static Map<Integer, CommentVisibility> enums = null;

    public static CommentVisibility valueOf(Integer code) {
        if (enums == null) {
            enums = new HashMap<>();
            for (CommentVisibility val : CommentVisibility.values()) {
                enums.put(val.code, val);
            }
        }
        if (enums.containsKey(code)) {
            return enums.get(code);
        }
        throw new RuntimeException("枚举类型CommentVisibility枚举值转换异常，不存在的值" + code);
    }

    /**
     * JPA转换器
     */
    public static class Converter implements AttributeConverter<CommentVisibility, Integer> {

        @Override
        public Integer convertToDatabaseColumn(CommentVisibility val) {
            return val.code;
        }

        @Override
        public CommentVisibility convertToEntityAttribute(Integer code) {
            return CommentVisibility.valueOf(code);
        }
    }
}
