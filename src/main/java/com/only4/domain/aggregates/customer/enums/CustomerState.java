package com.only4.domain.aggregates.customer.enums;

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
@Aggregate(aggregate = "Customer", name = "CustomerState", type = "enum", description = "")
public enum CustomerState {

    /**
     * INIT
     */
    INIT(0, "INIT"),
    /**
     * BANNED
     */
    BANNED(2, "BANNED"),

;
    @Getter
    private int code;
    @Getter
    private String name;

    CustomerState(Integer code, String name){
        this.code = code;
        this.name = name;
    }


    private static Map<Integer, CustomerState> enums = null;
    public static CustomerState valueOf(Integer code) {
        if(enums == null) {
            enums = new HashMap<>();
            for (CustomerState val : CustomerState.values()) {
                enums.put(val.code, val);
            }
        }
        if(enums.containsKey(code)){
            return enums.get(code);
        }
        throw new RuntimeException("枚举类型CustomerState枚举值转换异常，不存在的值" + code);
    }

    /**
     * JPA转换器
     */
    public static class Converter implements AttributeConverter<CustomerState, Integer>{

        @Override
        public Integer convertToDatabaseColumn(CustomerState  val) {
            return val.code;
        }

        @Override
        public CustomerState convertToEntityAttribute(Integer code) {
            return CustomerState.valueOf(code);
        }
    }
}
