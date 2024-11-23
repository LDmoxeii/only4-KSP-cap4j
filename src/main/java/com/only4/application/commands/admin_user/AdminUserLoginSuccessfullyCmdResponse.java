package com.only4.application.commands.admin_user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * AdminUserLoginSuccessfullyCmd命令响应
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminUserLoginSuccessfullyCmdResponse {

  boolean success;
}