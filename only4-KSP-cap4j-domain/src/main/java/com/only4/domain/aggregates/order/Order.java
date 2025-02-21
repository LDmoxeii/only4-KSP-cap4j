package com.only4.domain.aggregates.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;

/**
 * 订单
 * <p>
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件的字段声明，重新生成会覆盖字段声明
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/22
 */
@Aggregate(aggregate = "Order", name = "Order", root = true, type = Aggregate.TYPE_ENTITY, description = "订单")
@Entity
@Table(name = "`order`")
@DynamicInsert
@DynamicUpdate
@SQLDelete(sql = "update `order` set `del_flag` = 1 where `id` = ? ")
@Where(clause = "`del_flag` = 0")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Order {

    // 【行为方法开始】

    public void create() {

    }

    public void refund() {
    }

    public void pay() {
    }

    public void cancel() {

    }

    // 【行为方法结束】


    // 【字段映射开始】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动

    /**
     * ID
     * bigint
     */
    @Id
    @GeneratedValue(generator = "org.netcorepal.cap4j.ddd.domain.distributed.SnowflakeIdentifierGenerator")
    @GenericGenerator(name = "org.netcorepal.cap4j.ddd.domain.distributed.SnowflakeIdentifierGenerator", strategy = "org.netcorepal.cap4j.ddd.domain.distributed.SnowflakeIdentifierGenerator")
    @Column(name = "`id`")
    Long id;

    /**
     * 订单金额
     * int
     */
    @Column(name = "`amount`")
    Integer amount;

    /**
     * 实付金额
     * int
     */
    @Column(name = "`price`")
    Integer price;

    /**
     * 状态
     * tinyint
     */
    @Column(name = "`state`")
    Byte state;

    /**
     * 逻辑删除
     * tinyint(1)
     */
    @Column(name = "`del_flag`")
    Boolean delFlag;

    // 【字段映射结束】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动
}


