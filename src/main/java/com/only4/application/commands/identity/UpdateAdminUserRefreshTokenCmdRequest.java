package com.only4.application.commands.identity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.application.RequestParam;

/**
 * UpdateAdminUserRefreshTokenCmd命令请求参数
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAdminUserRefreshTokenCmdRequest implements RequestParam<UpdateAdminUserRefreshTokenCmdResponse> {

    Long adminUserId;

    String refreshToken;

}
