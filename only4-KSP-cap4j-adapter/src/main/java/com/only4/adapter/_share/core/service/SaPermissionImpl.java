package com.only4.adapter._share.core.service;

import cn.dev33.satoken.stp.StpInterface;
import com.only4.adapter._share.utils.LoginHelper;
import com.only4.domain.aggregates.admin_user.AdminUser;
import com.only4.domain.aggregates.admin_user.AdminUserPermission;
import lombok.val;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * sa-token 权限管理实现类
 *
 * @author moxeii
 */
public class SaPermissionImpl implements StpInterface {

    /**
     * 获取菜单权限列表
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return new ArrayList<>();
    }

    /**
     * 获取角色权限列表
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        val loginUser = LoginHelper.getLoginUser(AdminUser.class);
        return Objects.requireNonNull(loginUser).getAdminUserPermissions().stream()
                .map(AdminUserPermission::getPermissionCode)
                .collect(Collectors.toList());
    }
}
