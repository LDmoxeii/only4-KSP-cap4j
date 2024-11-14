package com.only4.domain.aggregates.permission;

import lombok.NoArgsConstructor;

/**
 * @author LD_moxeii
 */
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class PermissionDefinitions {
    public static final String ADMIN_USER_CREATE = "ADMIN_USER_CREATE";
    public static final String ADMIN_USER_EDIT = "ADMIN_USER_EDIT";
    public static final String ADMIN_USER_UPDATE_ROLES = "ADMIN_USER_UPDATE_ROLES";
    public static final String ADMIN_USER_VIEW = "ADMIN_USER_VIEW";
    public static final String ADMIN_USER_UPDATE_PASSWORD = "ADMIN_USER_UPDATE_PASSWORD";
    public static final String ADMIN_USER_DELETE = "ADMIN_USER_DELETE";

    public static final String ROLE_CREATE = "ROLE_CREATE";
    public static final String ROLE_EDIT = "ROLE_EDIT";
    public static final String ROLE_UPDATE_PERMISSIONS = "ROLE_UPDATE_PERMISSIONS";
    public static final String ROLE_DELETE = "ROLE_DELETE";
    public static final String ROLE_VIEW = "ROLE_VIEW";
}
