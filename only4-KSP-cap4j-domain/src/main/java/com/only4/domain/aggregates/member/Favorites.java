package com.only4.domain.aggregates.member;

import com.only4.common.exception.KnownException;
import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

import java.util.Objects;
import java.util.Optional;

/**
 * 会员收藏夹
 * <p>
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件的字段声明，重新生成会覆盖字段声明
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/18
 */
@Aggregate(aggregate = "Member", name = "Favorites", root = false, type = Aggregate.TYPE_ENTITY, relevant = { "Member" }, description = "会员收藏夹")
@Entity
@Table(name = "`favorites`")
@DynamicInsert
@DynamicUpdate
@SQLDelete(sql = "update `favorites` set `del_flag` = 1 where `id` = ? ")
@Where(clause = "`del_flag` = 0")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Favorites {

    // 【行为方法开始】

    void updateInfo(String favoritesName, String favoritesDesc) {
        if (this.isDef()) {
            throw new KnownException("默认收藏夹不能修改");
        }

        this.name = favoritesName;
        this.description = favoritesDesc;
    }

    boolean isDef() {
        return this.delFlag;
    }

    Boolean hasArticle(Long articleId) {
        return this.getFavoritesArticles().stream()
                .anyMatch(articleFavoriteRecord ->
                        Objects.equals(articleFavoriteRecord.getArticleId(), articleId));
    }

    void addArticle(Long articleId) {
        if (this.hasArticle(articleId)) {
            throw new KnownException("该收藏夹已收藏该文章");
        }
        this.getFavoritesArticles().add(FavoritesArticle.builder()
                .articleId(articleId)
                .createAt(java.time.LocalDateTime.now())
                .build());
    }

    void removeArticle(Long articleId) {
        Optional.of(this.getFavoritesArticles().stream()
                        .filter(favoriteArticle -> Objects.equals(favoriteArticle.getArticleId(), articleId))
                        .findFirst()
                        .orElseThrow(() -> new KnownException("文章收藏记录不存在")))
                .ifPresent(favoritesArticle -> this.getFavoritesArticles().remove(favoritesArticle));
    }

    void updateArticleCount(Integer articleCount) {
        this.getFavoritesStatistics().updateArticleCount(articleCount);
    }

    boolean validateArticleCount() {
        return this.getFavoritesStatistics().validateArticleCount();
    }

    // 【行为方法结束】


    // 【字段映射开始】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`favorites_id`", nullable = false)
    @Getter(lombok.AccessLevel.PROTECTED)
    private java.util.List<com.only4.domain.aggregates.member.FavoritesStatistics> favoritesStatistics;

    public com.only4.domain.aggregates.member.FavoritesStatistics getFavoritesStatistics() {
        return favoritesStatistics == null || favoritesStatistics.size() == 0 ? null : favoritesStatistics.get(0);
    }

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`favorites_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.member.FavoritesArticle> favoritesArticles;

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
     * 收藏夹名
     * varchar(50)
     */
    @Column(name = "`name`")
    String name;

    /**
     * 描述
     * varchar(255)
     */
    @Column(name = "`description`")
    String description;

    /**
     * 默认标识
     * tinyint(1)
     */
    @Column(name = "`default_flag`")
    Boolean defaultFlag;

    /**
     * 逻辑删除
     * tinyint(1)
     */
    @Column(name = "`del_flag`")
    Boolean delFlag;

    // 【字段映射结束】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动
}


