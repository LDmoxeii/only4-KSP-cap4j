package com.only4.adapter.application.queries;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.only4.adapter.infra.mybatis.mapper.AdminUserMapper;
import com.only4.application.queries.admin_user.ExistedAdminUserByRoleIdQryRequest;
import com.only4.application.queries.admin_user.ExistedAdminUserByRoleIdQryResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ExistedAdminUserByRoleIdQryHandlerTest {

  @InjectMocks
  private ExistedAdminUserByRoleIdQryHandler target;

  @Mock
  private ExistedAdminUserByRoleIdQryRequest request;

  @Mock
  private AdminUserMapper mapper;

  @Test
  void exec_existed() {
    when(request.getRoleId()).thenReturn(1L);
    when(mapper.existedByRoleId(1L)).thenReturn(1L);
    ExistedAdminUserByRoleIdQryResponse exec = target.exec(request);

    verify(mapper).existedByRoleId(1L);

    assertTrue(exec.getExisted());
  }

  @Test
  void exec_not_existed() {
    when(request.getRoleId()).thenReturn(1L);
    when(mapper.existedByRoleId(1L)).thenReturn(0L);
    ExistedAdminUserByRoleIdQryResponse exec = target.exec(request);

    verify(mapper).existedByRoleId(1L);

    assertFalse(exec.getExisted());
  }
}
