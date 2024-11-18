package com.only4.application.commands.admin_user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.only4._share.exception.KnownException;
import com.only4.domain.aggregates.admin_user.AdminUser;
import com.only4.domain.aggregates.admin_user.AppDefaultCredentials;
import java.util.Optional;
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
class DeleteAdminUserCmdHandlerTest {

  @InjectMocks
  DeleteAdminUserCmdHandler handler;

  @Mock
  RepositorySupervisor supervisor;

  @Mock
  UnitOfWork uow;

  @Test
  void execSuccess() {
    DeleteAdminUserCmdRequest request = DeleteAdminUserCmdRequest.builder().build();
    DeleteAdminUserCmdResponse response = DeleteAdminUserCmdResponse.builder()
        .success(true)
        .build();

    AdminUser adminUser = AdminUser.builder()
        .isDeleted(false)
        .build();
    try (MockedStatic<Mediator> ignored = mockStatic(Mediator.class)) {
      when(Mediator.repositories()).thenReturn(supervisor);
      when(supervisor.findOne(any())).thenReturn(Optional.of(adminUser));
      when(Mediator.uow()).thenReturn(uow);

      DeleteAdminUserCmdResponse actual = handler.exec(request);

      verify(supervisor).findOne(any());
      verify(uow).remove(adminUser);
      verify(uow).save();

      assertEquals(response, actual);
    }
  }

  @Test
  void execFail() {
    DeleteAdminUserCmdRequest request = DeleteAdminUserCmdRequest.builder().build();
    AdminUser adminUser = AdminUser.builder()
        .isDeleted(false)
        .build();
    try (MockedStatic<Mediator> ignored = mockStatic(Mediator.class)) {
      when(Mediator.repositories()).thenReturn(supervisor);
      when(supervisor.findOne(any())).thenReturn(Optional.empty());

      KnownException knownException = assertThrows(KnownException.class,
          () -> handler.exec(request));

      verify(uow, never()).remove(adminUser);
      verify(uow, never()).save();

      assertFalse(adminUser.getIsDeleted());
      assertTrue(knownException.getMessage().contains("用户不存在"));
    }
  }

  @Test
  void execFail2() {
    DeleteAdminUserCmdRequest request = DeleteAdminUserCmdRequest.builder().build();
    AdminUser adminUser = AdminUser.builder().name("admin@d3shop.com").build();
    try (MockedStatic<Mediator> ignored = mockStatic(Mediator.class)) {
      when(Mediator.repositories()).thenReturn(supervisor);
      when(supervisor.findOne(any())).thenReturn(Optional.of(adminUser));
      when(Mediator.uow()).thenReturn(uow);

      KnownException knownException = assertThrows(KnownException.class,
          () -> handler.exec(request));

      verify(supervisor).findOne(any());
      verify(uow, never()).remove(adminUser);
      verify(uow, never()).save();

      assertEquals(AppDefaultCredentials.NAME, adminUser.getName());
      assertTrue(knownException.getMessage().contains("默认账号不允许删除"));
    }
  }

}
