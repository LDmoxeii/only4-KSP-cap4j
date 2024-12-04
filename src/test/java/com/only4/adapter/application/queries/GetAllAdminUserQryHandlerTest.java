package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.AdminUserMapper;
import com.only4.application.queries.admin_user.GetAllAdminUserQry;
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
class GetAllAdminUserQryHandlerTest {
  @InjectMocks
  private GetAllAdminUserQryHandler target;
  @Mock
  private GetAllAdminUserQry.Request request;
  @Mock
  private AdminUserMapper mapper;
  @Mock
  private AdminUser adminUser;
  @Test
  void exec() {
    when(mapper.getAll()).thenReturn(Collections.singletonList(adminUser));
    GetAllAdminUserQry.Response actual = target.exec(request);
    verify(mapper).getAll();
    assertNotNull(actual.getAdminUsers());
  }
}
