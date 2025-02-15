package com.only4.domain.aggregates.article;

import com.only4.domain.aggregates.article.events.ArticleFavoriteCountUpdatedDomainEvent;
import com.only4.domain.aggregates.article.events.ArticleLikeCountUpdatedDomainEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

import static org.netcorepal.cap4j.ddd.domain.event.DomainEventSupervisorSupport.events;

/**
 * 文章统计
 *
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件的字段声明，重新生成会覆盖字段声明
 * @author cap4j-ddd-codegen
 * @date 2024/12/15
 */
@Aggregate(aggregate = "Article", name = "ArticleStatistics", root = false, type = Aggregate.TYPE_ENTITY, relevant = { "Article" }, description = "文章统计")
@Entity
@Table(name = "`article_statistics`")
@DynamicInsert
@DynamicUpdate
@SQLDelete(sql = "update `article_statistics` set `del_flag` = 1 where `id` = ? ")
@Where(clause = "`del_flag` = 0")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ArticleStatistics {

    // 【行为方法开始】

    public void updateArticleLikeCount(Long num) {
        this.likes = num;
        events().attach(new ArticleLikeCountUpdatedDomainEvent(this), this);
    }

    public void updateArticleFavoriteCount(Integer num) {
        this.favorites = num;
        events().attach(new ArticleFavoriteCountUpdatedDomainEvent(this), this);
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
     * 点赞数
     * bigint
     */
    @Column(name = "`likes`")
    Long likes;

    /**
     * 文章收藏数
     * int
     */
    @Column(name = "`favorites`")
    Integer favorites;

    /**
     * 评论数
     * bigint
     */
    @Column(name = "`comments`")
    Long comments;

    /**
     * 文章浏览量
     * int
     */
    @Column(name = "`views`")
    Integer views;

    /**
     * 逻辑删除
     * tinyint(1)
     */
    @Column(name = "`del_flag`")
    Boolean delFlag;

    // 【字段映射结束】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动
}


