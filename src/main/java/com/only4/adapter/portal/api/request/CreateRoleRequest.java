package com.only4.adapter.portal.api.request;

import lombok.Data;

import java.util.List;

/**
 * @author LD_moxeii
 */
@Data
public class CreateRoleRequest {

    private String name;

    private String description;

    private List<Object> permissionCodes;

}
