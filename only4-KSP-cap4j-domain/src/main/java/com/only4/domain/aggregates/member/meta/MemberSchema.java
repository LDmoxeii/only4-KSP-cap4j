package com.only4.domain.aggregates.member.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * 会员
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2024/12/15
 */
@RequiredArgsConstructor
public class MemberSchema {
    private final Path<Member> root;
    private final CriteriaBuilder criteriaBuilder;

    public CriteriaBuilder criteriaBuilder() {
        return criteriaBuilder;
    }

    /**
     * ID
     * bigint
     */
    public Schema.Field<Long> id() {
        return root == null ? new Schema.Field<>("id") : new Schema.Field<>(root.get("id"));
    }

    /**
     * 帐号
     * varchar(50)
     */
    public Schema.Field<String> name() {
        return root == null ? new Schema.Field<>("name") : new Schema.Field<>(root.get("name"));
    }

    /**
     * 密码
     * varchar(50)
     */
    public Schema.Field<String> password() {
        return root == null ? new Schema.Field<>("password") : new Schema.Field<>(root.get("password"));
    }

    /**
     * 手机号
     * varchar(20)
     */
    public Schema.Field<String> phone() {
        return root == null ? new Schema.Field<>("phone") : new Schema.Field<>(root.get("phone"));
    }

    /**
     * 昵称
     * varchar(255)
     */
    public Schema.Field<String> nickName() {
        return root == null ? new Schema.Field<>("nickName") : new Schema.Field<>(root.get("nickName"));
    }

    /**
     * 个性签名
     * varchar(255)
     */
    public Schema.Field<String> signature() {
        return root == null ? new Schema.Field<>("signature") : new Schema.Field<>(root.get("signature"));
    }

    /**
     * 等级
     * int
     */
    public Schema.Field<Integer> level() {
        return root == null ? new Schema.Field<>("level") : new Schema.Field<>(root.get("level"));
    }

    /**
     * 余额
     * bigint
     */
    public Schema.Field<Long> balance() {
        return root == null ? new Schema.Field<>("balance") : new Schema.Field<>(root.get("balance"));
    }

    /**
     * 封禁标识
     * tinyint(1)
     */
    public Schema.Field<Boolean> banFlag() {
        return root == null ? new Schema.Field<>("banFlag") : new Schema.Field<>(root.get("banFlag"));
    }

    /**
     * 封禁时间
     * timestamp
     */
    public Schema.Field<java.time.LocalDateTime> banTime() {
        return root == null ? new Schema.Field<>("banTime") : new Schema.Field<>(root.get("banTime"));
    }

    /**
     * 逻辑删除
     * tinyint(1)
     */
    public Schema.Field<Boolean> delFlag() {
        return root == null ? new Schema.Field<>("delFlag") : new Schema.Field<>(root.get("delFlag"));
    }


    /**
     * 满足所有条件
     * @param restrictions
     * @return
     */
    public Predicate all(Predicate... restrictions) {
        return criteriaBuilder().and(restrictions);
    }

    /**
     * 满足任一条件
     * @param restrictions
     * @return
     */
    public Predicate any(Predicate... restrictions) {
        return criteriaBuilder().or(restrictions);
    }

    /**
     * 指定条件
     * @param builder
     * @return
     */
    public Predicate spec(Schema.PredicateBuilder<MemberSchema> builder){
        return builder.build(this);
    }

    /**
     * MemberLikeRecord 关联查询条件定义
     *
     * @param joinType
     * @return
     */
    public com.only4.domain.aggregates.member.meta.MemberLikeRecordSchema joinMemberLikeRecord(Schema.JoinType joinType) {
        JoinType type = joinType.toJpaJoinType();
        Join<Member, com.only4.domain.aggregates.member.MemberLikeRecord> join = ((Root<Member>) root).join("memberLikeRecords", type);
        com.only4.domain.aggregates.member.meta.MemberLikeRecordSchema schema = new com.only4.domain.aggregates.member.meta.MemberLikeRecordSchema(join, criteriaBuilder);
        return schema;
    }
    /**
     * MemberPermission 关联查询条件定义
     *
     * @param joinType
     * @return
     */
    public com.only4.domain.aggregates.member.meta.MemberPermissionSchema joinMemberPermission(Schema.JoinType joinType) {
        JoinType type = joinType.toJpaJoinType();
        Join<Member, com.only4.domain.aggregates.member.MemberPermission> join = ((Root<Member>) root).join("memberPermissions", type);
        com.only4.domain.aggregates.member.meta.MemberPermissionSchema schema = new com.only4.domain.aggregates.member.meta.MemberPermissionSchema(join, criteriaBuilder);
        return schema;
    }
    /**
     * ViewHistory 关联查询条件定义
     *
     * @param joinType
     * @return
     */
    public com.only4.domain.aggregates.member.meta.ViewHistorySchema joinViewHistory(Schema.JoinType joinType) {
        JoinType type = joinType.toJpaJoinType();
        Join<Member, com.only4.domain.aggregates.member.ViewHistory> join = ((Root<Member>) root).join("viewHistories", type);
        com.only4.domain.aggregates.member.meta.ViewHistorySchema schema = new com.only4.domain.aggregates.member.meta.ViewHistorySchema(join, criteriaBuilder);
        return schema;
    }
    /**
     * MemberStatistics 关联查询条件定义
     *
     * @param joinType
     * @return
     */
    public com.only4.domain.aggregates.member.meta.MemberStatisticsSchema joinMemberStatistics(Schema.JoinType joinType) {
        JoinType type = joinType.toJpaJoinType();
        Join<Member, com.only4.domain.aggregates.member.MemberStatistics> join = ((Root<Member>) root).join("memberStatistics", type);
        com.only4.domain.aggregates.member.meta.MemberStatisticsSchema schema = new com.only4.domain.aggregates.member.meta.MemberStatisticsSchema(join, criteriaBuilder);
        return schema;
    }
    /**
     * FollowMember 关联查询条件定义
     *
     * @param joinType
     * @return
     */
    public com.only4.domain.aggregates.member.meta.FollowMemberSchema joinFollowMember(Schema.JoinType joinType) {
        JoinType type = joinType.toJpaJoinType();
        Join<Member, com.only4.domain.aggregates.member.FollowMember> join = ((Root<Member>) root).join("followMembers", type);
        com.only4.domain.aggregates.member.meta.FollowMemberSchema schema = new com.only4.domain.aggregates.member.meta.FollowMemberSchema(join, criteriaBuilder);
        return schema;
    }
    /**
     * BlockMember 关联查询条件定义
     *
     * @param joinType
     * @return
     */
    public com.only4.domain.aggregates.member.meta.BlockMemberSchema joinBlockMember(Schema.JoinType joinType) {
        JoinType type = joinType.toJpaJoinType();
        Join<Member, com.only4.domain.aggregates.member.BlockMember> join = ((Root<Member>) root).join("blockMembers", type);
        com.only4.domain.aggregates.member.meta.BlockMemberSchema schema = new com.only4.domain.aggregates.member.meta.BlockMemberSchema(join, criteriaBuilder);
        return schema;
    }
    /**
     * MemberStar 关联查询条件定义
     *
     * @param joinType
     * @return
     */
    public com.only4.domain.aggregates.member.meta.MemberStarSchema joinMemberStar(Schema.JoinType joinType) {
        JoinType type = joinType.toJpaJoinType();
        Join<Member, com.only4.domain.aggregates.member.MemberStar> join = ((Root<Member>) root).join("memberStars", type);
        com.only4.domain.aggregates.member.meta.MemberStarSchema schema = new com.only4.domain.aggregates.member.meta.MemberStarSchema(join, criteriaBuilder);
        return schema;
    }
    /**
     * Favorite 关联查询条件定义
     *
     * @param joinType
     * @return
     */
    public com.only4.domain.aggregates.member.meta.FavoriteSchema joinFavorite(Schema.JoinType joinType) {
        JoinType type = joinType.toJpaJoinType();
        Join<Member, com.only4.domain.aggregates.member.Favorite> join = ((Root<Member>) root).join("favorites", type);
        com.only4.domain.aggregates.member.meta.FavoriteSchema schema = new com.only4.domain.aggregates.member.meta.FavoriteSchema(join, criteriaBuilder);
        return schema;
    }
    /**
     * SignInRecord 关联查询条件定义
     *
     * @param joinType
     * @return
     */
    public com.only4.domain.aggregates.member.meta.SignInRecordSchema joinSignInRecord(Schema.JoinType joinType) {
        JoinType type = joinType.toJpaJoinType();
        Join<Member, com.only4.domain.aggregates.member.SignInRecord> join = ((Root<Member>) root).join("signInRecords", type);
        com.only4.domain.aggregates.member.meta.SignInRecordSchema schema = new com.only4.domain.aggregates.member.meta.SignInRecordSchema(join, criteriaBuilder);
        return schema;
    }

    /**
     * 构建查询条件
     * @param builder
     * @param distinct
     * @return
     */
    public static Specification<Member> specify(Schema.PredicateBuilder<MemberSchema> builder, boolean distinct) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            MemberSchema member = new MemberSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(member));
            criteriaQuery.distinct(distinct);
            return null;
        };
    }
    
    /**
     * 构建查询条件
     * @param builder
     * @return
     */
    public static Specification<Member> specify(Schema.PredicateBuilder<MemberSchema> builder) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            MemberSchema member = new MemberSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(member));
            return null;
        };
    }
    
    /**
     * 构建排序
     * @param builders
     * @return
     */
    public static Sort orderBy(Schema.OrderBuilder<MemberSchema>... builders) {
        return orderBy(Arrays.asList(builders));
    }

    /**
     * 构建排序
     *
     * @param builders
     * @return
     */
    public static Sort orderBy(Collection<Schema.OrderBuilder<MemberSchema>> builders) {
        if(null == builders || builders.isEmpty()) {
            return Sort.unsorted();
        }
        return Sort.by(builders.stream()
                .map(builder -> builder.build(new MemberSchema(null, null)))
                .collect(Collectors.toList())
        );
    }

}
