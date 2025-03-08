package com.only4.adapter.domain.repositories;

import com.only4.domain.aggregates.star.Star;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.repo.AbstractJpaRepository;
import org.netcorepal.cap4j.ddd.domain.repo.AggregateRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;
/**
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * @author cap4j-ddd-codegen
 * @date 2025/03/08
 */
public interface StarRepository extends AggregateRepository<Star, Long> {

    @Component
    @Aggregate(aggregate = "Star", name = "Star", type = Aggregate.TYPE_REPOSITORY, description = "")
    public static class StarJpaRepositoryAdapter extends AbstractJpaRepository<Star, Long>
    {
        public StarJpaRepositoryAdapter(JpaSpecificationExecutor<Star> jpaSpecificationExecutor, JpaRepository<Star, Long> jpaRepository) {
            super(jpaSpecificationExecutor, jpaRepository);
        }
    }

}
