package com.only4.domain._share.meta;

import com.google.common.collect.Lists;
import jakarta.persistence.criteria.*;
import org.hibernate.query.sqm.SortOrder;
import org.hibernate.query.sqm.tree.domain.SqmBasicValuedSimplePath;
import org.hibernate.query.sqm.tree.select.SqmSortSpecification;

import java.util.Collection;

/**
 * 实体结构基类
 *
 * @author cap4j-ddd-codegen
 */
public class Schema {

    /**
     * 断言构建器
     */
    public static interface PredicateBuilder<S> {
        public Predicate build(S schema);
    }

    public static interface Specification<E, S> {
        public Predicate toPredicate(S schema, CriteriaQuery<?> criteriaQuery);
    }

    /**
     * 排序构建器
     */
    public static interface OrderBuilder<S> {
        public Order build(S schema);
    }

    public enum JoinType {
        INNER,
        LEFT,
        RIGHT;

        public jakarta.persistence.criteria.JoinType toJpaJoinType() {
            if (this == Schema.JoinType.INNER) {
                return jakarta.persistence.criteria.JoinType.INNER;
            } else if (this == Schema.JoinType.LEFT) {
                return jakarta.persistence.criteria.JoinType.LEFT;
            } else if (this == Schema.JoinType.RIGHT) {
                return jakarta.persistence.criteria.JoinType.RIGHT;
            }
            return jakarta.persistence.criteria.JoinType.LEFT;
        }
    }

    /**
     * 字段
     *
     * @param <T>
     */
    public static class Field<T> {
        private String name;
        private Path<T> path;
        private CriteriaBuilder criteriaBuilder;

        public Field(Path<T> path, CriteriaBuilder criteriaBuilder) {
            this.path = path;
            this.name = ((SqmBasicValuedSimplePath) path).getNavigablePath().getLocalName();
            this.criteriaBuilder = criteriaBuilder;
        }

        public Field(String name) {
            this.name = name;
        }

        protected CriteriaBuilder _criteriaBuilder() {
            return this.criteriaBuilder;
        }

        public Path<T> path() {
            return path;
        }

        public Order asc() {
            return new SqmSortSpecification((SqmBasicValuedSimplePath<T>) path, SortOrder.ASCENDING);
        }

        public Order desc() {
            return new SqmSortSpecification((SqmBasicValuedSimplePath<T>) path, SortOrder.DESCENDING);
        }

        public Predicate isTrue() {
            return this.criteriaBuilder.isTrue((Expression<Boolean>) this.path);
        }

        public Predicate isFalse() {
            return this.criteriaBuilder.isTrue((Expression<Boolean>) this.path);

        }

        public Predicate equal(Object val) {
            return this.criteriaBuilder.equal(this.path, val);
        }

        public Predicate equal(Expression<?> val) {
            return this.criteriaBuilder.equal(this.path, val);
        }

        public Predicate notEqual(Object val) {
            return this.criteriaBuilder.notEqual(this.path, val);
        }

        public Predicate notEqual(Expression<?> val) {
            return this.criteriaBuilder.notEqual(this.path, val);
        }

        public Predicate isNull() {
            return this.criteriaBuilder.isNull(this.path);
        }

        public Predicate isNotNull() {
            return this.criteriaBuilder.isNotNull(this.path);
        }

        public <Y extends Comparable<? super Y>> Predicate greaterThan(Y val) {
            return this.criteriaBuilder.greaterThan((Expression<Y>) this.path, val);
        }

        public <Y extends Comparable<? super Y>> Predicate greaterThan(Expression<? extends Y> val) {
            return this.criteriaBuilder.greaterThan((Expression<Y>) this.path, val);
        }

        public <Y extends Comparable<? super Y>> Predicate greaterThanOrEqualTo(Y val) {
            return this.criteriaBuilder.greaterThan((Expression<Y>) this.path, val);
        }

        public <Y extends Comparable<? super Y>> Predicate greaterThanOrEqualTo(Expression<? extends Y> val) {
            return this.criteriaBuilder.greaterThanOrEqualTo((Expression<Y>) this.path, val);
        }

        public <Y extends Comparable<? super Y>> Predicate lessThan(Y val) {
            return this.criteriaBuilder.lessThan((Expression<Y>) this.path, val);
        }

        public <Y extends Comparable<? super Y>> Predicate lessThan(Expression<? extends Y> val) {
            return this.criteriaBuilder.lessThan((Expression<Y>) this.path, val);
        }

        public <Y extends Comparable<? super Y>> Predicate lessThanOrEqualTo(Y val) {
            return this.criteriaBuilder.lessThanOrEqualTo((Expression<Y>) this.path, val);
        }

        public <Y extends Comparable<? super Y>> Predicate lessThanOrEqualTo(Expression<? extends Y> val) {
            return this.criteriaBuilder.lessThanOrEqualTo((Expression<Y>) this.path, val);
        }

        public <Y extends Comparable<? super Y>> Predicate between(Y val1, Y val2) {
            return this.criteriaBuilder.between((Expression<Y>) this.path, val1, val2);
        }

        public <Y extends Comparable<? super Y>> Predicate between(Expression<? extends Y> val1, Expression<? extends Y> val2) {
            return this.criteriaBuilder.between((Expression<Y>) this.path, val1, val2);
        }

        public Predicate in(Object... vals) {
            return in(Lists.newArrayList(vals));
        }

        public Predicate in(Collection<Object> vals) {
            CriteriaBuilder.In predicate = criteriaBuilder.in(this.path);
            for (Object o : vals) {
                predicate.value(o);
            }
            return predicate;
        }

        public Predicate notIn(Object... vals) {
            return notIn(Lists.newArrayList(vals));
        }

        public Predicate notIn(Collection<Object> vals) {
            return this.criteriaBuilder.not(in(vals));
        }


        public Predicate like(String val) {
            return this.criteriaBuilder.like((Expression<String>) this.path, val);
        }

        public Predicate like(Expression<String> val) {
            return this.criteriaBuilder.like((Expression<String>) this.path, val);
        }

        public Predicate notLike(String val) {
            return this.criteriaBuilder.notLike((Expression<String>) this.path, val);
        }

        public Predicate notLike(Expression<String> val) {
            return this.criteriaBuilder.notLike((Expression<String>) this.path, val);
        }


        public Predicate eq(Object val) {
            return equal(val);
        }

        public Predicate eq(Expression<?> val) {
            return equal(val);
        }

        public Predicate neq(Object val) {
            return notEqual(val);
        }

        public Predicate neq(Expression<?> val) {
            return notEqual(val);
        }

        public <Y extends Comparable<? super Y>> Predicate gt(Y val) {
            return greaterThan(val);
        }

        public <Y extends Comparable<? super Y>> Predicate gt(Expression<? extends Y> val) {
            return greaterThan(val);
        }

        public <Y extends Comparable<? super Y>> Predicate ge(Y val) {
            return greaterThanOrEqualTo(val);
        }

        public <Y extends Comparable<? super Y>> Predicate ge(Expression<? extends Y> val) {

            return greaterThanOrEqualTo(val);
        }

        public <Y extends Comparable<? super Y>> Predicate lt(Y val) {

            return lessThan(val);
        }

        public <Y extends Comparable<? super Y>> Predicate lt(Expression<? extends Y> val) {
            return lessThan(val);
        }

        public <Y extends Comparable<? super Y>> Predicate le(Y val) {
            return lessThanOrEqualTo(val);
        }

        public <Y extends Comparable<? super Y>> Predicate le(Expression<? extends Y> val) {
            return lessThanOrEqualTo(val);
        }
    }
}
