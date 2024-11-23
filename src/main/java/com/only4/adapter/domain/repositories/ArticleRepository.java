package com.only4.adapter.domain.repositories;

import com.only4.domain.aggregates.article.Article;
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
public interface ArticleRepository extends AggregateRepository<Article, Long> {

    @Component
    @Aggregate(aggregate = "article", name = "Article", type = Aggregate.TYPE_REPOSITORY, description = "")
    public static class ArticleJpaRepositoryAdapter extends AbstractJpaRepository<Article, Long>
    {
        public ArticleJpaRepositoryAdapter(JpaSpecificationExecutor<Article> jpaSpecificationExecutor, JpaRepository<Article, Long> jpaRepository) {
            super(jpaSpecificationExecutor, jpaRepository);
        }
    }

}
