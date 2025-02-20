package com.only4.adapter._share.utils;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import com.only4.adapter._share.dto.LoginUser;
import com.only4.adapter._share.dto.PermissionDto;
import com.only4.adapter._share.dto.RoleDto;
import com.only4.domain.aggregates.admin_user.AdminUser;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static com.only4.adapter._share.constants.UserConstant.*;

/**
 * @author LD_moxeii
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginHelper {

    public static void login(LoginUser loginUser) {
        login(loginUser, null);
    }

    public static void login(LoginUser loginUser, SaLoginModel model) {

        model = ObjectUtil.defaultIfNull(model, new SaLoginModel());

        model.setExtra(ADMIN_USER_ID, loginUser.getId());
        StpUtil.login(loginUser.getId(), model);

        StpUtil.getSession().set(USER_ROLES, loginUser.getRoles());
        StpUtil.getSession().set(USER_PERMISSIONS, loginUser.getPermissions());
    }

    /**
     * 获取用户权限
     */
    @SuppressWarnings("unchecked")
    public static List<PermissionDto> getPermissions() {
        SaSession session = StpUtil.getTokenSession();

        return (List<PermissionDto>)session.get(USER_PERMISSIONS);
    }

    /**
     * 获取用户角色
     */
    @SuppressWarnings("unchecked")
    public static List<RoleDto> getRoles() {
        SaSession session = StpUtil.getTokenSession();

        return (List<RoleDto>)session.get(USER_ROLES);
    }

    /**
     * 获取用户id
     */
    public static Long getUserId() {
        return Convert.toLong(getExtra(ADMIN_USER_ID));
    }

    /**
     * 获取用户基于token
     */
    @Deprecated
    public static AdminUser getLoginUser(String token) {
        SaSession session = StpUtil.getTokenSessionByToken(token);

        return (AdminUser)session.get(ADMIN_USER_KEY);
    }

    /**
     * 获取当前 Token 的扩展信息
     *
     * @param key 键值
     * @return 对应的扩展数据
     */
    private static Object getExtra(String key) {
        try {
            return StpUtil.getExtra(key);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 检查当前用户是否已登录
     *
     * @return 结果
     */
    public static <T> boolean isLogin(Class<T> clazz) {
        try {
            return getUserId() != null;
        } catch (Exception e) {
            return false;
        }
    }
}
