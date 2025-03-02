package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.AdminUserMapper;
import com.only4.application.queries.admin_user.AdminUserExistsByNameQry;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AdminUserExistsByNameQryHandlerTest {

  @InjectMocks
  AdminUserExistsByNameQryHandler handler;

  @Mock
  private AdminUserExistsByNameQry.Request request;

  @Mock
  AdminUserMapper mapper;


  @Test
  void exec_existed() {
    when(request.getName()).thenReturn("test");
    when(mapper.existedByName("test")).thenReturn(true);
    boolean exec = handler.byMapper(request.getName());
    verify(request).getName();
    verify(mapper).existedByName("test");
    assertTrue(exec);
  }

  @Test
  void exec_not_existed() {
    when(request.getName()).thenReturn("test");
    when(mapper.existedByName("test")).thenReturn(false);
    boolean exec = handler.byMapper(request.getName());
    verify(request).getName();
    verify(mapper).existedByName(request.getName());
    assertFalse(exec);
  }
}
