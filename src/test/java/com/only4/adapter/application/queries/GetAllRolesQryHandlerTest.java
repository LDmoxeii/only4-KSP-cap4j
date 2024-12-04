package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.RoleMapper;
import com.only4.application.queries.role.GetAllRolesQry;
import com.only4.domain.aggregates.role.Role;
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
class GetAllRolesQryHandlerTest {
  @InjectMocks
  private GetAllRolesQryHandler target;
  @Mock
  private GetAllRolesQry.Request request;
  @Mock
  private RoleMapper mapper;
  @Mock
  private Role role;
  @Test
  void exec() {
    when(mapper.getAll()).thenReturn(Collections.singletonList(role));
    GetAllRolesQry.Response actual = target.exec(request);
    verify(mapper).getAll();
    assertNotNull(actual.getRoles());
  }
}
