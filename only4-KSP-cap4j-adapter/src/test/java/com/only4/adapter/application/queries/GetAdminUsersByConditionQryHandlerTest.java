package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.AdminUserMapper;
import com.only4.application.queries.admin_user.GetAdminUsersByConditionQry;
import com.only4.domain.aggregates.admin_user.AdminUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetAdminUsersByConditionQryHandlerTest {
  @InjectMocks
  private GetAdminUsersByConditionQryHandler target;
  @Mock
  private GetAdminUsersByConditionQry.Request request;
  @Mock
  private AdminUserMapper mapper;
  @Mock
  private AdminUser adminUser;

  @Test
  void exec() {

    when(request.getName()).thenReturn("name");
    when(request.getPhone()).thenReturn("11111111111");
    when(mapper.getByCondition("name","11111111111")).thenReturn(Collections.singletonList(adminUser));
    GetAdminUsersByConditionQry.Response actual = target.exec(request);
    verify(request).getName();
    verify(request).getPhone();
    verify(mapper).getByCondition("name","11111111111");
    assertNotNull(actual.getAdminUsers());
  }
}
