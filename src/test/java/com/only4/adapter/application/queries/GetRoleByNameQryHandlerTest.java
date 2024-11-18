package com.only4.adapter.application.queries;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.only4.adapter.infra.mybatis.mapper.RoleMapper;
import com.only4.application.queries.role.GetRoleByNameQryRequest;
import com.only4.application.queries.role.GetRoleByNameQryResponse;
import com.only4.domain.aggregates.role.Role;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetRoleByNameQryHandlerTest {
  @InjectMocks
  private GetRoleByNameQryHandler target;
  @Mock
  private GetRoleByNameQryRequest request;
  @Mock
  private RoleMapper mapper;
  @Mock
  private Role role;

  @Test
  void exec() {
    when(request.getRoleName()).thenReturn("admin");
    when(mapper.getByName("admin")).thenReturn(role);
    GetRoleByNameQryResponse actual = target.exec(request);
    verify(request).getRoleName();
    verify(mapper).getByName("admin");
    assertSame(role, actual.getRole());
  }
}
