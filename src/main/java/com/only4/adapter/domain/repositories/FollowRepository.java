package com.only4.adapter.domain.repositories;

import com.only4.domain.aggregates.follow.Follow;
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
public interface FollowRepository extends AggregateRepository<Follow, Long> {

    @Component
    @Aggregate(aggregate = "follow", name = "Follow", type = Aggregate.TYPE_REPOSITORY, description = "")
    public static class FollowJpaRepositoryAdapter extends AbstractJpaRepository<Follow, Long>
    {
        public FollowJpaRepositoryAdapter(JpaSpecificationExecutor<Follow> jpaSpecificationExecutor, JpaRepository<Follow, Long> jpaRepository) {
            super(jpaSpecificationExecutor, jpaRepository);
        }
    }

}
