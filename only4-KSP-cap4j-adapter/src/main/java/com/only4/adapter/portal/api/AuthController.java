package com.only4.adapter.portal.api;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.StpUtil;
import com.only4.adapter._share.dto.LoginUser;
import com.only4.adapter._share.dto.PermissionDto;
import com.only4.adapter._share.dto.RoleDto;
import com.only4.adapter._share.utils.LoginHelper;
import com.only4.adapter.portal.api._share.ResponseData;
import com.only4.adapter.portal.api.request.LoginByAccountRequest;
import com.only4.application.commands.admin_user.AdminUserLoginSuccessfullyCmd;
import com.only4.application.queries.admin_user.AdminUserAccessCriteriaQry;
import com.only4.domain.aggregates.admin_user.AdminUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author LD_moxeii
 */
@Slf4j
@SaIgnore
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/loginByAccount")
    public ResponseData<?> login(@RequestBody LoginByAccountRequest request) {
        AdminUser adminUser = Optional.ofNullable(Mediator.queries().send(AdminUserAccessCriteriaQry.Request.builder()
                        .account(request.getAccount())
                        .password(request.getPassword())
                        .build()).getAdminUser())
                .orElseThrow(() -> new RuntimeException("账号或密码错误"));

        List<RoleDto> roles = adminUser.getAdminUserRoles().stream()
                .map(r -> RoleDto.builder()
                        .name(r.getRoleName())
                        .build())
                .collect(Collectors.toList());

        List<PermissionDto> permissions = adminUser.getAdminUserPermissions().stream()
                .map(p -> PermissionDto.builder()
                        .code(p.getPermissionCode())
                        .name(p.getPermissionRemark())
                        .build())
                .collect(Collectors.toList());

        LoginUser loginUser = LoginUser.builder()
                .id(adminUser.getId())
                .roles(roles)
                .permissions(permissions)
                .build();

        SaLoginModel model = new SaLoginModel();
        model.setTimeout(60L * 60 * 24);
        LoginHelper.login(loginUser);

        String token = StpUtil.getTokenValue();
        LoginHelper.getRoles().forEach(System.out::println);
        LoginHelper.getPermissions().forEach(System.out::println);
        if (Mediator.commands().send(AdminUserLoginSuccessfullyCmd.Request.builder()
                .adminUserId(adminUser.getId())
                .loginExpiryDate(LocalDateTime.now().plusDays(1L))
                .refreshToken(token)
                .build()).isSuccess()) {

            return ResponseData.success(token);
        }

        return ResponseData.fail("登录失败");
    }

}
