package com.only4.domain.aggregates.follow;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

/**
 * 关注
 *
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件的字段声明，重新生成会覆盖字段声明
 * @author cap4j-ddd-codegen
 * @date 2024/11/22
 */
@Aggregate(aggregate = "Follow", name = "Follow", root = true, type = Aggregate.TYPE_ENTITY, description = "关注")
@Entity
@Table(name = "`follow`")
@DynamicInsert
@DynamicUpdate
@SQLDelete(sql = "update `follow` set `del_flag` = 1 where `id` = ? ")
@Where(clause = "`del_flag` = 0")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Follow {

    // 【行为方法开始】

    public void create() {}

    public void delete() {}

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
     * 关注人ID
     * bigint
     */
    @Column(name = "`follower_id`")
    Long followerId;

    /**
     * 被关注人ID
     * bigint
     */
    @Column(name = "`followed_id`")
    Long followedId;

    /**
     * 逻辑删除
     * tinyint(1)
     */
    @Column(name = "`del_flag`")
    Boolean delFlag;

    // 【字段映射结束】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动
}


