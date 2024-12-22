package com.only4.adapter.application.queries;

import com.only4.application.queries.role.GetAllRolesQry;
import com.only4.domain.aggregates.role.Role;
import com.only4.domain.aggregates.role.meta.RoleSchema;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.netcorepal.cap4j.ddd.domain.repo.RepositorySupervisor;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetAllRolesQryHandlerTest {
    @InjectMocks
    private GetAllRolesQryHandler target;
    @Mock
    private GetAllRolesQry.Request request;

    @Mock
    private Role role;

    @Mock
    private RepositorySupervisor repositorySupervisor;

    @Test
    void exec() {
        try (MockedStatic<Mediator> mediator = mockStatic(Mediator.class)) {
            when(Mediator.repositories()).thenReturn(repositorySupervisor);
            when(repositorySupervisor.find(any())).thenReturn(Collections.singletonList(role));
            val actual = target.exec(request);

            mediator.verify(Mediator::repositories);
            verify(repositorySupervisor).find(any());
            assertNotNull(actual.getRoles());
        }
    }
}
