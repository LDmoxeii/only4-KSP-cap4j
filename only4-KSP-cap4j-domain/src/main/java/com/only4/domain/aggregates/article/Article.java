package com.only4.domain.aggregates.article;

import com.only4.domain.aggregates.article.enums.ArticleVisibility;
import com.only4.domain.aggregates.article.enums.CommentVisibility;
import com.only4.domain.aggregates.article.events.*;
import com.only4.domain.aggregates.category.Category;
import com.only4.domain.aggregates.tag.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.netcorepal.cap4j.ddd.domain.event.DomainEventSupervisorSupport.events;

/**
 * 文章
 * <p>
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件的字段声明，重新生成会覆盖字段声明
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/22
 */
@Aggregate(aggregate = "Article", name = "Article", root = true, type = Aggregate.TYPE_ENTITY, description = "文章")
@Entity
@Table(name = "`article`")
@DynamicInsert
@DynamicUpdate
@SQLDelete(sql = "update article set `del_flag` = 1 where `id` = ? ")
@Where(clause = "`del_flag` = 0")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Article {

    // 【行为方法开始】

    public void create() {
        events().attach(new ArticleCreatedDomainEvent(this), this);
    }

    public void updateVisibility(ArticleVisibility newVisibility, Boolean newStickyFlag, Boolean newCommentFlag) {
        this.visibility = newVisibility;
        this.stickyFlag = newStickyFlag;
        this.commentFlag = newCommentFlag;
    }

    public void updateInfo(String newTitle, String newDescription) {
        this.title = newTitle;
        this.description = newDescription;
    }

    public void ban(Integer banDuration, LocalDateTime bannedAt) {
        this.visibility = ArticleVisibility.BANNED;
        this.bannedAt = bannedAt;
        this.banDuration = banDuration;
    }

    public void report() {
    }

    public void like(Long memberId, LocalDateTime now) {
        this.getArticleLikes().add(new ArticleLike(memberId, now));
        this.getArticleStatistics().updateLikeCount(1L);
        events().attach(new ArticleLikedDomainEvent(this), this);
    }

    public void unlike(Long articleLikeId) {
        this.getArticleLikes().stream()
                .filter(al -> Objects.equals(al.getId(), articleLikeId))
                .findFirst()
                .ifPresent(articleLike -> this.getArticleLikes().remove(articleLike));
        this.getArticleStatistics().updateLikeCount(-1L);
        events().attach(new ArticleUnlikedDomainEvent(this), this);
    }

    public void updateTags(List<Tag> tags) {
        this.articleTags = tags.stream()
                .map(tag -> new ArticleTag(tag.getId(), tag.getName()))
                .collect(Collectors.toList());
    }

    public void updateCategory(List<Category> categories) {
        this.articleCategories = categories.stream()
                .map(category -> new ArticleCategory(category.getId(), category.getName()))
                .collect(Collectors.toList());
    }

    public void updateLikeCount(Long likeCount) {
        this.getArticleStatistics().updateLikeCount(likeCount);
        events().attach(new ArticleLikeCountUpdatedDomainEvent(this), this);
    }

    public void updateFavoriteCount(Integer favoriteCount) {
        this.getArticleStatistics().updateArticleFavoriteCount(favoriteCount);
        events().attach(new ArticleFavoriteCountUpdatedDomainEvent(this), this);
    }

    public void createComment(Long memberId, String memberName, String content, LocalDateTime createAt) {
        this.articleComments.add(new ArticleComment(memberId, memberName, content, createAt));
        events().attach(new ArticleCommentCreatedDomainEvent(this), this);
    }

    public void updateCommentInfo(Long commentId, String memberName) {
        this.getArticleComments().stream()
                .filter(c -> Objects.equals(c.getId(), commentId))
                .findFirst()
                .ifPresent(comment -> comment.updateInfo(memberName));
    }

    public void reportComment(Long commentId) {
        this.getArticleComments().stream()
                .filter(c-> Objects.equals(c.getId(), commentId))
                .findFirst()
                .ifPresent(ArticleComment::report);
    }

    public void deleteComment(Long commentId) {
        this.getArticleComments().stream()
                .filter(c -> Objects.equals(c.getId(), commentId))
                .findFirst()
                .ifPresent(comment -> this.getArticleComments().remove(comment));
        events().attach(new ArticleCommentDeletedDomainEvent(this), this);
    }

    public void likeComment(Long commentId, Long memberId, LocalDateTime now) {
        this.getArticleComments().stream()
                .filter(ac -> Objects.equals(ac.getId(), commentId))
                .findFirst()
                .ifPresent(articleComment -> articleComment.like(new ArticleCommentLike(memberId, now)));
        events().attach(new ArticleCommentLikedDomainEvent(this), this);
    }

    public void unlikeComment(Long commentId, Long memberId) {
        this.getArticleComments().stream()
                .filter(ac -> Objects.equals(ac.getId(), commentId))
                .findFirst()
                .ifPresent(articleComment -> articleComment.unlike(memberId));
        events().attach(new ArticleCommentUnlikedDomainEvent(this), this);
    }

    public void updateCommentLikeCount(Long commentId, Long likeCount) {
        this.getArticleComments().stream()
                .filter(ac -> Objects.equals(ac.getId(), commentId))
                .findFirst()
                .ifPresent(articleComment -> articleComment.updateLikeCount(likeCount));
        events().attach(new ArticleCommentLikeCountUpdatedDomainEvent(this), this);
    }

    public void updateCommentVisibility(Long commentId, CommentVisibility visibility) {
        this.getArticleComments().stream()
                .filter(ac -> Objects.equals(ac.getId(), commentId))
                .findFirst()
                .ifPresent(articleComment -> articleComment.updateVisibility(visibility));
    }

    public void updateCommentSticky(Long commentId, Boolean sticky) {
        this.getArticleComments().stream()
                .filter(ac -> Objects.equals(ac.getId(), commentId))
                .findFirst()
                .ifPresent(articleComment -> articleComment.updateSticky(sticky));
    }

    public void updateCommentCount(Long commentCount) {
        this.getArticleStatistics().updateCommentCount(commentCount);
    }

    public void updateCommentReplyCount(Long commentId, Integer replyCount) {
        this.getArticleComments().stream()
                .filter(ac -> Objects.equals(ac.getId(), commentId))
                .findFirst()
                .ifPresent(articleComment -> articleComment.updateReplyCount(replyCount));
    }

    public void updateAuthorInfo(Long memberId, String memberName) {
        this.getArticleAuthors().stream()
                .filter(aa -> Objects.equals(aa.getId(), memberId))
                .forEach(articleAuthor -> articleAuthor.updateInfo(memberName));
    }

    public void updateTagInfo(Long tagId, String tagName) {
        this.getArticleTags().stream()
                .filter(at -> Objects.equals(at.getId(), tagId))
                .findFirst()
                .ifPresent(articleTag -> articleTag.updateInfo(tagName));
    }

    public void updateCategoryInfo(Long categoryId, String categoryName) {
        this.getArticleCategories().stream()
                .filter(ac -> Objects.equals(ac.getId(), categoryId))
                .findFirst()
                .ifPresent(articleCategory -> articleCategory.updateInfo(categoryName));
    }

    /**
     * 暂未设计
     */
    public void reportArticleComment() {
        throw new UnsupportedOperationException("未实现");
    }

    public void deleteArticle() {
        this.delFlag = true;
    }

    // 【行为方法结束】


    // 【字段映射开始】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`article_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.article.ArticleCategory> articleCategories;

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`article_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.article.ArticleAuthor> articleAuthors;

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`article_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.article.ArticleComment> articleComments;

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`article_id`", nullable = false)
    @Getter(lombok.AccessLevel.PROTECTED)
    private java.util.List<com.only4.domain.aggregates.article.ArticleStatistics> articleStatistics;

    public com.only4.domain.aggregates.article.ArticleStatistics getArticleStatistics() {
        return articleStatistics == null || articleStatistics.size() == 0 ? null : articleStatistics.get(0);
    }

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`article_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.article.ArticleTag> articleTags;

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`article_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.article.ArticleLike> articleLikes;

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
     * 标题
     * varchar(255)
     */
    @Column(name = "`title`")
    String title;

    /**
     * 描述
     * varchar(255)
     */
    @Column(name = "`description`")
    String description;

    /**
     * 内容
     * varchar(255)
     */
    @Column(name = "`content`")
    String content;

    /**
     * 文章封面
     * varchar(255)
     */
    @Column(name = "`cover`")
    String cover;

    /**
     * 文章附件
     * int
     */
    @Column(name = "`appendix`")
    Integer appendix;

    /**
     * 文章价格
     * bigint
     */
    @Column(name = "`price`")
    Long price;

    /**
     * 文章状态
     * 0:PRIVATE:PRIVATE
     * 1:PUBLISH:PUBLISH
     * 2:BANNED:BANNED
     * tinyint
     */
    @Convert(converter = com.only4.domain.aggregates.article.enums.ArticleVisibility.Converter.class)
    @Column(name = "`visibility`")
    com.only4.domain.aggregates.article.enums.ArticleVisibility visibility;

    /**
     * 置顶标识
     * tinyint(1)
     */
    @Column(name = "`sticky_flag`")
    Boolean stickyFlag;

    /**
     * 评论功能标识
     * tinyint(1)
     */
    @Column(name = "`comment_flag`")
    Boolean commentFlag;

    /**
     * 逻辑删除
     * tinyint(1)
     */
    @Column(name = "`del_flag`")
    Boolean delFlag;

    /**
     * 封禁时间
     * timestamp
     */
    @Column(name = "`banned_at`")
    java.time.LocalDateTime bannedAt;

    /**
     * 封禁时间
     * int
     */
    @Column(name = "`ban_duration`")
    Integer banDuration;

    // 【字段映射结束】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动
}


