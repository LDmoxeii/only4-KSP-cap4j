package com.only4.application.commands.role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CreateRoleCmd命令响应
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/14
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateRoleCmdResponse {

  Long id;
  boolean success;
}
