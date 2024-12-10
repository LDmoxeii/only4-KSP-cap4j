package com.only4.application.commands.role;

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
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactorySupervisor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateRoleCmdTest {

  @InjectMocks
  CreateRoleCmd.Handler target;

  @Mock
  CreateRoleCmd.Request request;

  @Mock
  AggregateFactorySupervisor factory;

  @Mock
  UnitOfWork uow;

  @Mock
  Role role;

  @Test
  void exec() {
    try (
        MockedStatic<Mediator> mediator = mockStatic(Mediator.class);
    ) {
      when(Mediator.factories()).thenReturn(factory);
      when(factory.create(any())).thenReturn(role);
      when(Mediator.uow()).thenReturn(uow);
      when(role.getId()).thenReturn(1L);

      val actual = target.exec(request);

      mediator.verify(Mediator::factories);
      verify(factory).create(any());
      mediator.verify(Mediator::uow, times(2));
      verify(uow).persist(role);
      verify(uow).save();
      verify(role).getId();

      assertEquals(role.getId(), actual.id);
    }
  }
}
