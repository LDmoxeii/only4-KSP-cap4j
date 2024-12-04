package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.AdminUserMapper;
import com.only4.application.queries.admin_user.GetAdminUserByRoleIdQry;
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
class GetAdminUserByRoleIdQryHandlerTest {

  @InjectMocks
  private GetAdminUserByRoleIdQryHandler target;
  @Mock
  private GetAdminUserByRoleIdQry.Request request;
  @Mock
  private AdminUserMapper mapper;
  @Mock
  private AdminUser adminUser;

  @Test
  void exec() {
    when(request.getId()).thenReturn(1L);
    when(mapper.getByRoleId(1L)).thenReturn(Collections.singletonList(adminUser));
    GetAdminUserByRoleIdQry.Response actual = target.exec(request);
    verify(request).getId();
    verify(mapper).getByRoleId(1L);
    assertNotNull(actual.getAdminUsers());
  }
}
