package com.only4.domain.aggregates.star_comment;

import jakarta.persistence.Table;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

/**
 * 星球评论统计
 *
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件的字段声明，重新生成会覆盖字段声明
 * @author cap4j-ddd-codegen
 * @date 2025/02/23
 */
@Aggregate(aggregate = "StarComment", name = "StarCommentStatistics", root = false, type = Aggregate.TYPE_ENTITY, relevant = { "StarComment" }, description = "星球评论统计")
@Entity
@Table(name = "`star_comment_statistics`")
@DynamicInsert
@DynamicUpdate
@SQLDelete(sql = "update `star_comment_statistics` set `del_flag` = 1 where `id` = ? ")
@Where(clause = "`del_flag` = 0")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class StarCommentStatistics {

    // 【行为方法开始】

    void updateLikeCount(@NotNull Integer likeCount) {
        this.likeCount = this.getLikeCount() + likeCount;
    }

    void updateReportCount(@NotNull Integer reportCount) {
        this.reportCount = this.getReportCount() + reportCount;
    }

    void updateReplyCount(@NotNull Integer replyCount) {
        this.replyCount = this.getReplyCount() + replyCount;
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
     * 举报数
     * int
     */
    @Column(name = "`report_count`")
    Integer reportCount;

    /**
     * 回复数
     * int
     */
    @Column(name = "`reply_count`")
    Integer replyCount;

    /**
     * 逻辑删除
     * tinyint(1)
     */
    @Column(name = "`del_flag`")
    Boolean delFlag;

    // 【字段映射结束】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动
}


