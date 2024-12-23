package com.only4.adapter._share.utils;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import com.only4.domain.aggregates.admin_user.AdminUser;
import com.only4.domain.aggregates.member.Member;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.only4.adapter._share.constants.UserConstant.*;

/**
 * @author LD_moxeii
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginHelper {

    public static <T> void login(T loginUser) {
        login(loginUser, null);
    }

    public static <T> void login(T loginUser, SaLoginModel model) {
        model = ObjectUtil.defaultIfNull(model, new SaLoginModel());
        if (loginUser instanceof Member) {
            Member member = (Member)loginUser;
            model.setExtra(CUSTOMER_KEY, member.getId());
            StpUtil.login(member.getId(), model);
            StpUtil.getSession().set(LOGIN_USER_KEY, member);
        } else if (loginUser instanceof AdminUser) {
            AdminUser adminUser = (AdminUser)loginUser;
            model.setExtra(CUSTOMER_KEY, adminUser.getId());
            StpUtil.login(adminUser.getId(), model);
            StpUtil.getSession().set(LOGIN_USER_KEY, adminUser);
        }

    }

    /**
     * 获取用户(多级缓存)
     */
    public static <T> T getLoginUser(Class<T> clazz) {
        SaSession session = StpUtil.getTokenSession();
        if (ObjectUtil.isNull(session)) {
            return null;
        }

        Object user = session.get(LOGIN_USER_KEY);
        // 检查类型安全
        if (!clazz.isInstance(user)) {
            throw new ClassCastException("Expected type " + clazz.getName() + ", but got " + user.getClass().getName());
        }
        return clazz.cast(user);
    }

    /**
     * 获取用户基于token
     */
    public static <T> T getLoginUser(Class<T> clazz, String token) {
        SaSession session = StpUtil.getTokenSessionByToken(token);
        if (ObjectUtil.isNull(session)) {
            return null;
        }
        Object user = session.get(LOGIN_USER_KEY);
        // 检查类型安全
        if (!clazz.isInstance(user)) {
            throw new ClassCastException("Expected type " + clazz.getName() + ", but got " + user.getClass().getName());
        }
        return clazz.cast(user);
    }

    /**
     * 获取用户id
     */
    public static Long getUserId() {
        return Convert.toLong(getExtra(CUSTOMER_KEY));
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
            return getLoginUser(clazz) != null;
        } catch (Exception e) {
            return false;
        }
    }
}
