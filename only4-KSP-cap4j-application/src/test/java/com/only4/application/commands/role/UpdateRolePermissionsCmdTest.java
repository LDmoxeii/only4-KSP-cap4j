package com.only4.application.commands.role;

import com.only4._share.exception.KnownException;
import com.only4.domain.aggregates.role.Role;
import lombok.val;
import org.junit.jupiter.api.Assertions;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UpdateRolePermissionsCmdTest {

  @InjectMocks
  private UpdateRolePermissionsCmd.Handler target;
  @Mock
  private RepositorySupervisor supervisor;
  @Mock
  private UnitOfWork uow;
  @Mock
  private UpdateRolePermissionsCmd.Request request;
  @Mock
  private Role role;

  @Test
  void exec() {
    try (
        MockedStatic<Mediator> mediator = mockStatic(Mediator.class)
    ) {
      when(request.getRoleId()).thenReturn(1L);
      when(request.getPermissions()).thenReturn(Collections.emptyList());
      when(Mediator.repositories()).thenReturn(supervisor);
      when(supervisor.findOne(any())).thenReturn(Optional.of(role));
      when(Mediator.uow()).thenReturn(uow);

      val actual = target.exec(request);

      mediator.verify(Mediator::repositories);
      verify(supervisor).findOne(any());
      verify(role).updateRolePermission(Collections.emptyList());
      mediator.verify(Mediator::uow, times(2));
      verify(uow).persist(role);
      verify(uow).save();

      assert actual.isSuccess();
    }

  }

  @Test
  void exec_role_not_found() {
    try (
        MockedStatic<Mediator> mediator = mockStatic(Mediator.class)
    ) {
      when(request.getRoleId()).thenReturn(1L);
      when(Mediator.repositories()).thenReturn(supervisor);
      when(supervisor.findOne(any())).thenReturn(Optional.empty());

      val actual = Assertions.assertThrows(KnownException.class, () -> target.exec(request));

      mediator.verify(Mediator::repositories);
      verify(supervisor).findOne(any());
      verify(role, never()).updateRolePermission(any());
      mediator.verify(Mediator::uow, never());
      verify(uow, never()).persist(any());
      verify(uow, never()).save();

      Assertions.assertEquals("角色不存在, roleId=1", actual.getMessage());
    }
  }
}
