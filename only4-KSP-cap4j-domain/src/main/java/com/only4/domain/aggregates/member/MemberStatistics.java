package com.only4.domain.aggregates.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * 会员统计
 * <p>
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件的字段声明，重新生成会覆盖字段声明
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/15
 */
@Aggregate(aggregate = "Member", name = "MemberStatistics", root = false, type = Aggregate.TYPE_ENTITY, relevant = { "Member" }, description = "会员统计")
@Entity
@Table(name = "`member_statistics`")
@DynamicInsert
@DynamicUpdate
@SQLDelete(sql = "update `member_statistics` set `del_flag` = 1 where `id` = ? ")
@Where(clause = "`del_flag` = 0")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class MemberStatistics {

    // 【行为方法开始】
    void updateReportCount(Integer reportCount) {
        this.reportCount += reportCount;
    }

    void updateFanCount(Integer fanCount) {
        this.fanCount += fanCount;
    }

    void updateLikeCount(@Positive Integer likeCount) {
        this.likeCount += likeCount;
    }

    Integer updateRank(Integer rank) {
        this.rank += rank;
        return this.rank;
    }

    void updateWorkCount(Integer workCount) {
        this.workCount += workCount;
    }

    void updateFollowingCount(Integer followingCount) {
        this.followingCount += followingCount;
    }

    public void updateViewCount(@NotNull Integer viewCount) {
        this.viewCount = this.getViewCount() + viewCount;
    }

    boolean validateRank() {
        return this.rank > 0;
    }

    boolean validateLikeCount() {
        return this.likeCount > 0;
    }

    boolean validateFanCount() {
        return this.fanCount > 0;
    }

    boolean validateReportCount() {
        return this.reportCount > 0;
    }

    boolean validateFollowingCount() {
        return this.followingCount > 0;
    }

    boolean validateWorkCount() {
        return this.workCount > 0;
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
     * 等级分
     * int
     */
    @Column(name = "`rank`")
    Integer rank;

    /**
     * 点赞数
     * int
     */
    @Column(name = "`like_count`")
    Integer likeCount;

    /**
     * 粉丝数
     * int
     */
    @Column(name = "`fan_count`")
    Integer fanCount;

    /**
     * 举报数
     * int
     */
    @Column(name = "`report_count`")
    Integer reportCount;

    /**
     * 关注数
     * int
     */
    @Column(name = "`following_count`")
    Integer followingCount;

    /**
     * 作品数
     * int
     */
    @Column(name = "`work_count`")
    Integer workCount;

    /**
     * 播放量
     * int
     */
    @Column(name = "`view_count`")
    Integer viewCount;

    /**
     * 逻辑删除
     * tinyint(1)
     */
    @Column(name = "`del_flag`")
    Boolean delFlag;

    /**
     * 星尘数
     * int
     */
    @Column(name = "`stardust_count`")
    Integer stardustCount;

    // 【字段映射结束】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动
}


