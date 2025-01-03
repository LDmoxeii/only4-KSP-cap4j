package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.RoleMapper;
import com.only4.application.queries.role.GetRolesByConditionQry;
import com.only4.domain.aggregates.role.Role;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetRolesByConditionQryHandlerTest {
  @InjectMocks
  private GetRolesByConditionQryHandler target;
  @Mock
  private GetRolesByConditionQry.Request request;
  @Mock
  private RoleMapper mapper;
  @Mock
  private Role role;

  @Test
  void exec() {
    when(request.getName()).thenReturn("test");
    when(request.getDescription()).thenReturn("test");
    when(mapper.getByCondition("test","test")).thenReturn(singletonList(role));
    GetRolesByConditionQry.Response actual = target.exec(request);
    verify(request).getName();
    verify(request).getDescription();
    verify(mapper).getByCondition("test","test");
    assertNotNull(actual);
  }
}
