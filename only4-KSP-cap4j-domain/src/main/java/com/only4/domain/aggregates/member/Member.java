package com.only4.domain.aggregates.member;

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


    // 【行为方法结束】


    // 【字段映射开始】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`member_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.member.MemberLikeRecord> memberLikeRecords;

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`member_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.member.MemberPermission> memberPermissions;

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`member_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.member.ViewHistory> viewHistories;

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`member_id`", nullable = false)
    @Getter(lombok.AccessLevel.PROTECTED)
    private java.util.List<com.only4.domain.aggregates.member.MemberStatistics> memberStatistics;

    public com.only4.domain.aggregates.member.MemberStatistics getMemberStatistics() {
        return memberStatistics == null || memberStatistics.size() == 0 ? null : memberStatistics.get(0);
    }

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`member_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.member.FollowMember> followMembers;

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`member_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.member.BlockMember> blockMembers;

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`member_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.member.MemberStar> memberStars;

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`member_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.member.Favorite> favorites;

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`member_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.member.SignInRecord> signInRecords;

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
     * tinyint
     */
    @Column(name = "`level`")
    Byte level;

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
    @Column(name = "`ban_time`")
    java.time.LocalDateTime banTime;

    /**
     * 逻辑删除
     * tinyint(1)
     */
    @Column(name = "`del_flag`")
    Boolean delFlag;

    // 【字段映射结束】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动
}


