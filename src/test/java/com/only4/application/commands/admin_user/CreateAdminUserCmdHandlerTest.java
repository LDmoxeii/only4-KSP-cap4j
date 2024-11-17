package com.only4.application.commands.admin_user;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.only4.application._share.utils.ValidatorUtils;
import com.only4.domain.aggregates.admin_user.AdminUser;
import com.only4.domain.aggregates.admin_user.factory.AdminUserPayload;
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
class CreateAdminUserCmdHandlerTest {

  @InjectMocks
  private CreateAdminUserCmdHandler handler;

  @Mock
  private AggregateFactorySupervisor mediatorFactory;

  @Mock
  private UnitOfWork mediatorUow;

  @Mock
  private AdminUser adminUser;

  MockedStatic<Mediator> mediatorMockedStatic;

  MockedStatic<ValidatorUtils> validatorUtil;

  @BeforeEach
  void setUp() {
    // 测试验证器
    mediatorMockedStatic = mockStatic(Mediator.class);
    validatorUtil = mockStatic(ValidatorUtils.class);
  }

  @Test
  void testExec() {
    // 准备测试数据
    CreateAdminUserCmdRequest request = new CreateAdminUserCmdRequest();

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

  @AfterEach
  void tearDown() {
    mediatorMockedStatic.close();
    validatorUtil.close();
  }
}
