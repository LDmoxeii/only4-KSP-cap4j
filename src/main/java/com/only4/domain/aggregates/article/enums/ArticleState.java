package com.only4.domain.aggregates.article.enums;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.AttributeConverter;
import lombok.Getter;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

/**
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2024/11/22
 */
@Aggregate(aggregate = "article", name = "ArticleState", type = "enum", description = "")
public enum ArticleState {

    /**
     * INIT
     */
    INIT(0, "INIT"),

;
    @Getter
    private final int code;
    @Getter
    private final String name;

    ArticleState(Integer code, String name){
        this.code = code;
        this.name = name;
    }


    private static Map<Integer, ArticleState> enums = null;
    public static ArticleState valueOf(Integer code) {
        if(enums == null) {
            enums = new HashMap<>();
            for (ArticleState val : ArticleState.values()) {
                enums.put(val.code, val);
            }
        }
        if(enums.containsKey(code)){
            return enums.get(code);
        }
        throw new RuntimeException("枚举类型ArticleState枚举值转换异常，不存在的值" + code);
    }

    /**
     * JPA转换器
     */
    public static class Converter implements AttributeConverter<ArticleState, Integer>{

        @Override
        public Integer convertToDatabaseColumn(ArticleState  val) {
            return val.code;
        }

        @Override
        public ArticleState convertToEntityAttribute(Integer code) {
            return ArticleState.valueOf(code);
        }
    }
}
