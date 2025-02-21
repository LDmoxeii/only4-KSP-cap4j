package com.only4.adapter.domain.repositories;

import com.only4.domain.aggregates.article_comment_reply.ArticleCommentReply;
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
public interface ArticleCommentReplyRepository extends AggregateRepository<ArticleCommentReply, Long> {

    @Component
    @Aggregate(aggregate = "ArticleCommentReply", name = "ArticleCommentReply", type = Aggregate.TYPE_REPOSITORY, description = "")
    public static class ArticleCommentReplyJpaRepositoryAdapter extends AbstractJpaRepository<ArticleCommentReply, Long>
    {
        public ArticleCommentReplyJpaRepositoryAdapter(JpaSpecificationExecutor<ArticleCommentReply> jpaSpecificationExecutor, JpaRepository<ArticleCommentReply, Long> jpaRepository) {
            super(jpaSpecificationExecutor, jpaRepository);
        }
    }

}
