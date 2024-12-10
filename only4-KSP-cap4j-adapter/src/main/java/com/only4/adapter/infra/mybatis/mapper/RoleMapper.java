package com.only4.adapter.infra.mybatis.mapper;

import com.only4.domain.aggregates.role.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleMapper {

    Long existByName(String name);

    Role getByName(String roleName);

    List<Role> getAll();

    List<Role> getByCondition(@Param("name") String name,@Param("description") String description);

    Role getById(Long id);
}
