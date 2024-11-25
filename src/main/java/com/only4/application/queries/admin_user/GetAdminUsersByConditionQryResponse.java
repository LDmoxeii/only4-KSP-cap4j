package com.only4.application.queries.admin_user;

import com.only4.domain.aggregates.admin_user.AdminUser;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * GetAdminUsersByConditionQry查询响应
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/14
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAdminUsersByConditionQryResponse {
  private List<AdminUser> adminUsers;

}
