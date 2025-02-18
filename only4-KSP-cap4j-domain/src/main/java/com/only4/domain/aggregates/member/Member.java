package com.only4.domain.aggregates.member;

import com.only4._share.exception.KnownException;
import com.only4.domain.aggregates.member.events.*;
import lombok.*;
import org.hibernate.annotations.*;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

import static org.netcorepal.cap4j.ddd.domain.event.DomainEventSupervisorSupport.events;

/**
 * 会员
 * <p>
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件的字段声明，重新生成会覆盖字段声明
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/15
 */
@Aggregate(aggregate = "Member", name = "Member", root = true, type = Aggregate.TYPE_ENTITY, description = "会员")
@Entity
@Table(name = "`member`")
@DynamicInsert
@DynamicUpdate
@SQLDelete(sql = "update `member` set `del_flag` = 1 where `id` = ? ")
@Where(clause = "`del_flag` = 0")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Member {

    // 【行为方法开始】
    public void registerWithPassword() {
        events().attach(new MemberRegisteredWithPasswordDomainEvent(this), this);
    }

    public void registerWithPhone() {
        events().attach(new MemberRegisteredWithPasswordDomainEvent(this), this);
    }

    public void updatePhone(String phone) {
        this.phone = phone;
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public void updateInfo(String nickName, String signature) {
        this.nickName = nickName;
        this.signature = signature;
        events().attach(new MemberInfoUpdatedDomainEvent(this), this);
    }

    public boolean hasLevel() {
        return this.getLevel() >= 0;
    }

    public void upLevel() {
        if (!hasLevel()) {
            throw new KnownException("用户未处于活跃状态, 无法获取等级分");
        }
        this.level++;
    }

    public void updateRank(Integer rank) {
        if (this.isActive()) {
            throw new KnownException("用户非活跃用户, 无法获取等级分");
        }

        val newRank = this.getMemberStatistics().updateRank(rank);
        events().attach(new MemberRankUpdatedDomainEvent(this, newRank), this);
    }

    private boolean isActive() {
        return this.level >= 0;
    }

    public boolean hasStardust() {
        return this.getMemberStatistics().stardustCount >= 0;
    }

    public void delete() {
        if (this.hasStardust()) {
            throw new KnownException("用户未遣散星尘, 无法删除");
        }
        this.delFlag = true;
    }

    public void report() {
        this.getMemberStatistics().updateReportCount(1);
    }

    public void updateLikeCount(Integer likeCount) {
        this.getMemberStatistics().updateLikeCount(likeCount);
        events().attach(new MemberLikeCountUpdatedDomainEvent(this), this);
    }

    public void updateFanCount(Integer fanCount) {
        this.getMemberStatistics().updateFanCount(fanCount);
    }

    public void updateWorkCount(Integer workCount) {
        this.getMemberStatistics().updateWorkCount(workCount);
        this.getMemberStatistics().workCount += workCount;
    }

    public void ban(Integer banDuration) {
        if (this.hasBanned()) {
            throw new KnownException("用户已处于封禁状态");
        }
        this.bannedAt = LocalDateTime.now();
        this.banDuration = banDuration;
    }

    private boolean hasBanned() {
        return this.banDuration != 0;
    }

    public void unban() {
        if (!this.hasBanned()) {
            throw new KnownException("用户未处于封禁状态");
        }
        this.banDuration = 0;
    }

    public void follow(Long otherId, String otherName) {
        if (this.hasFollowed(otherId)) {
            throw new KnownException("用户已关注过该用户");
        }
        this.getFollowMembers().add(FollowMember.builder()
                .followMemberId(otherId)
                .followMemberName(otherName)
                .build());
        events().attach(new MemberFollowedDomainEvent(this), this);
    }

    public boolean hasFollowed(Long otherId) {
        return this.getFollowMembers().stream()
                .anyMatch(followMember -> Objects.equals(followMember.getFollowMemberId(), otherId));
    }

    public void unfollow(Long otherId) {

        Optional.of(this.getFollowMembers().stream()
                        .filter(followMember -> Objects.equals(followMember.getFollowMemberId(), otherId))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("关注用户不存在")))
                .ifPresent(followMember -> {
                    this.getFollowMembers().remove(followMember);
                    events().attach(new MemberUnfollowedDomainEvent(this, otherId), this);
                });
    }

    public void createFavorites(String favoritesName, String favoritesDesc) {
        if (this.hasUniqueFavorites(favoritesName)) {
            throw new KnownException("该用户已有同名收藏夹");
        }
        this.getFavorites().add(Favorites.builder()
                .name(favoritesName)
                .description(favoritesDesc)
                .build());
    }

    public boolean hasUniqueFavorites(String favoritesName) {
        return this.getFavorites().stream()
                .anyMatch(favorites -> Objects.equals(favorites.getName(), favoritesName));
    }

    public void updateFavoritesInfo(Long favoritesId, String favoritesName, String favoritesDesc) {
        if (!this.hasUniqueFavorites(favoritesName)) {
            throw new KnownException("该用户已有同名收藏夹");
        }
        this.getFavorites().stream()
                .filter(favorites -> Objects.equals(favorites.getId(), favoritesId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("收藏夹不存在"))
                .updateInfo(favoritesName, favoritesDesc);
    }

    public boolean favoriteHasArticle(Long favoritesId, Long articleId) {
        return this.getFavorites().stream()
                .filter(favorites -> Objects.equals(favorites.getId(), favoritesId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("收藏夹不存在"))
                .hasArticle(articleId);
    }

    public void addArticleToFavorite(Long favoritesId, Long articleId) {
        Optional.ofNullable(this.getFavorites().stream()
                        .filter(favorites -> Objects.equals(favorites.getId(), favoritesId))
                        .findFirst()
                        .orElseThrow(() -> new KnownException("收藏夹不存在")))
                .ifPresent(favorites -> {
                    favorites.addArticle(articleId);
                    events().attach(new ArticleAddedToFavoritesDomainEvent(this, favoritesId), this);
                });
    }

    public void removeArticleFromFavorite(Long favoritesId, Long articleId) {
        Optional.ofNullable(this.getFavorites().stream()
                        .filter(favorites -> Objects.equals(favorites.getId(), favoritesId))
                        .findFirst()
                        .orElseThrow(() -> new KnownException("收藏夹不存在")))
                .ifPresent(favorites -> {
                    favorites.removeArticle(articleId);
                    events().attach(new ArticleRemovedFromFavoritesDomainEvent(this, favoritesId), this);
                });
    }

    public void deleteFavorites(Long favoritesId) {
        Optional.of(this.getFavorites().stream()
                        .filter(favorites -> Objects.equals(favorites.getId(), favoritesId))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("收藏夹不存在")))
                .ifPresent(favorites -> this.getFavorites().remove(favorites));
    }

    public void updateBlackInfo(Long otherId, String otherName) {
        if (this.hasBlocked(otherId)) {
            throw new KnownException("用户已屏蔽过该用户");
        }
        this.getBlockMembers().add(BlockMember.builder()
                .blockMemberId(otherId)
                .blockMemberName(otherName)
                .build());
    }

    public void updateFollowInfo(Long otherId, String otherName) {
        if (this.hasFollowed(otherId)) {
            throw new KnownException("用户已关注过该用户");
        }
        this.getFollowMembers().add(FollowMember.builder()
                .followMemberId(otherId)
                .followMemberName(otherName)
                .build());
    }

    public boolean hasBlocked(Long otherId) {
        return this.getBlockMembers().stream()
                .anyMatch(blockMember -> Objects.equals(blockMember.getBlockMemberId(), otherId));
    }

    public void updateFavoritesArticleCount(Long favoritesId, Integer articleCount) {
        Optional.of(this.getFavorites().stream()
                        .filter(favorites -> Objects.equals(favorites.getId(), favoritesId))
                        .findFirst()
                        .orElseThrow(() -> new KnownException("收藏夹不存在")))
                .ifPresent(favorites -> favorites.updateArticleCount(articleCount));
    }

    public void updateFollowingCount(Integer followingCount) {
        this.getMemberStatistics().updateFollowingCount(followingCount);
    }

    public void updateStardustCount(Integer stardustCount) {
        this.getMemberStatistics().updateStardustCount(stardustCount);
    }

    public void updateStarInfo(Long starId, String starName) {
        if (this.hasUniqueStar(starName)) {
            throw new KnownException("该用户已有同名星球");
        }

        this.getMemberStars().stream()
                .filter(memberStar -> Objects.equals(memberStar.getStarId(), starId))
                .findFirst()
                .orElseThrow(() -> new KnownException("该用户未拥有该星球"))
                .updateInfo(starName);
    }

    boolean hasUniqueStar(String starName) {
        return this.getMemberStars().stream()
                .anyMatch(memberStar -> Objects.equals(memberStar.getStarName(), starName));
    }

    public boolean validateRank() {
        return this.getMemberStatistics().validateRank();
    }

    public boolean validateLikeCount() {
        return this.getMemberStatistics().validateLikeCount();
    }

    public boolean validateFanCount() {
        return this.getMemberStatistics().validateFanCount();
    }

    public boolean validateReportCount() {
        return this.getMemberStatistics().validateReportCount();
    }

    public boolean validateFollowingCount() {
        return this.getMemberStatistics().validateFollowingCount();
    }

    public boolean validateWorkCount() {
        return this.getMemberStatistics().validateWorkCount();
    }

    public boolean validateFavoritesArticleCount() {
        return this.getFavorites()
                .stream().allMatch(Favorites::validateArticleCount);
    }

    // 【行为方法结束】


    // 【字段映射开始】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`member_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.member.Favorites> favorites;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`member_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.member.MemberPermission> memberPermissions;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`member_id`", nullable = false)
    @Getter(lombok.AccessLevel.PROTECTED)
    private java.util.List<com.only4.domain.aggregates.member.MemberStatistics> memberStatistics;

    public com.only4.domain.aggregates.member.MemberStatistics getMemberStatistics() {
        return memberStatistics == null || memberStatistics.size() == 0 ? null : memberStatistics.get(0);
    }

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`member_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.member.FollowMember> followMembers;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`member_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.member.BlockMember> blockMembers;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`member_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.member.MemberStar> memberStars;

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
     * 帐号
     * varchar(50)
     */
    @Column(name = "`name`")
    String name;

    /**
     * 密码
     * varchar(50)
     */
    @Column(name = "`password`")
    String password;

    /**
     * 手机号
     * varchar(20)
     */
    @Column(name = "`phone`")
    String phone;

    /**
     * 昵称
     * varchar(255)
     */
    @Column(name = "`nick_name`")
    String nickName;

    /**
     * 个性签名
     * varchar(255)
     */
    @Column(name = "`signature`")
    String signature;

    /**
     * 等级
     * int
     */
    @Column(name = "`level`")
    Integer level;

    /**
     * 余额
     * bigint
     */
    @Column(name = "`balance`")
    Long balance;

    /**
     * 封禁标识
     * tinyint(1)
     */
    @Column(name = "`ban_flag`")
    Boolean banFlag;

    /**
     * 封禁时间
     * timestamp
     */
    @Column(name = "`banned_at`")
    java.time.LocalDateTime bannedAt;

    /**
     * 封禁时长
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


