package com.only4.adapter.portal.api._share.configure;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import com.only4._share.utils.SpringUtils;
import com.only4.adapter.portal.api._share.configure.properties.SecurityProperties;
import com.only4.adapter.portal.api._share.handler.AllUrlHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 权限安全配置
 *
 * @author Lion Li
 */

@Slf4j
@AutoConfiguration
@EnableConfigurationProperties(SecurityProperties.class)
@RequiredArgsConstructor
public class SecurityConfig implements WebMvcConfigurer {

  private final SecurityProperties securityProperties;

  /**
   * 注册sa-token的拦截器
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 注册路由拦截器，自定义验证规则
    registry.addInterceptor(new SaInterceptor(handler -> {
          AllUrlHandler allUrlHandler = SpringUtils.getBean(AllUrlHandler.class);
          // 登录验证 -- 排除多个路径
          // 检查是否登录 是否有token
          SaRouter
              // 获取所有的
              .match(allUrlHandler.getUrls())
              // 对未排除的路径进行检查
              .check(StpUtil::checkLogin);
        })).addPathPatterns("/**")
        // 排除不需要拦截的路径
        .excludePathPatterns(securityProperties.getExcludes());
  }

}
