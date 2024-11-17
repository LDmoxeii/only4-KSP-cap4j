package com.only4.application.commands.admin_user;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.application.RequestParam;

/**
 * AdminUserLoginSuccessfullyCmd命令请求参数
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminUserLoginSuccessfullyCmdRequest implements
    RequestParam<AdminUserLoginSuccessfullyCmdResponse> {

  Long adminUserId;

  String refreshToken;

  LocalDateTime loginExpiryDate;

}
