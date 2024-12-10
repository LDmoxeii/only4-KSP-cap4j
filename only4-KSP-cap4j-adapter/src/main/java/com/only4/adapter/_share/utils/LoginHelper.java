package com.only4.adapter._share.utils;

import static com.only4.adapter._share.constants.CustomerConstant.CUSTOMER_ACCOUNT_KEY;
import static com.only4.adapter._share.constants.CustomerConstant.CUSTOMER_KEY;
import static com.only4.adapter._share.constants.CustomerConstant.LOGIN_USER_KEY;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import com.only4.domain.aggregates.customer.Customer;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author LD_moxeii
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginHelper {

  public static void login(Customer loginUser) {
    login(loginUser, null);
  }

  public static void login(Customer loginUser, SaLoginModel model) {
    model = ObjectUtil.defaultIfNull(model, new SaLoginModel());
    model.setExtra(CUSTOMER_KEY, loginUser.getId());
    StpUtil.login(loginUser.getId(), model);
    StpUtil.getSession().set(LOGIN_USER_KEY, loginUser);
  }

  /**
   * 获取用户(多级缓存)
   */
  public static Customer getLoginUser() {
    SaSession session = StpUtil.getTokenSession();
    if (ObjectUtil.isNull(session)) {
      return null;
    }
    return (Customer) session.get(LOGIN_USER_KEY);
  }

  /**
   * 获取用户基于token
   */
  public static Customer getLoginUser(String token) {
    SaSession session = StpUtil.getTokenSessionByToken(token);
    if (ObjectUtil.isNull(session)) {
      return null;
    }
    return (Customer) session.get(LOGIN_USER_KEY);
  }

  /**
   * 获取用户id
   */
  public static Long getCustomerId() {
    return Convert.toLong(getExtra(CUSTOMER_KEY));
  }

  /**
   * 获取用户账户
   */
  public static String getAccount() {
    return Convert.toStr(getExtra(CUSTOMER_ACCOUNT_KEY));
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
  public static boolean isLogin() {
    try {
      return getLoginUser() != null;
    } catch (Exception e) {
      return false;
    }
  }
}
