package com.only4.application.commands.admin_user;

import com.only4._share.exception.KnownException;
import com.only4.domain.aggregates.admin_user.AdminUser;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.domain.repo.RepositorySupervisor;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AdminUserLoginSuccessfullyCmdTest {

  @InjectMocks
  private AdminUserLoginSuccessfullyCmd.Handler target;

  @Mock
  private RepositorySupervisor repositorySupervisor;

  @Mock
  private AdminUser adminUser;

  @Mock
  private AdminUserLoginSuccessfullyCmd.Request request;
  @Test
  void exec() {
    try (MockedStatic<Mediator> mediator = mockStatic(Mediator.class)) {
      var now = LocalDateTime.now();
      when(request.getAdminUserId()).thenReturn(1L);
      when(request.getRefreshToken()).thenReturn("refreshToken");
      when(request.getLoginExpiryDate()).thenReturn(now);
      when(Mediator.repositories()).thenReturn(repositorySupervisor);
      when(repositorySupervisor.findOne(any())).thenReturn(Optional.of(adminUser));

      var actual = target.exec(request);

      mediator.verify(Mediator::repositories);
      verify(repositorySupervisor).findOne(any());
      verify(adminUser).loginSuccessful("refreshToken", now);

      assertTrue(actual.isSuccess());
    }
  }

  @Test
  void exec_not_found() {
    try (MockedStatic<Mediator> mediator = mockStatic(Mediator.class)) {
      when(request.getAdminUserId()).thenReturn(1L);
      when(Mediator.repositories()).thenReturn(repositorySupervisor);
      when(repositorySupervisor.findOne(any())).thenReturn(Optional.empty());

      var actual = assertThrows(KnownException.class, () -> target.exec(request));

      mediator.verify(Mediator::repositories);
      verify(repositorySupervisor).findOne(any());
      verify(adminUser, never()).loginSuccessful(any(), any());
      assertEquals("用户不存在, adminUserId=1", actual.getMessage());
    }
  }
}
