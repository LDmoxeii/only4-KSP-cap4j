package com.only4.adapter.domain.repositories;

import com.only4.domain.aggregates.star_comment_like.StarCommentLike;
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
public interface StarCommentLikeRepository extends AggregateRepository<StarCommentLike, Long> {

    @Component
    @Aggregate(aggregate = "StarCommentLike", name = "StarCommentLike", type = Aggregate.TYPE_REPOSITORY, description = "")
    public static class StarCommentLikeJpaRepositoryAdapter extends AbstractJpaRepository<StarCommentLike, Long>
    {
        public StarCommentLikeJpaRepositoryAdapter(JpaSpecificationExecutor<StarCommentLike> jpaSpecificationExecutor, JpaRepository<StarCommentLike, Long> jpaRepository) {
            super(jpaSpecificationExecutor, jpaRepository);
        }
    }

}
