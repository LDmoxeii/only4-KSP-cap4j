package com.only4.adapter.domain.repositories;

import com.only4.domain.aggregates.block.Block;
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
public interface BlockRepository extends AggregateRepository<Block, Long> {

    @Component
    @Aggregate(aggregate = "block", name = "Block", type = Aggregate.TYPE_REPOSITORY, description = "")
    public static class BlockJpaRepositoryAdapter extends AbstractJpaRepository<Block, Long>
    {
        public BlockJpaRepositoryAdapter(JpaSpecificationExecutor<Block> jpaSpecificationExecutor, JpaRepository<Block, Long> jpaRepository) {
            super(jpaSpecificationExecutor, jpaRepository);
        }
    }

}
