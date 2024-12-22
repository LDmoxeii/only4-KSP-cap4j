package com.only4.domain.aggregates.tag.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.tag.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * 标签
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2024/12/15
 */
@RequiredArgsConstructor
public class TagSchema {
    private final Path<Tag> root;
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
     * 标签名
     * varchar(50)
     */
    public Schema.Field<String> name() {
        return root == null ? new Schema.Field<>("name") : new Schema.Field<>(root.get("name"));
    }

    /**
     * 标签描述
     * varchar(255)
     */
    public Schema.Field<String> description() {
        return root == null ? new Schema.Field<>("description") : new Schema.Field<>(root.get("description"));
    }

    /**
     * 标签图标
     * varchar(50)
     */
    public Schema.Field<String> icon() {
        return root == null ? new Schema.Field<>("icon") : new Schema.Field<>(root.get("icon"));
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
    public Predicate spec(Schema.PredicateBuilder<TagSchema> builder){
        return builder.build(this);
    }


    /**
     * 构建查询条件
     * @param builder
     * @param distinct
     * @return
     */
    public static Specification<Tag> specify(Schema.PredicateBuilder<TagSchema> builder, boolean distinct) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            TagSchema tag = new TagSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(tag));
            criteriaQuery.distinct(distinct);
            return null;
        };
    }
    
    /**
     * 构建查询条件
     * @param builder
     * @return
     */
    public static Specification<Tag> specify(Schema.PredicateBuilder<TagSchema> builder) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            TagSchema tag = new TagSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(tag));
            return null;
        };
    }
    
    /**
     * 构建排序
     * @param builders
     * @return
     */
    public static Sort orderBy(Schema.OrderBuilder<TagSchema>... builders) {
        return orderBy(Arrays.asList(builders));
    }

    /**
     * 构建排序
     *
     * @param builders
     * @return
     */
    public static Sort orderBy(Collection<Schema.OrderBuilder<TagSchema>> builders) {
        if(null == builders || builders.isEmpty()) {
            return Sort.unsorted();
        }
        return Sort.by(builders.stream()
                .map(builder -> builder.build(new TagSchema(null, null)))
                .collect(Collectors.toList())
        );
    }

}