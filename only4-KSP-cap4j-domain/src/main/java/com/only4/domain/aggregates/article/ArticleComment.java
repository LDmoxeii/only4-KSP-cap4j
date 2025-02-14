package com.only4.domain.aggregates.article;

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
import java.util.Objects;

/**
 * 文章评论
 *
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件的字段声明，重新生成会覆盖字段声明
 * @author cap4j-ddd-codegen
 * @date 2024/12/15
 */
@Aggregate(aggregate = "Article", name = "ArticleComment", root = false, type = Aggregate.TYPE_ENTITY, relevant = { "Article" }, description = "文章评论")
@Entity
@Table(name = "`article_comment`")
@DynamicInsert
@DynamicUpdate
@SQLDelete(sql = "update `article_comment` set `del_flag` = 1 where `id` = ? ")
@Where(clause = "`del_flag` = 0")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ArticleComment {

    // 【行为方法开始】

    public void likeArticleComment(ArticleCommentLike newArticleCommentLike) {
        this.getArticleCommentLikes().add(newArticleCommentLike);
        this.getArticleCommentStatistics().likes++;
    }

    public void unlikeArticleComment(Long articleCommentLikeId) {
        this.getArticleCommentLikes().stream()
                .filter(cl -> Objects.equals(cl.getId(), articleCommentLikeId))
                .findFirst()
                .ifPresent(commentLike -> this.getArticleCommentLikes().remove(commentLike));
        this.getArticleCommentStatistics().likes--;
    }



    // 【行为方法结束】



    // 【字段映射开始】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`article_comment_id`", nullable = false)
    @Getter(lombok.AccessLevel.PROTECTED)
    private java.util.List<com.only4.domain.aggregates.article.ArticleCommentStatistics> articleCommentStatistics;

    public com.only4.domain.aggregates.article.ArticleCommentStatistics getArticleCommentStatistics() {
        return articleCommentStatistics == null || articleCommentStatistics.size() == 0 ? null : articleCommentStatistics.get(0);
    }

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`article_comment_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.article.ArticleCommentLike> articleCommentLikes;

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
     * 父评论ID
     * bigint
     */
    @Column(name = "`parent_id`")
    Long parentId;

    /**
     * 评论用户ID
     * bigint
     */
    @Column(name = "`author_id`")
    Long authorId;

    /**
     * 评论用户名
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
     * 置顶标识
     * tinyint(1)
     */
    @Column(name = "`sticky_flag`")
    Boolean stickyFlag;

    /**
     * 评论时间
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


