package com.only4.domain.aggregates.article_statistics;

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
 * 文章统计表
 *
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件的字段声明，重新生成会覆盖字段声明
 * @author cap4j-ddd-codegen
 * @date 2024/11/26
 */
@Aggregate(aggregate = "ArticleStatistics", name = "ArticleStatistics", root = true, type = Aggregate.TYPE_ENTITY, description = "文章统计表")
@Entity
@Table(name = "`article_statistics`")
@DynamicInsert
@DynamicUpdate

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ArticleStatistics {

    // 【行为方法开始】

    public void updateReport(Long num) {
        this.reports = num;
    }

    public void updateLikes(Long num) {
        this.likes = num;
    }

    public void updateComments(Long num) {
        this.comments = num;
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
     * 文章ID
     * bigint
     */
    @Column(name = "`article_id`")
    Long articleId;

    /**
     * 点赞数
     * bigint
     */
    @Column(name = "`likes`")
    Long likes;

    /**
     * 举报数
     * bigint
     */
    @Column(name = "`reports`")
    Long reports;

    /**
     * 评论数
     * bigint
     */
    @Column(name = "`comments`")
    Long comments;

    // 【字段映射结束】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动
}


