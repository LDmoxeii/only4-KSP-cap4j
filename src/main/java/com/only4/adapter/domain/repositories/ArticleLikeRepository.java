package com.only4.adapter.domain.repositories;

import com.only4.domain.aggregates.article_like.ArticleLike;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.repo.AbstractJpaRepository;
import org.netcorepal.cap4j.ddd.domain.repo.AggregateRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;
/**
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * @author cap4j-ddd-codegen
 * @date 2024/11/23
 */
public interface ArticleLikeRepository extends AggregateRepository<ArticleLike, Long> {

    @Component
    @Aggregate(aggregate = "article_like", name = "ArticleLike", type = Aggregate.TYPE_REPOSITORY, description = "")
    public static class ArticleLikeJpaRepositoryAdapter extends AbstractJpaRepository<ArticleLike, Long>
    {
        public ArticleLikeJpaRepositoryAdapter(JpaSpecificationExecutor<ArticleLike> jpaSpecificationExecutor, JpaRepository<ArticleLike, Long> jpaRepository) {
            super(jpaSpecificationExecutor, jpaRepository);
        }
    }

}
