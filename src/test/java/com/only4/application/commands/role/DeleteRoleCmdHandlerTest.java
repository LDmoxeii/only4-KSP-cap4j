package com.only4.application.commands.role;

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
import com.only4.application._share.utils.ValidatorUtils;
import com.only4.domain.aggregates.role.Role;
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
class DeleteRoleCmdHandlerTest {

  @InjectMocks
  private DeleteRoleCmdHandler target;
  @Mock
  private DeleteRoleCmdRequest request;
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
        MockedStatic<ValidatorUtils> validator = mockStatic(ValidatorUtils.class)
    ) {
      when(request.getRoleId()).thenReturn(1L);
      when(Mediator.repositories()).thenReturn(supervisor);
      when(supervisor.findOne(any())).thenReturn(Optional.of(role));
      when(Mediator.uow()).thenReturn(uow);

      val actual = target.exec(request);

      validator.verify(() -> ValidatorUtils.validate(request));
      mediator.verify(Mediator::repositories);
      verify(supervisor).findOne(any());
      mediator.verify(Mediator::uow, times(2));
      verify(uow).remove(role);
      verify(uow).save();

      assertTrue(actual.success);
    }
  }

  @Test
  void exec_role_not_found() {
    try (
        MockedStatic<Mediator> mediator = mockStatic(Mediator.class);
        MockedStatic<ValidatorUtils> validator = mockStatic(ValidatorUtils.class)
    ) {
      when(request.getRoleId()).thenReturn(1L);
      when(Mediator.repositories()).thenReturn(supervisor);
      when(supervisor.findOne(any())).thenReturn(Optional.empty());

      val actual = assertThrows(KnownException.class,
          () -> target.exec(request));

      validator.verify(() -> ValidatorUtils.validate(request));
      mediator.verify(Mediator::repositories);
      verify(supervisor).findOne(any());
      mediator.verify(Mediator::uow, never());
      verify(uow, never()).remove(role);
      verify(uow, never()).save();

      assertEquals("角色不存在, roleId=1", actual.getMessage());
    }
  }
}
