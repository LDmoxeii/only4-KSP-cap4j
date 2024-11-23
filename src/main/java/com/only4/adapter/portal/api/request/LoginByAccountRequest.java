package com.only4.adapter.portal.api.request;

import lombok.Data;

/**
 * @author LD_moxeii
 */
@Data
public class LoginByAccountRequest {

  private String account;
  private String password;

}
