package com.only4.domain.aggregates.order.enums;

import lombok.Getter;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

import javax.persistence.AttributeConverter;
import java.util.HashMap;
import java.util.Map;

/**
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2024/11/22
 */
@Aggregate(aggregate = "Order", name = "OrderType", type = "enum", description = "")
public enum OrderType {

    /**
     * INIT
     */
    INIT(0, "INIT"),

;
    @Getter
    private final int code;
    @Getter
    private final String name;

    OrderType(Integer code, String name){
        this.code = code;
        this.name = name;
    }


    private static Map<Integer, OrderType> enums = null;
    public static OrderType valueOf(Integer code) {
        if(enums == null) {
            enums = new HashMap<>();
            for (OrderType val : OrderType.values()) {
                enums.put(val.code, val);
            }
        }
        if(enums.containsKey(code)){
            return enums.get(code);
        }
        throw new RuntimeException("枚举类型OrderType枚举值转换异常，不存在的值" + code);
    }

    /**
     * JPA转换器
     */
    public static class Converter implements AttributeConverter<OrderType, Integer>{

        @Override
        public Integer convertToDatabaseColumn(OrderType  val) {
            return val.code;
        }

        @Override
        public OrderType convertToEntityAttribute(Integer code) {
            return OrderType.valueOf(code);
        }
    }
}
