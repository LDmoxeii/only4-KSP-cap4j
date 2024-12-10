package com.only4.domain.aggregates.customer_statistics;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

import javax.persistence.*;

/**
 *
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件的字段声明，重新生成会覆盖字段声明
 * @author cap4j-ddd-codegen
 * @date 2024/11/26
 */
@Aggregate(aggregate = "CustomerStatistics", name = "CustomerStatistics", root = true, type = Aggregate.TYPE_ENTITY, description = "")
@Entity
@Table(name = "`customer_statistics`")
@DynamicInsert
@DynamicUpdate

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class CustomerStatistics {

    // 【行为方法开始】

    public void updateRank(Long num) {
        this.rank = num;
    }

    public void updateLikes(Long num) {
        this.likes = num;
    }

    public void updateFans(Long num) {
        this.fans = num;
    }

    public void updateReports(Long num) {
        this.reports = num;
    }

    public void updateFollows(Long num) {
        this.follows = num;
    }

    public void updateWorks(Long num) {
        this.works = num;
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
     * 消费者ID
     * bigint
     */
    @Column(name = "`customer_id`")
    Long customerId;

    /**
     * 经验
     * bigint
     */
    @Column(name = "`rank`")
    Long rank;

    /**
     * 点赞数
     * bigint
     */
    @Column(name = "`likes`")
    Long likes;

    /**
     * 粉丝数
     * bigint
     */
    @Column(name = "`fans`")
    Long fans;

    /**
     * 举报数
     * bigint
     */
    @Column(name = "`reports`")
    Long reports;

    /**
     * 关注数
     * bigint
     */
    @Column(name = "`follows`")
    Long follows;

    /**
     * 作品数
     * bigint
     */
    @Column(name = "`works`")
    Long works;

    // 【字段映射结束】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动
}

