package com.only4.application.commands.admin_user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import com.only4._share.exception.KnownException;
import com.only4.domain.aggregates.admin_user.AdminUser;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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

  @Mock
  AdminUser adminUser;

  MockedStatic<Mediator> mediatorMockedStatic;

  @BeforeEach
  void setup() {
    mediatorMockedStatic = mockStatic(Mediator.class);

  }

  @Test
  void execSuccess() {
    DeleteAdminUserCmdRequest request = DeleteAdminUserCmdRequest.builder().build();
    DeleteAdminUserCmdResponse response = DeleteAdminUserCmdResponse.builder()
        .success(true)
        .build();

    when(Mediator.repositories())
        .thenReturn(supervisor);
    when(Mediator.uow())
        .thenReturn(uow);
    when(supervisor.findOne(any()))
        .thenReturn(Optional.of(adminUser));

    DeleteAdminUserCmdResponse actual = handler.exec(request);

    verify(supervisor).findOne(any());
    verify(uow).remove(adminUser);
    verify(uow).save();

    assertEquals(response, actual);
  }

  @Test
  void execFail() {
    DeleteAdminUserCmdRequest request = DeleteAdminUserCmdRequest.builder().build();
    when(Mediator.repositories())
        .thenReturn(supervisor);
    when(Mediator.uow())
        .thenReturn(uow);
    when(supervisor.findOne(any()))
        .thenReturn(Optional.empty());

    KnownException knownException = assertThrows(KnownException.class, () -> handler.exec(request));

    assertTrue(knownException.getMessage().contains("用户不存在"));

    verify(supervisor).findOne(any());
    verifyNoInteractions(uow);
  }

  @Test
  void execFail2() {
    DeleteAdminUserCmdRequest request = DeleteAdminUserCmdRequest.builder().build();
    AdminUser build = AdminUser.builder().name("admin@d3shop.com").build();
    when(Mediator.repositories())
        .thenReturn(supervisor);
    when(Mediator.uow())
        .thenReturn(uow);
    when(supervisor.findOne(any()))
        .thenReturn(Optional.of(build))
        .thenThrow(KnownException.class);

    KnownException knownException = assertThrows(KnownException.class, () -> handler.exec(request));
    assertTrue(knownException.getMessage().contains("默认账号不允许删除"));

    verify(supervisor).findOne(any());
    verifyNoInteractions(uow);
  }

  @AfterEach
  void tearDown() {
    mediatorMockedStatic.close();
  }

}
