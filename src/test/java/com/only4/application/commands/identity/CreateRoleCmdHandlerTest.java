package com.only4.application.commands.identity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.only4.application._share.utils.ValidatorUtils;
import com.only4.domain.aggregates.role.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.UnitOfWork;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactorySupervisor;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CreateRoleCmdHandlerTest {
  @InjectMocks
  CreateRoleCmdHandler handler;

  @Mock
  AggregateFactorySupervisor supervisor;

  @Mock
  UnitOfWork uow;

  @Mock
  Role role;

  @BeforeEach
  void setUp() {
    mockStatic(Mediator.class);
    when(Mediator.factories()).thenReturn(supervisor);
    when(Mediator.uow()).thenReturn(uow);
  }

  @Test
  void exec() {
    CreateRoleCmdRequest cmd = CreateRoleCmdRequest.builder()
        .name("test")
        .description("test")
        .permissions(null)
        .build();

    CreateAdminUserCmdResponse response = CreateAdminUserCmdResponse.builder()
        .success(true)
        .build();
    MockedStatic<ValidatorUtils> validatorUtils = mockStatic(ValidatorUtils.class);
    when(supervisor.create(any())).thenReturn(role);

    CreateRoleCmdResponse actol = handler.exec(cmd);

    validatorUtils.verify(() -> ValidatorUtils.validate(cmd));
    verify(supervisor).create(any());
    verify(uow).persist(role);
    verify(uow).save();

    assertEquals(response.success, actol.success);
  }
}
