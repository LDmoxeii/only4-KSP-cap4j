package com.only4.application.commands.role;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.only4.application._share.utils.ValidatorUtils;
import com.only4.domain.aggregates.role.Role;
import lombok.var;
import org.junit.jupiter.api.AfterEach;
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

  MockedStatic<Mediator> mediatorMockedStatic;

  MockedStatic<ValidatorUtils> validatorUtil;

  @BeforeEach
  void setUp() {
    // 测试验证器
    mediatorMockedStatic = mockStatic(Mediator.class);
    validatorUtil = mockStatic(ValidatorUtils.class);
  }

  @Test
  void exec() {
    CreateRoleCmdRequest cmd = CreateRoleCmdRequest.builder()
        .name("test")
        .description("test")
        .permissions(null)
        .build();

    var response = CreateRoleCmdResponse.builder()
        .success(true)
        .build();

    when(Mediator.factories()).thenReturn(supervisor);
    when(Mediator.uow()).thenReturn(uow);
    when(supervisor.create(any())).thenReturn(role);

    CreateRoleCmdResponse actol = handler.exec(cmd);

    validatorUtil.verify(() -> ValidatorUtils.validate(cmd));
    verify(supervisor).create(any());
    verify(uow).persist(role);
    verify(uow).save();

    assertEquals(response.success, actol.success);
  }

  @AfterEach
  void tearDown() {
    mediatorMockedStatic.close();
  }
}
