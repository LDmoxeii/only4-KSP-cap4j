package com.only4.domain.aggregates.favorites.enums;

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
@Aggregate(aggregate = "favorites", name = "FavoritesState", type = "enum", description = "")
public enum FavoritesState {

    /**
     * INIT
     */
    INIT(0, "INIT"),

;
    @Getter
    private final int code;
    @Getter
    private final String name;

    FavoritesState(Integer code, String name){
        this.code = code;
        this.name = name;
    }


    private static Map<Integer, FavoritesState> enums = null;
    public static FavoritesState valueOf(Integer code) {
        if(enums == null) {
            enums = new HashMap<>();
            for (FavoritesState val : FavoritesState.values()) {
                enums.put(val.code, val);
            }
        }
        if(enums.containsKey(code)){
            return enums.get(code);
        }
        throw new RuntimeException("枚举类型FavoritesState枚举值转换异常，不存在的值" + code);
    }

    /**
     * JPA转换器
     */
    public static class Converter implements AttributeConverter<FavoritesState, Integer>{

        @Override
        public Integer convertToDatabaseColumn(FavoritesState  val) {
            return val.code;
        }

        @Override
        public FavoritesState convertToEntityAttribute(Integer code) {
            return FavoritesState.valueOf(code);
        }
    }
}
