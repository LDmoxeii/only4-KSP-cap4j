package com.only4.adapter.application.queries;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.only4.adapter.infra.mybatis.mapper.AdminUserMapper;
import com.only4.application.queries.admin_user.GetAllAdminUserQryRequest;
import com.only4.application.queries.admin_user.GetAllAdminUserQryResponse;
import com.only4.domain.aggregates.admin_user.AdminUser;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetAllAdminUserQryHandlerTest {
  @InjectMocks
  private GetAllAdminUserQryHandler target;
  @Mock
  private GetAllAdminUserQryRequest request;
  @Mock
  private AdminUserMapper mapper;
  @Mock
  private AdminUser adminUser;
  @Test
  void exec() {
    when(mapper.getAll()).thenReturn(Collections.singletonList(adminUser));
    GetAllAdminUserQryResponse actual = target.exec(request);
    verify(mapper).getAll();
    assertNotNull(actual.getAdminUsers());
  }
}
