package com.only4.adapter.portal.api._share.auth.core.service;

import cn.dev33.satoken.stp.StpInterface;
import com.only4.adapter.portal.api._share.auth.utils.LoginHelper;
import com.only4.adapter.portal.api._share.dto.PermissionDto;
import com.only4.adapter.portal.api._share.dto.RoleDto;

import java.util.List;
import java.util.stream.Collectors;

/**
 * sa-token 权限管理实现类
 *
 * @author moxeii
 */
public class SaPermissionImpl implements StpInterface {

    /**
     * 返回指定账号id所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return LoginHelper.getPermissions().stream()
                .map(PermissionDto::getCode)
                .collect(Collectors.toList());
    }

    /**
     * 返回指定账号id所拥有的角色标识集合
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        return LoginHelper.getRoles().stream()
                .map(RoleDto::getName)
                .collect(Collectors.toList());
    }
}
