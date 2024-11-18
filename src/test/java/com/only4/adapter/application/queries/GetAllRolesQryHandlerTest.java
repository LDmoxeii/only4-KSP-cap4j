package com.only4.adapter.application.queries;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.only4.adapter.infra.mybatis.mapper.RoleMapper;
import com.only4.application.queries.role.GetAllRolesQryRequest;
import com.only4.application.queries.role.GetAllRolesQryResponse;
import com.only4.domain.aggregates.role.Role;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetAllRolesQryHandlerTest {
  @InjectMocks
  private GetAllRolesQryHandler target;
  @Mock
  private GetAllRolesQryRequest request;
  @Mock
  private RoleMapper mapper;
  @Mock
  private Role role;
  @Test
  void exec() {
    when(mapper.getAll()).thenReturn(Collections.singletonList(role));
    GetAllRolesQryResponse actual = target.exec(request);
    verify(mapper).getAll();
    assertNotNull(actual.getRoles());
  }
}
