package com.only4.adapter.portal.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author LD_moxeii
 */
@Data
@AllArgsConstructor
public class RolePermissionResponse {
    String permissionCode;
    String remark;
    String groupName;
    Boolean isAssigned;
}
