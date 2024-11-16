package com.only4.application.commands.identity;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.only4.application._share.utils.ValidatorUtils;
import com.only4.domain.aggregates.admin_user.AdminUser;
import com.only4.domain.aggregates.admin_user.factory.AdminUserPayload;
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
  private AggregateFactorySupervisor mediatorFactory;

  @Mock
  private UnitOfWork mediatorUow;

  @Mock
  private AdminUser adminUser;

  @Test
  void testExec() {
    // 准备测试数据
    CreateAdminUserCmdRequest request = new CreateAdminUserCmdRequest();

    // 测试验证器
    mockStatic(Mediator.class);
    MockedStatic<ValidatorUtils> validatorUtil = mockStatic(ValidatorUtils.class);

    when(Mediator.factories()).thenReturn(mediatorFactory);
    when(Mediator.uow()).thenReturn(mediatorUow);
    when(mediatorFactory.create(any(AdminUserPayload.class))).thenReturn(adminUser);

    // 执行方法
    CreateAdminUserCmdResponse response = handler.exec(request);

    validatorUtil.verify(() -> ValidatorUtils.validate(request));
    verify(mediatorFactory).create(any(AdminUserPayload.class));
    verify(mediatorUow).persist(adminUser);
    verify(mediatorUow).save();

    // 验证结果
    assertTrue(response.isSuccess());

  }
}
