package com.only4.adapter.infra.mybatis.mapper;

import com.only4.domain.aggregates.admin_user.AdminUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminUserMapper {

    Long existedByName(String name);

    Long existedByRoleId();

    List<AdminUser> getByRoleId(Long id);

    List<AdminUser> getAll();

    List<AdminUser> getByCondition(@Param("name") String name,@Param("phone") String phone);

    AdminUser getById(Long id);
}
