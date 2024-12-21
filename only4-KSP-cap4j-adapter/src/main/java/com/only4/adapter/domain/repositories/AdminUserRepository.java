package com.only4.adapter.domain.repositories;

import com.only4.domain.aggregates.admin_user.AdminUser;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.repo.AbstractJpaRepository;
import org.netcorepal.cap4j.ddd.domain.repo.AggregateRepository;
import org.netcorepal.cap4j.ddd.domain.repo.Predicate;
import org.netcorepal.cap4j.ddd.share.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * @author cap4j-ddd-codegen
 * @date 2024/12/15
 */
public interface AdminUserRepository extends AggregateRepository<AdminUser, Long> {

    @Component
    @Aggregate(aggregate = "AdminUser", name = "AdminUser", type = Aggregate.TYPE_REPOSITORY, description = "")
    public static class AdminUserJpaRepositoryAdapter extends AbstractJpaRepository<AdminUser, Long>
    {
        public AdminUserJpaRepositoryAdapter(JpaSpecificationExecutor<AdminUser> jpaSpecificationExecutor, JpaRepository<AdminUser, Long> jpaRepository) {
            super(jpaSpecificationExecutor, jpaRepository);
        }
    }

}
