package com.only4.adapter.portal.api.request;

import lombok.Data;

import java.util.List;

/**
 * @author LD_moxeii
 */
@Data
public class CreateAdminUserRequest {

    String name;
    String phone;
    String password;

    List<Long> roleIds;
}
