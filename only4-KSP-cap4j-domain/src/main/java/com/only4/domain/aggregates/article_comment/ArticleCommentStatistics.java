package com.only4.domain.aggregates.article_comment;

import jakarta.persistence.Table;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import static org.netcorepal.cap4j.ddd.domain.event.DomainEventSupervisorSupport.events;

/**
 * 文章评论
 *
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件的字段声明，重新生成会覆盖字段声明
 * @author cap4j-ddd-codegen
 * @date 2025/02/19
 */
@Aggregate(aggregate = "ArticleComment", name = "ArticleCommentStatistics", root = false, type = Aggregate.TYPE_ENTITY, relevant = { "ArticleComment" }, description = "文章评论")
@Entity
@Table(name = "`article_comment_statistics`")
@DynamicInsert
@DynamicUpdate
@SQLDelete(sql = "update `article_comment_statistics` set `del_flag` = 1 where `id` = ? ")
@Where(clause = "`del_flag` = 0")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ArticleCommentStatistics {

    // 【行为方法开始】

    void updateLikeCount(Integer likeCount) {
        this.likeCount += likeCount;
    }

    void updateReplyCount(Integer replyCount) {
        this.replyCount += replyCount;
    }

    void addReportCount(@Positive Integer reportCount) {
        this.reportCount = this.getReportCount() + reportCount;
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
     * 评论回复数
     * int
     */
    @Column(name = "`reply_count`")
    Integer replyCount;

    /**
     * 评论举报数
     * int
     */
    @Column(name = "`report_count`")
    Integer reportCount;

    /**
     * 逻辑删除
     * tinyint(1)
     */
    @Column(name = "`del_flag`")
    Boolean delFlag;

    // 【字段映射结束】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动
}


