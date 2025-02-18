package com.only4.domain.aggregates.article;

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
 * 文章统计
 * <p>
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件的字段声明，重新生成会覆盖字段声明
 *
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

    void updateLikeCount(Integer num) {
        this.likeCount += num;
    }

    void updateFavoriteCount(Integer num) {
        this.favoriteCount += num;
    }

    void updateCommentCount(Integer commentCount) {
        this.commentCount += commentCount;
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
     * int
     */
    @Column(name = "`like_count`")
    Integer likeCount;

    /**
     * 文章收藏数
     * int
     */
    @Column(name = "`favorite_count`")
    Integer favoriteCount;

    /**
     * 评论数
     * int
     */
    @Column(name = "`comment_count`")
    Integer commentCount;

    /**
     * 文章浏览量
     * int
     */
    @Column(name = "`view_count`")
    Integer viewCount;

    /**
     * 逻辑删除
     * tinyint(1)
     */
    @Column(name = "`del_flag`")
    Boolean delFlag;

    // 【字段映射结束】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动
}


