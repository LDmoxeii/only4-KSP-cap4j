package com.only4.adapter.portal.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author LD_moxeii
 */
@Data
@Builder
public class LoginByAccountResponse {
  /**
   * 授权令牌
   */
  @JsonProperty("access_token")
  private String accessToken;
}
