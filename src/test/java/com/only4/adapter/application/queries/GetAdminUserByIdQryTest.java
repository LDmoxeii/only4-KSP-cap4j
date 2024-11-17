package com.only4.adapter.application.queries;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.only4.adapter.infra.mybatis.mapper.AdminUserMapper;
import com.only4.application.queries.admin_user.GetAdminUserByIdQryRequest;
import com.only4.application.queries.admin_user.GetAdminUserByIdQryResponse;
import com.only4.domain.aggregates.admin_user.AdminUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class GetAdminUserByIdQryTest {

  @InjectMocks
  GetAdminUserByIdQryHandler handler;

  @Mock
  AdminUser adminUser;

  @Mock
  AdminUserMapper mapper;

  @Test
  void exec() {
    // 预期入参
    GetAdminUserByIdQryRequest request = GetAdminUserByIdQryRequest.builder().build();

    // 预期结果
    GetAdminUserByIdQryResponse expect = GetAdminUserByIdQryResponse.builder()
        .adminUser(adminUser)
        .build();

    when(mapper.getById(any())).thenReturn(adminUser);

    // 执行测试方法
    GetAdminUserByIdQryResponse result = handler.exec(request);

    verify(mapper).getById(any());

    // 验证结果
    assertEquals(expect, result);
  }

}
