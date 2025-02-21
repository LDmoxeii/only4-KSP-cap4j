package com.only4.adapter.domain.repositories;

import com.only4.domain.aggregates.article_comment_like.ArticleCommentLike;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.repo.AbstractJpaRepository;
import org.netcorepal.cap4j.ddd.domain.repo.AggregateRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;
/**
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * @author cap4j-ddd-codegen
 * @date 2025/02/21
 */
public interface ArticleCommentLikeRepository extends AggregateRepository<ArticleCommentLike, Long> {

    @Component
    @Aggregate(aggregate = "ArticleCommentLike", name = "ArticleCommentLike", type = Aggregate.TYPE_REPOSITORY, description = "")
    public static class ArticleCommentLikeJpaRepositoryAdapter extends AbstractJpaRepository<ArticleCommentLike, Long>
    {
        public ArticleCommentLikeJpaRepositoryAdapter(JpaSpecificationExecutor<ArticleCommentLike> jpaSpecificationExecutor, JpaRepository<ArticleCommentLike, Long> jpaRepository) {
            super(jpaSpecificationExecutor, jpaRepository);
        }
    }

}
