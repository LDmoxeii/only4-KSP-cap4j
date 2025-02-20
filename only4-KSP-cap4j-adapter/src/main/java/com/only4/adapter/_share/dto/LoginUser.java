package com.only4.adapter._share.dto;

import lombok.Data;

import java.util.List;

/**
 * @author LD_moxeii
 */
@Data
public class LoginUser {

    private Long id;

    private List<PermissionDto> permissions;

    private List<RoleDto> roles;
}
