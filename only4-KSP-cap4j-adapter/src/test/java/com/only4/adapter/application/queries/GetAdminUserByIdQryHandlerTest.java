package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.AdminUserMapper;
import com.only4.application.queries.admin_user.GetAdminUserByIdQry;
import com.only4.domain.aggregates.admin_user.AdminUser;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class GetAdminUserByIdQryHandlerTest {

  @InjectMocks
  GetAdminUserByIdQryHandler handler;

  @Mock
  AdminUserMapper mapper;

  @Test
  void exec() {
    // 预期入参
    GetAdminUserByIdQry.Request request = GetAdminUserByIdQry.Request.builder().build();

    // 预期结果
    AdminUser adminUser = AdminUser.builder().build();


    when(mapper.getById(any())).thenReturn(adminUser);

    // 执行测试方法
    val result = handler.byMybatis(request.getAdminUserId());

    verify(mapper).getById(any());

    // 验证结果
    assertEquals(adminUser, result);
  }

}
