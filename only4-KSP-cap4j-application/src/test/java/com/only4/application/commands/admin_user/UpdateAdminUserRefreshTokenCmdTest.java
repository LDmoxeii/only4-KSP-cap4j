package com.only4.application.commands.admin_user;

import com.only4._share.exception.KnownException;
import com.only4.domain.aggregates.admin_user.AdminUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.UnitOfWork;
import org.netcorepal.cap4j.ddd.domain.repo.RepositorySupervisor;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UpdateAdminUserRefreshTokenCmdTest {

  @InjectMocks
  private UpdateAdminUserRefreshTokenCmd.Handler target;
  @Mock
  private UpdateAdminUserRefreshTokenCmd.Request request;
  @Mock
  private RepositorySupervisor supervisor;
  @Mock
  private UnitOfWork uow;
  @Mock
  private AdminUser adminUser;

  @Test
  void exec_success() {
    try (MockedStatic<Mediator> mediator = mockStatic(Mediator.class)) {
      when(request.getAdminUserId()).thenReturn(1L);
      when(request.getRefreshToken()).thenReturn("token");
      when(Mediator.repositories()).thenReturn(supervisor);
      when(supervisor.findOne(any())).thenReturn(Optional.of(adminUser));
      when(Mediator.uow()).thenReturn(uow);

      var actual = target.exec(request);

      verify(request).getAdminUserId();
      verify(request).getRefreshToken();
      mediator.verify(Mediator::repositories);
      verify(supervisor).findOne(any());
      verify(adminUser).updateRefreshToken("token");
      mediator.verify(Mediator::uow, times(2));
      verify(uow).persist(adminUser);
      verify(uow).save();

      assertTrue(actual.isSuccess());
    }
  }

  @Test
  void exec_not_found() {
    try (MockedStatic<Mediator> mediator = mockStatic(Mediator.class)) {
      when(request.getAdminUserId()).thenReturn(1L);
      when(Mediator.repositories()).thenReturn(supervisor);
      when(supervisor.findOne(any())).thenReturn(Optional.empty());

      var actual = assertThrows(KnownException.class, () -> target.exec(request));

      mediator.verify(Mediator::repositories);
      verify(request, times(2)).getAdminUserId();
      verify(supervisor).findOne(any());
      verify(request, never()).getRefreshToken();
      verify(adminUser, never()).updateRoles(any());
      mediator.verify(Mediator::uow, never());
      verify(uow, never()).persist(any());
      verify(uow, never()).save();

      assertEquals("用户不存在, adminUserId=1", actual.getMsg());
    }

  }
}
