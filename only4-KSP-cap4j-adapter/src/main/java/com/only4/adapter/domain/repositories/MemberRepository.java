package com.only4.adapter.domain.repositories;

import com.only4.domain.aggregates.member.Member;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.repo.AbstractJpaRepository;
import org.netcorepal.cap4j.ddd.domain.repo.AggregateRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;
/**
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * @author cap4j-ddd-codegen
 * @date 2024/12/15
 */
public interface MemberRepository extends AggregateRepository<Member, Long> {

    @Component
    @Aggregate(aggregate = "Member", name = "Member", type = Aggregate.TYPE_REPOSITORY, description = "")
    public static class MemberJpaRepositoryAdapter extends AbstractJpaRepository<Member, Long>
    {
        public MemberJpaRepositoryAdapter(JpaSpecificationExecutor<Member> jpaSpecificationExecutor, JpaRepository<Member, Long> jpaRepository) {
            super(jpaSpecificationExecutor, jpaRepository);
        }
    }

}
