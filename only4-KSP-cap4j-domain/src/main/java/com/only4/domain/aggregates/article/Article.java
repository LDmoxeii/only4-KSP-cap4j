package com.only4.domain.aggregates.article;

import com.only4.domain.aggregates.article.enums.ArticleState;
import com.only4.domain.aggregates.article.events.CreatedArticleDomainEvent;
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
        events().attach(new CreatedArticleDomainEvent(this), this);
    }

    public void privatization() {
        this.state = ArticleState.PRIVATE;
    }

    public void publish() {
        this.state = ArticleState.PUBLISH;
    }

    public void changeArticleInfo(String newTitle, String newDescription) {
        this.title = newTitle;
        this.description = newDescription;
    }

    public void ban() {
        this.state = ArticleState.BANNED;
    }

    public void updateArticleLikes(Long num) {
        this.getArticleStatistics().likes = num;
    }

    public void updateArticleFavorites(Integer num) {
        this.getArticleStatistics().favorites = num;
    }

    public void createArticleCommon(ArticleComment newComment) {
        this.articleComments.add(newComment);
    }

    public void deleteArticleCommon(Long commentId) {
        this.getArticleComments().stream()
                .filter(c -> Objects.equals(c.getId(), commentId))
                .findFirst()
                .ifPresent(comment -> this.getArticleComments().remove(comment));
    }

    public void likeArticleComment(ArticleLike newArticleLike) {
        this.getArticleLikes().add(newArticleLike);
    }

    public void unLikeArticleComment(Long articleLikeId) {
        this.getArticleLikes().stream()
                .filter(l -> Objects.equals(l.getId(), articleLikeId))
                .findFirst()
                .ifPresent(like -> this.getArticleLikes().remove(like));
    }

    /**
     * 暂未设计
     *
     */
    public void reportArticleComment() {
       throw new UnsupportedOperationException("未实现");
    }

    public void deleteArmticle() {
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
     * int
     */
    @Convert(converter = com.only4.domain.aggregates.article.enums.ArticleState.Converter.class)
    @Column(name = "`state`")
    com.only4.domain.aggregates.article.enums.ArticleState state;

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

    // 【字段映射结束】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动
}


