package com.only4.application.commands.role;

import com.only4.common.exception.KnownException;
import com.only4.domain.aggregates.role.Role;
import lombok.val;
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
class UpdateRoleInfoCmdTest {
  @InjectMocks
  private UpdateRoleInfoCmd.Handler target;
  @Mock
  private UpdateRoleInfoCmd.Request request;
  @Mock
  private RepositorySupervisor supervisor;
  @Mock
  private UnitOfWork uow;
  @Mock
  private Role role;

  @Test
  void exec() {
    try (
        MockedStatic<Mediator> mediator = mockStatic(Mediator.class);
    ) {
      when(request.getRoleId()).thenReturn(1L);
      when(request.getName()).thenReturn("roleName");
      when(request.getDescription()).thenReturn("test");
      when(Mediator.repositories()).thenReturn(supervisor);
      when(supervisor.findOne(any())).thenReturn(Optional.of(role));
      when(Mediator.uow()).thenReturn(uow);

      val actual = target.exec(request);

      mediator.verify(Mediator::repositories);
      verify(supervisor).findOne(any());
      verify(role).updateRoleInfo("roleName", "test");
      mediator.verify(Mediator::uow, times(2));
      verify(uow).persist(role);
      verify(uow).save();

      assertTrue(actual.isSuccess());
    }
  }

  @Test
  void exec_role_not_exist() {
    try (
        MockedStatic<Mediator> mediator = mockStatic(Mediator.class);
    ) {
      when(request.getRoleId()).thenReturn(1L);
      when(Mediator.repositories()).thenReturn(supervisor);
      when(supervisor.findOne(any())).thenReturn(Optional.empty());

      val actual = assertThrows(KnownException.class, () -> target.exec(request));

      mediator.verify(Mediator::repositories);
      verify(supervisor).findOne(any());
      mediator.verify(Mediator::uow, never());
      verify(uow, never()).persist(any());
      verify(uow, never()).save();

      assertEquals("角色不存在, roleId=1", actual.getMessage());
    }
  }
}
