package com.only4.application.commands.admin_user;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.only4._share.exception.KnownException;
import com.only4.domain.aggregates.admin_user.AdminUser;
import java.util.Optional;
import lombok.var;
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

@ExtendWith(MockitoExtension.class)
class UpdateAdminUserRoleInfoCmdHandlerTest {

  @InjectMocks
  private UpdateAdminUserRoleInfoCmdHandler target;
  @Mock
  private RepositorySupervisor supervisor;
  @Mock
  private UnitOfWork uow;
  @Mock
  private AdminUser adminUser;
  @Mock
  private UpdateAdminUserRoleInfoCmdRequest request;

  @Test
  void exec() {

    try (MockedStatic<Mediator> mediator = mockStatic(Mediator.class)) {
      when(request.getAdminUserId()).thenReturn(1L);
      when(request.getRoleId()).thenReturn(1L);
      when(request.getRoleName()).thenReturn("roleName");
      when(Mediator.repositories()).thenReturn(supervisor);
      when(supervisor.findOne(any())).thenReturn(Optional.of(adminUser));
      when(Mediator.uow()).thenReturn(uow);

      var actual = target.exec(request);

      mediator.verify(Mediator::repositories);
      verify(request).getAdminUserId();
      verify(request).getRoleId();
      verify(request).getRoleName();
      verify(supervisor).findOne(any());
      verify(adminUser).updateRoleInfo(1L, "roleName");
      mediator.verify(Mediator::uow, times(2));
      verify(uow).persist(adminUser);
      verify(uow).save();

      assertTrue(actual.isSuccess());
    }
  }

  @Test
  void exec_role_not_exist() {

    try (MockedStatic<Mediator> mediator = mockStatic(Mediator.class)) {
      when(request.getAdminUserId()).thenReturn(1L);
      when(Mediator.repositories()).thenReturn(supervisor);
      when(supervisor.findOne(any())).thenReturn(Optional.empty());

      var actual = Assertions.assertThrows(KnownException.class, () -> target.exec(request));

      mediator.verify(Mediator::repositories);
      verify(request, times(2)).getAdminUserId();
      verify(supervisor).findOne(any());
      verify(adminUser, never()).updateRoleInfo(any(),any());
      mediator.verify(Mediator::uow, never());
      verify(uow, never()).persist(any());
      verify(uow, never()).save();

      Assertions.assertEquals("用户不存在, adminUserId=1", actual.getMessage());
    }
  }
}
