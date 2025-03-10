package com.only4.adapter.domain.repositories;

import com.only4.domain.aggregates.star_like.StarLike;
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
public interface StarLikeRepository extends AggregateRepository<StarLike, Long> {

    @Component
    @Aggregate(aggregate = "StarLike", name = "StarLike", type = Aggregate.TYPE_REPOSITORY, description = "")
    public static class StarLikeJpaRepositoryAdapter extends AbstractJpaRepository<StarLike, Long>
    {
        public StarLikeJpaRepositoryAdapter(JpaSpecificationExecutor<StarLike> jpaSpecificationExecutor, JpaRepository<StarLike, Long> jpaRepository) {
            super(jpaSpecificationExecutor, jpaRepository);
        }
    }

}
