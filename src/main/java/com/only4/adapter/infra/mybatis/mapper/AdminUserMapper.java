package com.only4.adapter.infra.mybatis.mapper;

import com.only4.domain.aggregates.admin_user.AdminUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminUserMapper {

    Long getCountByRoleId(Long roleId);

    Long existedByName(String name);

    Long existedByRoleId();

    List<AdminUser> getByRoleId(Long id);
}
