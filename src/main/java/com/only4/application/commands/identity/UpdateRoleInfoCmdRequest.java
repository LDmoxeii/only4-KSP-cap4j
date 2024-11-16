package com.only4.application.commands.identity;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.application.RequestParam;

/**
 * UpdateRoleInfoCmd命令请求参数
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRoleInfoCmdRequest implements RequestParam<UpdateRoleInfoCmdResponse> {

  public Long roleId;

  @NotEmpty
  public String name;

  public String description;

}
