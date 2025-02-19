package com.only4.domain.aggregates.tag.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.tag.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 标签
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2025/02/19
 */
@RequiredArgsConstructor
public class TagSchema {
    /**
     * 属性字段集合
     */
    public static class PROPERTY_NAMES {

        /**
         * ID
         */
        public static final String id = "id";

        /**
         * 标签名
         */
        public static final String name = "name";

        /**
         * 标签描述
         */
        public static final String description = "description";

        /**
         * 标签图标
         */
        public static final String icon = "icon";

        /**
         * 引用次数
         */
        public static final String refCount = "refCount";

        /**
         * 逻辑删除
         */
        public static final String delFlag = "delFlag";

    }

    private final Path<Tag> root;
    private final CriteriaBuilder criteriaBuilder;

    public CriteriaBuilder _criteriaBuilder() {
        return criteriaBuilder;
    }

    public Path<Tag> _root() {
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
     * 标签名
     * varchar(50)
     */
    public Schema.Field<String> name() {
        return new Schema.Field<>(root.get("name"), this.criteriaBuilder);
    }

    /**
     * 标签描述
     * varchar(255)
     */
    public Schema.Field<String> description() {
        return new Schema.Field<>(root.get("description"), this.criteriaBuilder);
    }

    /**
     * 标签图标
     * varchar(50)
     */
    public Schema.Field<String> icon() {
        return new Schema.Field<>(root.get("icon"), this.criteriaBuilder);
    }

    /**
     * 引用次数
     * int
     */
    public Schema.Field<Integer> refCount() {
        return new Schema.Field<>(root.get("refCount"), this.criteriaBuilder);
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
    public Predicate spec(Schema.PredicateBuilder<TagSchema> builder){
        return builder.build(this);
    }


    /**
     * 构建查询条件
     *
     * @param builder where条件构造器
     * @return
     */
    public static Specification<Tag> specify(Schema.PredicateBuilder<TagSchema> builder) {
        return specify(builder, false, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder  where条件构造器
     * @param distinct 是否去重
     * @return
     */
    public static Specification<Tag> specify(Schema.PredicateBuilder<TagSchema> builder, boolean distinct) {
        return specify(builder, distinct, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<Tag> specify(Schema.PredicateBuilder<TagSchema> builder, Schema.OrderBuilder<TagSchema>... orderBuilders) {
        return specify(builder, Arrays.asList(orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<Tag> specify(Schema.PredicateBuilder<TagSchema> builder, List<Schema.OrderBuilder<TagSchema>> orderBuilders) {
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
    public static Specification<Tag> specify(Schema.PredicateBuilder<TagSchema> builder, boolean distinct, Schema.OrderBuilder<TagSchema>... orderBuilders) {
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
    public static Specification<Tag> specify(Schema.PredicateBuilder<TagSchema> builder, boolean distinct, List<Schema.OrderBuilder<TagSchema>> orderBuilders) {
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
    public static Specification<Tag> specify(Schema.Specification<Tag, TagSchema> specifier) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            TagSchema tag = new TagSchema(root, criteriaBuilder);
            return specifier.toPredicate(tag, criteriaQuery);
        };
    }

    /**
     * 构建查询条件
     *
     * @param id 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Tag> predicateById(Object id) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byId(Tag.class, id);
    }

    /**
     * 构建查询条件
     *
     * @param ids 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Tag> predicateByIds(Collection<Object> ids) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byIds(Tag.class, ids);
    }

    /**
     * 构建查询条件
     *
     * @param ids 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Tag> predicateByIds(Object... ids) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byIds(Tag.class, Arrays.asList(ids));
    }

    /**
     * 构建查询条件
     *
     * @param builder 查询条件构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Tag> predicate(Schema.PredicateBuilder<TagSchema> builder) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Tag.class, specify(builder));
    }

    /**
     * 构建查询条件
     *
     * @param builder  查询条件构造器
     * @param distinct 是否去重
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Tag> predicate(Schema.PredicateBuilder<TagSchema> builder, boolean distinct) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Tag.class, specify(builder, distinct));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Tag> predicate(Schema.PredicateBuilder<TagSchema> builder, List<Schema.OrderBuilder<TagSchema>> orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Tag.class, specify(builder, false, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Tag> predicate(Schema.PredicateBuilder<TagSchema> builder, Schema.OrderBuilder<TagSchema>... orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Tag.class, specify(builder, false, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param distinct      是否去重
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Tag> predicate(Schema.PredicateBuilder<TagSchema> builder, boolean distinct, List<Schema.OrderBuilder<TagSchema>> orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Tag.class, specify(builder, distinct, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param distinct      是否去重
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Tag> predicate(Schema.PredicateBuilder<TagSchema> builder, boolean distinct, Schema.OrderBuilder<TagSchema>... orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Tag.class, specify(builder, distinct, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param specifier 查询条件构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Tag> predicate(Schema.Specification<Tag, TagSchema> specifier) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Tag.class, specify(specifier));
    }
}
