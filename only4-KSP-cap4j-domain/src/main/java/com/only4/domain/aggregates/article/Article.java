package com.only4.domain.aggregates.article;

import com.only4._share.exception.KnownException;
import com.only4.domain.aggregates.article.enums.ArticleVisibility;
import com.only4.domain.aggregates.article.events.ArticleCreatedDomainEvent;
import com.only4.domain.aggregates.article.events.ArticleFavoriteCountUpdatedDomainEvent;
import com.only4.domain.aggregates.article.events.ArticleLikeCountUpdatedDomainEvent;
import com.only4.domain.aggregates.category.Category;
import com.only4.domain.aggregates.tag.Tag;
import lombok.*;
import org.hibernate.annotations.*;
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

    public void updateVisibility(ArticleVisibility newVisibility) {
        this.visibility = newVisibility;
    }

    public void updateInfo(String newTitle, String newDescription) {
        this.title = newTitle;
        this.description = newDescription;
    }

    public void ban(Integer banDuration) {
        if (this.visibility.equals(ArticleVisibility.BANNED)) {
            throw new KnownException("文章已被封禁");
        }
        this.bannedAt = LocalDateTime.now();
        this.banDuration = banDuration;
    }

    public void report() {
    }

    public void updateTags(List<Tag> tags) {
        val currentTags = this.getArticleTags().stream()
                .collect(Collectors.toMap(ArticleTag::getTagId,
                        at -> at));
        val targetTags = tags.stream().collect(Collectors.toMap(Tag::getId,
                tag -> ArticleTag.builder()
                        .tagId(tag.getId())
                        .tagName(tag.getName())
                        .build()));

        currentTags.keySet().stream()
                .filter(tagId -> !targetTags.containsKey(tagId))
                .forEach(tagId -> this.articleTags.remove(currentTags.get(tagId)));
        targetTags.keySet().stream()
                .filter(tagId -> !currentTags.containsKey(tagId))
                .forEach(tagId -> this.articleTags.add(targetTags.get(tagId)));
    }

    public void updateCategory(List<Category> categories) {
        val currentCategories = this.getArticleCategories().stream()
                .collect(Collectors.toMap(ArticleCategory::getCategoryId,
                        ac -> ac));
        val targetCategories = categories.stream().collect(Collectors.toMap(Category::getId,
                category -> ArticleCategory.builder()
                        .categoryId(category.getId())
                        .categoryName(category.getName())
                        .build()));

        currentCategories.keySet().stream()
                .filter(categoryId -> !targetCategories.containsKey(categoryId))
                .forEach(categoryId -> this.articleCategories.remove(currentCategories.get(categoryId)));
        targetCategories.keySet().stream()
                .filter(categoryId -> !currentCategories.containsKey(categoryId))
                .forEach(categoryId -> this.articleCategories.add(targetCategories.get(categoryId)));

    }

    public void updateLikeCount(Integer likeCount) {
        this.getArticleStatistics().updateLikeCount(likeCount);
        events().attach(new ArticleLikeCountUpdatedDomainEvent(this), this);
    }

    public void updateFavoriteCount(Integer favoriteCount) {
        this.getArticleStatistics().updateFavoriteCount(favoriteCount);
        events().attach(new ArticleFavoriteCountUpdatedDomainEvent(this), this);
    }

    public void updateCommentCount(Integer commentCount) {
        this.getArticleStatistics().updateCommentCount(commentCount);
    }

    public void updateAuthorInfo(Long memberId, String memberName) {

        this.getArticleAuthors().stream()
                .filter(aa -> Objects.equals(aa.getId(), memberId))
                .findFirst()
                .orElseThrow(() -> new KnownException("不是作者, 无法修改"))
                .updateInfo(memberName);
    }

    public void updateTagInfo(Long tagId, String tagName) {
        this.getArticleTags().stream()
                .filter(at -> Objects.equals(at.getId(), tagId))
                .findFirst()
                .orElseThrow(() -> new KnownException("标签不存在"))
                .updateInfo(tagName);
    }

    public void updateCategoryInfo(Long categoryId, String categoryName) {
        this.getArticleCategories().stream()
                .filter(ac -> Objects.equals(ac.getId(), categoryId))
                .findFirst()
                .orElseThrow(() -> new KnownException("分类不存在"))
                .updateInfo(categoryName);
    }

    public void updateCommentFlag(Boolean commentFlag) {
        this.commentFlag = commentFlag;
    }

    public void updatePrice(Long price) {
        this.price = price;
    }

    public void updateSticky(Boolean sticky) {
        this.stickyFlag = sticky;
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
    @Getter(lombok.AccessLevel.PROTECTED)
    private java.util.List<com.only4.domain.aggregates.article.ArticleStatistics> articleStatistics;

    public com.only4.domain.aggregates.article.ArticleStatistics getArticleStatistics() {
        return articleStatistics == null || articleStatistics.size() == 0 ? null : articleStatistics.get(0);
    }

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`article_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.article.ArticleTag> articleTags;

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
     * varchar(255)
     */
    @Column(name = "`appendix`")
    String appendix;

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

    /**
     * 逻辑删除
     * tinyint(1)
     */
    @Column(name = "`del_flag`")
    Boolean delFlag;

    // 【字段映射结束】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动
}


