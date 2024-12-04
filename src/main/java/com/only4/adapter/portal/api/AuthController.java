package com.only4.adapter.portal.api;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.stp.StpUtil;
import com.only4.adapter._share.utils.LoginHelper;
import com.only4.adapter.application.distributed.clients.LoginService;
import com.only4.adapter.portal.api._share.ResponseData;
import com.only4.adapter.portal.api.request.LoginByAccountRequest;
import com.only4.adapter.portal.api.response.LoginByAccountResponse;
import com.only4.application.queries.customer.GetCustomerByAccountQry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LD_moxeii
 */
@Slf4j
@SaIgnore
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

  private final LoginService loginService;

  @PostMapping("/loginByAccount")
  public ResponseData<?> login(@RequestBody LoginByAccountRequest request) {

    var customer = Mediator.queries()
        .send(GetCustomerByAccountQry.Request.builder()
            .account(request.getAccount())
            .build())
        .getCustomer();
    loginService.checkLogin(request.getAccount(),
        () -> !BCrypt.checkpw(request.getPassword(), customer.getPassword()));
    LoginHelper.login(customer);
    var response = LoginByAccountResponse.builder().accessToken(StpUtil.getTokenValue()).build();
    return ResponseData.success(response);
  }

}
