package com.only4.adapter.domain.repositories;

import com.only4.domain.aggregates.stardust.Stardust;
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
public interface StardustRepository extends AggregateRepository<Stardust, Long> {

    @Component
    @Aggregate(aggregate = "Stardust", name = "Stardust", type = Aggregate.TYPE_REPOSITORY, description = "")
    public static class StardustJpaRepositoryAdapter extends AbstractJpaRepository<Stardust, Long>
    {
        public StardustJpaRepositoryAdapter(JpaSpecificationExecutor<Stardust> jpaSpecificationExecutor, JpaRepository<Stardust, Long> jpaRepository) {
            super(jpaSpecificationExecutor, jpaRepository);
        }
    }

}
