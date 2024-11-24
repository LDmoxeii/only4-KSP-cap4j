package com.only4.domain.aggregates.article_comment;

import com.only4.domain.aggregates.article_comment.events.ArticleCommentCreatedDomainEvent;
import com.only4.domain.aggregates.article_comment.events.ArticleCommentDeletedDomainEvent;
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
 * 文章评论
 *
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件的字段声明，重新生成会覆盖字段声明
 * @author cap4j-ddd-codegen
 * @date 2024/11/22
 */
@Aggregate(aggregate = "article_comment", name = "ArticleComment", root = true, type = Aggregate.TYPE_ENTITY, description = "文章评论")
@Entity
@Table(name = "`article_comment`")
@DynamicInsert
@DynamicUpdate
@SQLDelete(sql = "update article_comment set `del_flag` = 1 where `id` = ? ")
@Where(clause = "`del_flag` = 0")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ArticleComment {

    // 【行为方法开始】

    public void create() {
        events().attach(new ArticleCommentCreatedDomainEvent(this), this);
    }

    public void updateLikes(Long num) {

    }

    public void updateReport(Long num) {

    }

    public void delete() {
        events().attach(new ArticleCommentDeletedDomainEvent(this), this);
    }

    // 【行为方法结束】



    // 【字段映射开始】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`article_comment_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.article_comment.ArticleCommentStatistics> articleCommentStatistics;

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
     * 作者ID
     * bigint
     */
    @Column(name = "`author_id`")
    Long authorId;

    /**
     * 内容
     * varchar(255)
     */
    @Column(name = "`content`")
    String content;

    /**
     * 逻辑删除
     * tinyint(1)
     */
    @Column(name = "`del_flag`")
    Boolean delFlag;

    // 【字段映射结束】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动
}


