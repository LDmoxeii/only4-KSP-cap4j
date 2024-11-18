package com.only4.application.commands.admin_user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

@ExtendWith(MockitoExtension.class)
class UpdateAdminUserPasswordCmdHandlerTest {

  @InjectMocks
  private UpdateAdminUserPasswordCmdHandler target;
  @Mock
  private UpdateAdminUserPasswordCmdRequest request;
  @Mock
  private RepositorySupervisor supervisor;
  @Mock
  private UnitOfWork uow;
  @Mock
  private AdminUser adminUser;
  @Test
  void exec_success() {
    try (
        MockedStatic<Mediator> mediator = mockStatic(Mediator.class)
    ) {
      when(request.getAdminUserId()).thenReturn(1L);
      when(request.getNewPassword()).thenReturn("123");
      when(Mediator.repositories()).thenReturn(supervisor);
      when(supervisor.findOne(any())).thenReturn(Optional.of(adminUser));
      when(Mediator.uow()).thenReturn(uow);

      val actual = target.exec(request);

      verify(request).getAdminUserId();
      verify(request).getNewPassword();
      mediator.verify(Mediator::repositories);
      mediator.verify(Mediator::uow, times(2));
      verify(supervisor).findOne(any());
      verify(adminUser).updatePassword("123");
      verify(uow).persist(adminUser);
      verify(uow).save();

      assertTrue(actual.success);
    }
  }

  @Test
  void exec_fail() {
    try (
        MockedStatic<Mediator> mediator = mockStatic(Mediator.class)
    ) {
      when(request.getAdminUserId()).thenReturn(1L);
      when(Mediator.repositories()).thenReturn(supervisor);
      when(supervisor.findOne(any())).thenReturn(Optional.empty());

      val actual = assertThrows(KnownException.class, () -> target.exec(request));

      verify(request, times(2)).getAdminUserId();
      verify(supervisor).findOne(any());
      verify(adminUser, never()).updatePassword(any());
      mediator.verify(Mediator::uow, never());
      verify(uow, never()).persist(any());
      verify(uow, never()).save();

      assertEquals("用户不存在, adminUserId=1", actual.getMessage());
    }
  }
}
