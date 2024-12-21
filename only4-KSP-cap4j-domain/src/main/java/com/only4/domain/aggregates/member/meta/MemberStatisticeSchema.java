package com.only4.domain.aggregates.member.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.member.MemberStatistice;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * 会员统计
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2024/12/15
 */
@RequiredArgsConstructor
public class MemberStatisticeSchema {
    private final Path<MemberStatistice> root;
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
     * 等级分
     * int
     */
    public Schema.Field<Integer> rank() {
        return root == null ? new Schema.Field<>("rank") : new Schema.Field<>(root.get("rank"));
    }

    /**
     * 点赞数
     * int
     */
    public Schema.Field<Integer> likes() {
        return root == null ? new Schema.Field<>("likes") : new Schema.Field<>(root.get("likes"));
    }

    /**
     * 粉丝数
     * int
     */
    public Schema.Field<Integer> fans() {
        return root == null ? new Schema.Field<>("fans") : new Schema.Field<>(root.get("fans"));
    }

    /**
     * 举报数
     * int
     */
    public Schema.Field<Integer> reports() {
        return root == null ? new Schema.Field<>("reports") : new Schema.Field<>(root.get("reports"));
    }

    /**
     * 关注数
     * int
     */
    public Schema.Field<Integer> followings() {
        return root == null ? new Schema.Field<>("followings") : new Schema.Field<>(root.get("followings"));
    }

    /**
     * 作品数
     * int
     */
    public Schema.Field<Integer> works() {
        return root == null ? new Schema.Field<>("works") : new Schema.Field<>(root.get("works"));
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
    public Predicate spec(Schema.PredicateBuilder<MemberStatisticeSchema> builder){
        return builder.build(this);
    }


    /**
     * 构建查询条件
     * @param builder
     * @param distinct
     * @return
     */
    public static Specification<MemberStatistice> specify(Schema.PredicateBuilder<MemberStatisticeSchema> builder, boolean distinct) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            MemberStatisticeSchema memberStatistice = new MemberStatisticeSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(memberStatistice));
            criteriaQuery.distinct(distinct);
            return null;
        };
    }
    
    /**
     * 构建查询条件
     * @param builder
     * @return
     */
    public static Specification<MemberStatistice> specify(Schema.PredicateBuilder<MemberStatisticeSchema> builder) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            MemberStatisticeSchema memberStatistice = new MemberStatisticeSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(memberStatistice));
            return null;
        };
    }
    
    /**
     * 构建排序
     * @param builders
     * @return
     */
    public static Sort orderBy(Schema.OrderBuilder<MemberStatisticeSchema>... builders) {
        return orderBy(Arrays.asList(builders));
    }

    /**
     * 构建排序
     *
     * @param builders
     * @return
     */
    public static Sort orderBy(Collection<Schema.OrderBuilder<MemberStatisticeSchema>> builders) {
        if(null == builders || builders.isEmpty()) {
            return Sort.unsorted();
        }
        return Sort.by(builders.stream()
                .map(builder -> builder.build(new MemberStatisticeSchema(null, null)))
                .collect(Collectors.toList())
        );
    }

}
