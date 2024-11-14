package com.only4.adapter.infra.mybatis.mapper;

import com.only4.domain.aggregates.role.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {

    Long existByName(String name);

    Role getByName(String roleName);

    List<Role> getAll();

    List<Role> getByCondition(String name, String description);

    Role getById(Long id);
}
