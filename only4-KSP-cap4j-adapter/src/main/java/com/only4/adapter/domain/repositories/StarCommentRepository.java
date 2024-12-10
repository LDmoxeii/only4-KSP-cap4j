package com.only4.adapter.domain.repositories;

import com.only4.domain.aggregates.star_comment.StarComment;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.repo.AbstractJpaRepository;
import org.netcorepal.cap4j.ddd.domain.repo.AggregateRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;
/**
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * @author cap4j-ddd-codegen
 * @date 2024/11/26
 */
public interface StarCommentRepository extends AggregateRepository<StarComment, Long> {

    @Component
    @Aggregate(aggregate = "StarComment", name = "StarComment", type = Aggregate.TYPE_REPOSITORY, description = "")
    public static class StarCommentJpaRepositoryAdapter extends AbstractJpaRepository<StarComment, Long>
    {
        public StarCommentJpaRepositoryAdapter(JpaSpecificationExecutor<StarComment> jpaSpecificationExecutor, JpaRepository<StarComment, Long> jpaRepository) {
            super(jpaSpecificationExecutor, jpaRepository);
        }
    }

}
