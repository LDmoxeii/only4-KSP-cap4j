package com.only4.adapter.domain.repositories;

import com.only4.domain.aggregates.star_comment_reply.StarCommentReply;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.repo.AbstractJpaRepository;
import org.netcorepal.cap4j.ddd.domain.repo.AggregateRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;
/**
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * @author cap4j-ddd-codegen
 * @date 2025/02/23
 */
public interface StarCommentReplyRepository extends AggregateRepository<StarCommentReply, Long> {

    @Component
    @Aggregate(aggregate = "StarCommentReply", name = "StarCommentReply", type = Aggregate.TYPE_REPOSITORY, description = "")
    public static class StarCommentReplyJpaRepositoryAdapter extends AbstractJpaRepository<StarCommentReply, Long>
    {
        public StarCommentReplyJpaRepositoryAdapter(JpaSpecificationExecutor<StarCommentReply> jpaSpecificationExecutor, JpaRepository<StarCommentReply, Long> jpaRepository) {
            super(jpaSpecificationExecutor, jpaRepository);
        }
    }

}
