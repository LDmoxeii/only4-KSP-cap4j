package com.only4.domain.aggregates.member;

import com.only4.domain.aggregates.member.enums.RankGetWay;
import com.only4.domain.aggregates.member.events.*;
import lombok.*;
import org.hibernate.annotations.*;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    public Boolean isCheckIn() {
        return this.getCheckInRecords().stream()
                .anyMatch(cr ->
                        cr.getCreateAt().toLocalDate().equals(LocalDate.now())
                );
    }

    public void checkIn() {
        this.getCheckInRecords().add(CheckInRecord.builder()
                .createAt(LocalDateTime.now())
                .build());
        events().attach(new MemberCheckedInDomainEvent(this), this);
    }

    public Boolean hasLevel() {
        return this.getLevel() >= 0;
    }

    public void updateRank(Integer rank) {
        this.getMemberStatistics().rank += rank;
        events().attach(new MemberRankUpdatedDomainEvent(this), this);
    }

    public Boolean hasStardust() {
        return this.getMemberStatistics().stardustCount >= 0;
    }

    public void delete() {
        this.delFlag = true;
    }

    public void report() {
        this.getMemberStatistics().reportCount += 1;
    }

    public void levelUp() {
        val currentLevel = this.getLevel(); // 获取当前等级
        val rank = this.getMemberStatistics().rank; // 获取当前 rank 值

        // 定义每个等级对应的晋升 rank 要求
        Map<Integer, Integer> rankRequirements = new HashMap<>();
        rankRequirements.put(1, 233);
        rankRequirements.put(2, 3306);
        rankRequirements.put(3, 8848);
        rankRequirements.put(4, 50000);
        rankRequirements.put(5, 66666);

        // 检查是否能够晋升
        if (rankRequirements.containsKey(currentLevel) && rank >= rankRequirements.get(currentLevel)) {
            this.level = currentLevel + 1; // 提升等级
        }
    }

    public void updateLikeCount(@Positive Integer likeCount) {
        this.getMemberStatistics().likeCount += likeCount;
        events().attach(new MemberLikeCountUpdatedDomainEvent(this), this);
    }

    public void updateFanCount(Integer fanCount) {
        this.getMemberStatistics().fanCount += fanCount;
    }

    public void updateWorkCount(Integer workCount) {
        this.getMemberStatistics().workCount += workCount;
    }

    public void ban(Integer banDuration) {
        this.bannedAt = LocalDateTime.now();
        this.banDuration = banDuration;
    }

    public void unban() {
        this.banDuration = 0;
    }

    public void follow(Long otherId, String otherName) {
        this.getFollowMembers().add(FollowMember.builder()
                .followMemberId(otherId)
                .followMemberName(otherName)
                .build());
        events().attach(new MemberFollowedDomainEvent(this), this);
    }

    public void unfollow(Long otherId) {
        this.getFollowMembers()
                .removeIf(followMember -> followMember.getFollowMemberId().equals(otherId));
        events().attach(new MemberUnfollowedDomainEvent(this), this);
    }

    public void createFavorites(String favoritesName, String favoritesDesc) {
        this.getFavorites().add(Favorite.builder()
                .name(favoritesName)
                .description(favoritesDesc)
                .build());
    }

    public void updateFavoritesInfo(Long favoritesId, String favoritesName, String favoritesDesc) {
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
        this.getFavorites().stream()
                .filter(favorites -> Objects.equals(favorites.getId(), favoritesId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("收藏夹不存在"))
                .addArticle(articleId);
    }

    public void removeArticleFromFavorite(Long favoritesId, Long articleId) {
        this.getFavorites().stream()
                .filter(favorites -> Objects.equals(favorites.getId(), favoritesId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("收藏夹不存在"))
                .removeArticle(articleId);
    }

    public void deleteFavorites(Long favoritesId) {
        this.getFavorites()
                .removeIf(favorites -> Objects.equals(favorites.getId(), favoritesId));
    }

    public void addViewHistory(Long articleId) {
        this.getViewHistories().add(ViewHistory.builder()
                .articleId(articleId)
                .build());
    }

    public void calculateRank(RankGetWay rankGetWay) {
        switch (rankGetWay) {
            case CHECK_IN:
                if (this.getCheckInRecords().stream().anyMatch(checkInRecord ->
                        checkInRecord.getCreateAt().toLocalDate().equals(LocalDate.now())
                )) {
                    this.updateRank(50);
                }
                break;
            case LIKE_ARTICLE:
                break;
            case COLLECT_ARTICLE:
                this.updateRank(3);
                break;
            case COMMENT_ARTICLE:
                this.updateRank(4);
                break;
            case LIKE_PLANET:
                this.updateRank(5);
                break;
        }
    }

    // 【行为方法结束】


    // 【字段映射开始】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`member_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.member.MemberLikeRecord> memberLikeRecords;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`member_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.member.MemberPermission> memberPermissions;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`member_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.member.ViewHistory> viewHistories;

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

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`member_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.member.CheckInRecord> checkInRecords;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`member_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.member.Favorite> favorites;

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


