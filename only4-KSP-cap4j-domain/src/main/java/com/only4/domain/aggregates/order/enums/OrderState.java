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
 * @date 2024/11/24
 */
@Aggregate(aggregate = "Order", name = "OrderState", type = "enum", description = "")
public enum OrderState {

    /**
     * INIT
     */
    INIT(0, "INIT"),
    /**
     * REFUND
     */
    REFUND(1, "REFUND"),
    /**
     * CANCELED
     */
    CANCELED(2, "CANCELED"),

;
    @Getter
    private int code;
    @Getter
    private String name;

    OrderState(Integer code, String name){
        this.code = code;
        this.name = name;
    }


    private static Map<Integer, OrderState> enums = null;
    public static OrderState valueOf(Integer code) {
        if(enums == null) {
            enums = new HashMap<>();
            for (OrderState val : OrderState.values()) {
                enums.put(val.code, val);
            }
        }
        if(enums.containsKey(code)){
            return enums.get(code);
        }
        throw new RuntimeException("枚举类型OrderState枚举值转换异常，不存在的值" + code);
    }

    /**
     * JPA转换器
     */
    public static class Converter implements AttributeConverter<OrderState, Integer>{

        @Override
        public Integer convertToDatabaseColumn(OrderState  val) {
            return val.code;
        }

        @Override
        public OrderState convertToEntityAttribute(Integer code) {
            return OrderState.valueOf(code);
        }
    }
}
