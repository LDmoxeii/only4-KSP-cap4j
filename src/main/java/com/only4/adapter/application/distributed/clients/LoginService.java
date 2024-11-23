package com.only4.adapter.application.distributed.clients;

import com.only4._share.exception.KnownException;
import java.util.function.Supplier;
import org.springframework.stereotype.Service;

/**
 * @author LD_moxeii
 */
@Service
public class LoginService {

  public void checkLogin(String account, Supplier<Boolean> supplier) {
    if (supplier.get()) {
      throw new KnownException("密码错误");
    }
  }
}
