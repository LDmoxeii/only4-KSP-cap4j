package com.only4.application.commands.role;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.only4.application._share.utils.ValidatorUtils;
import com.only4.domain.aggregates.role.Role;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.UnitOfWork;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactorySupervisor;

@ExtendWith(MockitoExtension.class)
class CreateRoleCmdHandlerTest {

  @InjectMocks
  CreateRoleCmdHandler handler;

  @Mock
  CreateRoleCmdRequest cmd;

  @Mock
  AggregateFactorySupervisor supervisor;

  @Mock
  UnitOfWork uow;

  @Mock
  Role role;

  @Test
  void exec() {
    var response = CreateRoleCmdResponse.builder()
        .success(true)
        .build();
    try (
        MockedStatic<Mediator> ignored = mockStatic(Mediator.class);
        MockedStatic<ValidatorUtils> validatorUtil = mockStatic(ValidatorUtils.class)
    ) {
      when(Mediator.factories()).thenReturn(supervisor);
      when(supervisor.create(any())).thenReturn(role);
      when(Mediator.uow()).thenReturn(uow);

      CreateRoleCmdResponse actol = handler.exec(cmd);

      validatorUtil.verify(() -> ValidatorUtils.validate(cmd));
      verify(supervisor).create(any());
      verify(uow).persist(role);
      verify(uow).save();

      assertEquals(response.success, actol.success);
    }
  }
}
