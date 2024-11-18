package com.only4.application.commands.admin_user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.only4.application._share.utils.ValidatorUtils;
import com.only4.domain.aggregates.admin_user.AdminUser;
import com.only4.domain.aggregates.admin_user.factory.AdminUserPayload;
import java.util.Collections;
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

@ExtendWith(MockitoExtension.class)
class CreateAdminUserCmdHandlerTest {

  @InjectMocks
  private CreateAdminUserCmdHandler handler;

  @Mock
  private AggregateFactorySupervisor factory;

  @Mock
  private UnitOfWork uow;

  @Mock
  private AdminUser adminUser;

  @Mock
  private CreateAdminUserCmdRequest request;

  @Test
  void testExec() {
    try (
        MockedStatic<Mediator> mediator = mockStatic(Mediator.class);
        MockedStatic<ValidatorUtils> validatorUtil = mockStatic(ValidatorUtils.class)
    ) {
      when(request.getName()).thenReturn("testName");
      when(request.getPhone()).thenReturn("testPhone");
      when(request.getPassword()).thenReturn("testPassword");
      when(request.getRolesToBeAssigned()).thenReturn(Collections.emptyList());
      when(Mediator.factories()).thenReturn(factory);
      when(factory.create(any(AdminUserPayload.class))).thenReturn(adminUser);
      when(Mediator.uow()).thenReturn(uow);

      // 执行方法
      val actual = handler.exec(request);

      validatorUtil.verify(() -> ValidatorUtils.validate(request));
      mediator.verify(Mediator::factories);
      verify(factory).create(any(AdminUserPayload.class));
      mediator.verify(Mediator::uow, times(2));
      verify(uow).persist(adminUser);
      verify(uow).save();

      // 验证结果
      assertTrue(actual.isSuccess());
      assertEquals(adminUser.getId(), actual.getId());
    }
  }
}
