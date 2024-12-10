package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.RoleMapper;
import com.only4.application.queries.role.ExistedRoleByNameQry;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExistedRoleByNameQryHandlerTest {
  @InjectMocks
  private ExistedRoleByNameQryHandler target;

  @Mock
  private ExistedRoleByNameQry.Request request;

  @Mock
  private RoleMapper mapper;

  @Test
  void exec_existed() {
    when(request.getName()).thenReturn("test");
    when(mapper.existByName("test")).thenReturn(1L);

    ExistedRoleByNameQry.Response result = target.exec(request);

    verify(mapper).existByName(any());
    assertTrue(result.getExisted());
  }

  @Test
  void exec_not_existed() {
    when(request.getName()).thenReturn("test");
    when(mapper.existByName("test")).thenReturn(0L);

    ExistedRoleByNameQry.Response result = target.exec(request);

    verify(mapper).existByName(any());
    assertFalse(result.getExisted());
  }
}
