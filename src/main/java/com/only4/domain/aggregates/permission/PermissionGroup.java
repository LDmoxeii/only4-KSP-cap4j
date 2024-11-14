package com.only4.domain.aggregates.permission;

import lombok.NoArgsConstructor;

/**
 * @author LD_moxeii
 */
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class PermissionGroup {
    public static final String SYSTEM_ACCESS = "SYSTEM_ACCESS";
    public static final String SYSTEM_MANAGE = "MANAGEMENT_HIERARCHY";
}
