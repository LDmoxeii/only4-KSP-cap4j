package com.only4.adapter.application.queries;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.only4.adapter.infra.mybatis.mapper.RoleMapper;
import com.only4.application.queries.role.GetRolesByIdQryRequest;
import com.only4.application.queries.role.GetRolesByIdQryResponse;
import com.only4.domain.aggregates.role.Role;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetRolesByIdQryHandlerTest {
  @InjectMocks
  private GetRolesByIdQryHandler target;
  @Mock
  private GetRolesByIdQryRequest request;
  @Mock
  private RoleMapper mapper;
  @Mock
  private Role role;
  @Test
  void exec() {
    when(request.getId()).thenReturn(1L);
    when(mapper.getById(1L)).thenReturn(role);
    GetRolesByIdQryResponse actual = target.exec(request);
    verify(request).getId();
    verify(mapper).getById(1L);
    assertSame(role, actual.getRole());
  }
}
