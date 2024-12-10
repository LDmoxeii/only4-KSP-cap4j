package com.only4.adapter.portal.api.response;

import lombok.Builder;
import lombok.Data;

/**
 * @author LD_moxeii
 */
@Data
@Builder
public class AdminUserRolesResponse {
  Long roleId;
  String roleName;
  String description;
  Boolean isAssigned;

}
