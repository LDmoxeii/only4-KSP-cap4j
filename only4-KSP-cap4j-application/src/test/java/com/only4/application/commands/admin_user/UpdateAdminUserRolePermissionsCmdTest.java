package com.only4.application.commands.admin_user;

import com.only4.common.exception.KnownException;
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

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UpdateAdminUserRolePermissionsCmdTest {

  @InjectMocks
  private UpdateAdminUserRolePermissionsCmd.Handler target;
  @Mock
  private UpdateAdminUserRolePermissionsCmd.Request request;
  @Mock
  private RepositorySupervisor supervisor;
  @Mock
  private UnitOfWork uow;
  @Mock
  private AdminUser adminUser;

  @Test
  void exec() {
    try (MockedStatic<Mediator> mediator = mockStatic(Mediator.class)) {
      when(request.getAdminUserId()).thenReturn(1L);
      when(request.getRoleId()).thenReturn(1L);
      when(request.getPermissions()).thenReturn(Collections.emptyList());
      when(Mediator.repositories()).thenReturn(supervisor);
      when(supervisor.findOne(any())).thenReturn(Optional.of(adminUser));
      when(Mediator.uow()).thenReturn(uow);

      var actual = target.exec(request);

      verify(request).getAdminUserId();
      verify(request).getRoleId();
      verify(request).getPermissions();
      mediator.verify(Mediator::repositories);
      verify(supervisor).findOne(any());
      verify(adminUser).updateRolePermissions(1L, Collections.emptyList());
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
      verify(adminUser, never()).updateRolePermissions(any(), any());
      mediator.verify(Mediator::uow, never());
      verify(uow, never()).persist(adminUser);
      verify(uow, never()).save();

      assertEquals("用户不存在, adminUserId=1", actual.getMessage());
    }
  }
}
