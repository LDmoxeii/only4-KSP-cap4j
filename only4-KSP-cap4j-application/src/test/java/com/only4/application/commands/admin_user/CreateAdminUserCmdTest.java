package com.only4.application.commands.admin_user;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;
import com.only4.domain.aggregates.admin_user.AdminUser;
import com.only4.domain.aggregates.admin_user.factory.AdminUserFactory;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateAdminUserCmdTest {

    @InjectMocks
    private CreateAdminUserCmd.Handler handler;

    @Mock
    private AggregateFactorySupervisor factory;

    @Mock
    private UnitOfWork uow;

    @Mock
    private AdminUser adminUser;

    @Mock
    private CreateAdminUserCmd.Request request;

    @Test
    void testExec() {
        try (
                MockedStatic<Mediator> mediator = mockStatic(Mediator.class)
        ) {
            when(request.getName()).thenReturn("testName");
            when(request.getPhone()).thenReturn("testPhone");
            when(request.getPassword()).thenReturn("testPassword");
            when(request.getRolesToBeAssigned()).thenReturn(Collections.emptyList());
            when(Mediator.factories()).thenReturn(factory);
            when(factory.create(any(AdminUserFactory.Payload.class))).thenReturn(adminUser);
            when(Mediator.uow()).thenReturn(uow);

            // 执行方法
            val actual = handler.exec(request);

            mediator.verify(Mediator::factories);
            verify(factory).create(any(AdminUserFactory.Payload.class));
            mediator.verify(Mediator::uow, times(2));
            verify(uow).persist(adminUser);
            verify(uow).save();

            // 验证结果
            assertTrue(actual.isSuccess());
            assertEquals(adminUser.getId(), actual.getId());
        }
    }

    @Test
    void exec() throws IOException {
        BufferedReader reader = ResourceUtil.getReader("create_admin_user_cmd_request.json", StandardCharsets.UTF_8);
        String s = reader.readLine();
        CreateAdminUserCmd.Request createAdminUserCmdRequest = JSONUtil.toBean(s, CreateAdminUserCmd.Request.class);

        try (
                MockedStatic<Mediator> mediator = mockStatic(Mediator.class)
        ) {
            when(Mediator.factories()).thenReturn(factory);
            when(factory.create(any(AdminUserFactory.Payload.class))).thenReturn(adminUser);
            when(Mediator.uow()).thenReturn(uow);

            // 执行方法
            assert createAdminUserCmdRequest != null;
            val actual = handler.exec(createAdminUserCmdRequest);

            mediator.verify(Mediator::factories);
            verify(factory).create(any(AdminUserFactory.Payload.class));
            mediator.verify(Mediator::uow, times(2));
            verify(uow).persist(adminUser);
            verify(uow).save();

            // 验证结果
            assertTrue(actual.isSuccess());
            assertEquals(adminUser.getId(), actual.getId());
        }
    }
}
