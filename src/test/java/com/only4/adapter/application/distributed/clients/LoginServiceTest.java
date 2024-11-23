package com.only4.adapter.application.distributed.clients;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.only4._share.exception.KnownException;
import java.util.function.Supplier;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LoginServiceTest {

  @InjectMocks
  private LoginService loginService;

  @Mock
  private Supplier<Boolean> supplier;

  @Test
  void checkLogin() {
    when(supplier.get()).thenReturn(true);
    var actual = assertThrows(KnownException.class, () -> loginService.checkLogin("", supplier));
    verify(supplier).get();
    assertEquals("密码错误", actual.getMessage());
  }

  @Test
  void checkLogin_success() {
    when(supplier.get()).thenReturn(false);
    loginService.checkLogin("", supplier);
    verify(supplier).get();
  }
}
