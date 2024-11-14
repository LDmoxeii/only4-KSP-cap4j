package com.only4.adapter.portal.api.request;

import lombok.Data;

/**
 * @author LD_moxeii
 */
@Data
public class UpdateRoleInfoRequest {
    Long id;
    String name;
    String description;
}
