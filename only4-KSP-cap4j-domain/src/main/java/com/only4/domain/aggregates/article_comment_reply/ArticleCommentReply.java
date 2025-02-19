package com.only4.domain.aggregates.article_comment_reply;

import com.only4.domain.aggregates.article.events.ArticleCommentReplyCreatedDomainEvent;
import com.only4.domain.aggregates.article.events.ArticleCommentReplyDeletedDomainEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

import static org.netcorepal.cap4j.ddd.domain.event.DomainEventSupervisorSupport.events;

/**
 * 文章评论回复
 *
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件的字段声明，重新生成会覆盖字段声明
 * @author cap4j-ddd-codegen
 * @date 2025/02/19
 */
@Aggregate(aggregate = "ArticleCommentReply", name = "ArticleCommentReply", root = true, type = Aggregate.TYPE_ENTITY, description = "文章评论回复")
@Entity
@Table(name = "`article_comment_reply`")
@DynamicInsert
@DynamicUpdate
@SQLDelete(sql = "update `article_comment_reply` set `del_flag` = 1 where `id` = ? ")
@Where(clause = "`del_flag` = 0")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ArticleCommentReply {

    // 【行为方法开始】

    public void create() {
        events().attach(new ArticleCommentReplyCreatedDomainEvent(this), this);
    }

    public void delete() {
        events().attach(new ArticleCommentReplyDeletedDomainEvent(this), this);
    }

    // 【行为方法结束】



    // 【字段映射开始】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`article_comment_reply_id`", nullable = false)
    @Getter(lombok.AccessLevel.PROTECTED)
    private java.util.List<com.only4.domain.aggregates.article_comment_reply.ArticleCommentReplyStatistics> articleCommentReplyStatistics;

    public com.only4.domain.aggregates.article_comment_reply.ArticleCommentReplyStatistics getArticleCommentReplyStatistics() {
        return articleCommentReplyStatistics == null || articleCommentReplyStatistics.size() == 0 ? null : articleCommentReplyStatistics.get(0);
    }

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
     * 文章评论ID
     * bigint
     */
    @Column(name = "`article_comment_id`")
    Long articleCommentId;

    /**
     * 作者ID
     * bigint
     */
    @Column(name = "`author_id`")
    Long authorId;

    /**
     * 作者名
     * varchar(50)
     */
    @Column(name = "`author_name`")
    String authorName;

    /**
     * 内容
     * varchar(255)
     */
    @Column(name = "`content`")
    String content;

    /**
     * 创建时间
     * timestamp
     */
    @Column(name = "`create_at`")
    java.time.LocalDateTime createAt;

    /**
     * 逻辑删除
     * tinyint(1)
     */
    @Column(name = "`del_flag`")
    Boolean delFlag;

    // 【字段映射结束】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动
}


