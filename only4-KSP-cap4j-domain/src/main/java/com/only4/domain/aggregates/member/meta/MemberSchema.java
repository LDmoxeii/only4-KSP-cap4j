package com.only4.domain.aggregates.member.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 会员
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2025/02/21
 */
@RequiredArgsConstructor
public class MemberSchema {
    /**
     * 属性字段集合
     */
    public static class PROPERTY_NAMES {
        
        /**
         * ID
         */
        public static final String id = "id";

        /**
         * 帐号
         */
        public static final String name = "name";

        /**
         * 密码
         */
        public static final String password = "password";

        /**
         * 手机号
         */
        public static final String phone = "phone";

        /**
         * 昵称
         */
        public static final String nickName = "nickName";

        /**
         * 个性签名
         */
        public static final String signature = "signature";

        /**
         * 等级
         */
        public static final String level = "level";

        /**
         * 余额
         */
        public static final String balance = "balance";

        /**
         * 封禁标识
         */
        public static final String banFlag = "banFlag";

        /**
         * 封禁时间
         */
        public static final String bannedAt = "bannedAt";

        /**
         * 封禁时长
         */
        public static final String banDuration = "banDuration";

        /**
         * 逻辑删除
         */
        public static final String delFlag = "delFlag";

    }

    private final Path<Member> root;
    private final CriteriaBuilder criteriaBuilder;

    public CriteriaBuilder _criteriaBuilder() {
        return criteriaBuilder;
    }

    public Path<Member> _root() {
        return root;
    }


    /**
     * ID
     * bigint
     */
    public Schema.Field<Long> id() {
        return new Schema.Field<>(root.get("id"), this.criteriaBuilder);
    }

    /**
     * 帐号
     * varchar(50)
     */
    public Schema.Field<String> name() {
        return new Schema.Field<>(root.get("name"), this.criteriaBuilder);
    }

    /**
     * 密码
     * varchar(50)
     */
    public Schema.Field<String> password() {
        return new Schema.Field<>(root.get("password"), this.criteriaBuilder);
    }

    /**
     * 手机号
     * varchar(20)
     */
    public Schema.Field<String> phone() {
        return new Schema.Field<>(root.get("phone"), this.criteriaBuilder);
    }

    /**
     * 昵称
     * varchar(255)
     */
    public Schema.Field<String> nickName() {
        return new Schema.Field<>(root.get("nickName"), this.criteriaBuilder);
    }

    /**
     * 个性签名
     * varchar(255)
     */
    public Schema.Field<String> signature() {
        return new Schema.Field<>(root.get("signature"), this.criteriaBuilder);
    }

    /**
     * 等级
     * int
     */
    public Schema.Field<Integer> level() {
        return new Schema.Field<>(root.get("level"), this.criteriaBuilder);
    }

    /**
     * 余额
     * bigint
     */
    public Schema.Field<Long> balance() {
        return new Schema.Field<>(root.get("balance"), this.criteriaBuilder);
    }

    /**
     * 封禁标识
     * tinyint(1)
     */
    public Schema.Field<Boolean> banFlag() {
        return new Schema.Field<>(root.get("banFlag"), this.criteriaBuilder);
    }

    /**
     * 封禁时间
     * timestamp
     */
    public Schema.Field<java.time.LocalDateTime> bannedAt() {
        return new Schema.Field<>(root.get("bannedAt"), this.criteriaBuilder);
    }

    /**
     * 封禁时长
     * int
     */
    public Schema.Field<Integer> banDuration() {
        return new Schema.Field<>(root.get("banDuration"), this.criteriaBuilder);
    }

    /**
     * 逻辑删除
     * tinyint(1)
     */
    public Schema.Field<Boolean> delFlag() {
        return new Schema.Field<>(root.get("delFlag"), this.criteriaBuilder);
    }


    /**
     * 满足所有条件
     * @param restrictions
     * @return
     */
    public Predicate all(Predicate... restrictions) {
        return this.criteriaBuilder.and(restrictions);
    }

    /**
     * 满足任一条件
     * @param restrictions
     * @return
     */
    public Predicate any(Predicate... restrictions) {
        return this.criteriaBuilder.or(restrictions);
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
     * Favorites 关联查询条件定义
     *
     * @param joinType
     * @return
     */
    public com.only4.domain.aggregates.member.meta.FavoritesSchema joinFavorites(Schema.JoinType joinType) {
        JoinType type = joinType.toJpaJoinType();
        Join<Member, com.only4.domain.aggregates.member.Favorites> join = ((Root<Member>) this.root).join("favorites", type);
        com.only4.domain.aggregates.member.meta.FavoritesSchema schema = new com.only4.domain.aggregates.member.meta.FavoritesSchema(join, this.criteriaBuilder);
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
        Join<Member, com.only4.domain.aggregates.member.MemberStatistics> join = ((Root<Member>) this.root).join("memberStatistics", type);
        com.only4.domain.aggregates.member.meta.MemberStatisticsSchema schema = new com.only4.domain.aggregates.member.meta.MemberStatisticsSchema(join, this.criteriaBuilder);
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
        Join<Member, com.only4.domain.aggregates.member.FollowMember> join = ((Root<Member>) this.root).join("followMembers", type);
        com.only4.domain.aggregates.member.meta.FollowMemberSchema schema = new com.only4.domain.aggregates.member.meta.FollowMemberSchema(join, this.criteriaBuilder);
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
        Join<Member, com.only4.domain.aggregates.member.BlockMember> join = ((Root<Member>) this.root).join("blockMembers", type);
        com.only4.domain.aggregates.member.meta.BlockMemberSchema schema = new com.only4.domain.aggregates.member.meta.BlockMemberSchema(join, this.criteriaBuilder);
        return schema;
    }

    /**
     * 构建查询条件
     *
     * @param builder where条件构造器
     * @return
     */
    public static Specification<Member> specify(Schema.PredicateBuilder<MemberSchema> builder) {
        return specify(builder, false, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder  where条件构造器
     * @param distinct 是否去重
     * @return
     */
    public static Specification<Member> specify(Schema.PredicateBuilder<MemberSchema> builder, boolean distinct) {
        return specify(builder, distinct, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<Member> specify(Schema.PredicateBuilder<MemberSchema> builder, Schema.OrderBuilder<MemberSchema>... orderBuilders) {
        return specify(builder, Arrays.asList(orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<Member> specify(Schema.PredicateBuilder<MemberSchema> builder, List<Schema.OrderBuilder<MemberSchema>> orderBuilders) {
        return specify(builder, orderBuilders);
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param distinct      是否去重
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<Member> specify(Schema.PredicateBuilder<MemberSchema> builder, boolean distinct, Schema.OrderBuilder<MemberSchema>... orderBuilders) {
        return specify(builder, distinct, Arrays.asList(orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param distinct      是否去重
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<Member> specify(Schema.PredicateBuilder<MemberSchema> builder, boolean distinct, List<Schema.OrderBuilder<MemberSchema>> orderBuilders) {
        return specify((schema, criteriaQuery) -> {
            criteriaQuery.where(builder.build(schema));
            criteriaQuery.distinct(distinct);
            if (orderBuilders != null && !orderBuilders.isEmpty()) {
                criteriaQuery.orderBy(orderBuilders.stream()
                        .map(b -> b.build(schema))
                        .collect(Collectors.toList())
                );
            }
            return null;
        });
    }

    /**
     * 构建查询条件
     *
     * @param specifier 查询条件构造器
     * @return
     */
    public static Specification<Member> specify(Schema.Specification<Member, MemberSchema> specifier) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            MemberSchema member = new MemberSchema(root, criteriaBuilder);
            return specifier.toPredicate(member, criteriaQuery);
        };
    }

    /**
     * 构建查询条件
     *
     * @param id 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Member> predicateById(Object id) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byId(Member.class, id);
    }

    /**
     * 构建查询条件
     *
     * @param ids 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Member> predicateByIds(Collection<Object> ids) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byIds(Member.class, ids);
    }

    /**
     * 构建查询条件
     *
     * @param ids 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Member> predicateByIds(Object... ids) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byIds(Member.class, Arrays.asList(ids));
    }

    /**
     * 构建查询条件
     *
     * @param builder 查询条件构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Member> predicate(Schema.PredicateBuilder<MemberSchema> builder) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Member.class, specify(builder));
    }

    /**
     * 构建查询条件
     *
     * @param builder  查询条件构造器
     * @param distinct 是否去重
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Member> predicate(Schema.PredicateBuilder<MemberSchema> builder, boolean distinct) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Member.class, specify(builder, distinct));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Member> predicate(Schema.PredicateBuilder<MemberSchema> builder, List<Schema.OrderBuilder<MemberSchema>> orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Member.class, specify(builder, false, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Member> predicate(Schema.PredicateBuilder<MemberSchema> builder, Schema.OrderBuilder<MemberSchema>... orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Member.class, specify(builder, false, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param distinct      是否去重
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Member> predicate(Schema.PredicateBuilder<MemberSchema> builder, boolean distinct, List<Schema.OrderBuilder<MemberSchema>> orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Member.class, specify(builder, distinct, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param distinct      是否去重
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Member> predicate(Schema.PredicateBuilder<MemberSchema> builder, boolean distinct, Schema.OrderBuilder<MemberSchema>... orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Member.class, specify(builder, distinct, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param specifier 查询条件构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Member> predicate(Schema.Specification<Member, MemberSchema> specifier) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Member.class, specify(specifier));
    }
}
