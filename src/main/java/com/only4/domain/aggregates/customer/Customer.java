package com.only4.domain.aggregates.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

/**
 * 消费者
 *
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件的字段声明，重新生成会覆盖字段声明
 * @author cap4j-ddd-codegen
 * @date 2024/11/22
 */
@Aggregate(aggregate = "customer", name = "Customer", root = true, type = Aggregate.TYPE_ENTITY, description = "消费者")
@Entity
@Table(name = "`customer`")
@DynamicInsert
@DynamicUpdate
@SQLDelete(sql = "update `customer` set `del_flag` = 1 where `id` = ? ")
@Where(clause = "`del_flag` = 0")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Customer {

    // 【行为方法开始】



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
     * 帐号
     * varchar(255)
     */
    @Column(name = "`account`")
    String account;

    /**
     * 密码
     * varchar(255)
     */
    @Column(name = "`password`")
    String password;

    /**
     * 余额
     * bigint
     */
    @Column(name = "`balance`")
    Long balance;

    /**
     * 昵称
     * varchar(255)
     */
    @Column(name = "`nick_name`")
    String nickName;

    /**
     * 个性签名
     * varchar(255)
     */
    @Column(name = "`signature`")
    String signature;

    /**
     * 等级
     * varchar(255)
     */
    @Column(name = "`grade`")
    String grade;

    /**
     * 逻辑删除
     * tinyint(1)
     */
    @Column(name = "`del_flag`")
    Boolean delFlag;

    // 【字段映射结束】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动
}


