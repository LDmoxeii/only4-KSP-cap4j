package com.only4.adapter.application.queries;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.only4.adapter.infra.mybatis.mapper.AdminUserMapper;
import com.only4.application.queries.admin_user.ExistedAdminUserByNameQryRequest;
import com.only4.application.queries.admin_user.ExistedAdminUserByNameQryResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ExistedAdminUserByNameQryHandlerTest {

  @InjectMocks
  ExistedAdminUserByNameQryHandler handler;

  @Mock
  private ExistedAdminUserByNameQryRequest request;

  @Mock
  AdminUserMapper mapper;


  @Test
  void exec_existed() {
    when(request.getName()).thenReturn("test");
    when(mapper.existedByName("test")).thenReturn(1L);
    ExistedAdminUserByNameQryResponse exec = handler.exec(request);
    verify(request).getName();
    verify(mapper).existedByName("test");
    assertTrue(exec.getExisted());
  }

  @Test
  void exec_not_existed() {
    when(request.getName()).thenReturn("test");
    when(mapper.existedByName("test")).thenReturn(0L);
    ExistedAdminUserByNameQryResponse exec = handler.exec(request);
    verify(request).getName();
    verify(mapper).existedByName(request.getName());
    assertFalse(exec.getExisted());
  }
}
