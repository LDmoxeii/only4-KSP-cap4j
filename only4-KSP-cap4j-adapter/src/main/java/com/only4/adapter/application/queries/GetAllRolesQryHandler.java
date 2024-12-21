package com.only4.adapter.application.queries;

import com.only4.adapter.domain.repositories.RoleRepository;
import com.only4.adapter.infra.mybatis.mapper.RoleMapper;
import com.only4.application.queries.role.GetAllRolesQry;
import com.only4.domain.aggregates.role.Role;
import com.only4.domain.aggregates.role.meta.RoleSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
 * GetAllRolesQry查询请求适配实现
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/13
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GetAllRolesQryHandler implements Query<GetAllRolesQry.Request, GetAllRolesQry.Response> {
    private final RoleMapper roleMapper;
    private final RoleRepository.RoleJpaRepositoryAdapter roleRepository;

    @Override
    public GetAllRolesQry.Response exec(GetAllRolesQry.Request request) {
//        List<Role> roles = roleMapper.getAll();
        val roles = Mediator.repositories().find(JpaPredicate.bySpecification(
                Role.class,
                RoleSchema.specify(it ->it.all())
        ));
        return GetAllRolesQry.Response.builder()
                .roles(roles)
                .build();
        // mybatis / jpa 哪个顺手就用哪个吧！
    }
}
