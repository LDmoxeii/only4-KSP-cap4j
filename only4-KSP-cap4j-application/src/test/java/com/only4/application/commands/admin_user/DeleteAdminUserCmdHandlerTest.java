package com.only4.application.commands.admin_user;

import com.only4.common.exception.KnownException;
import com.only4.domain.aggregates.admin_user.AdminUser;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.UnitOfWork;
import org.netcorepal.cap4j.ddd.domain.repo.RepositorySupervisor;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeleteAdminUserCmdHandlerTest {

    @InjectMocks
    DeleteAdminUserCmd.Handler handler;

    @Mock
    RepositorySupervisor supervisor;

    @Mock
    UnitOfWork uow;
    @Mock
    private DeleteAdminUserCmd.Request request;

    @Mock
    private AdminUser adminUser;

    @Test
    void execSuccess() {

        try (MockedStatic<Mediator> mediator = mockStatic(Mediator.class)) {
            when(request.getAdminUserId()).thenReturn(1L);
            when(Mediator.repositories()).thenReturn(supervisor);
            when(supervisor.findOne(any())).thenReturn(Optional.of(adminUser));
            when(Mediator.uow()).thenReturn(uow);

            val actual = handler.exec(request);

            mediator.verify(Mediator::repositories);
            verify(supervisor).findOne(any());
            verify(adminUser).delete();
            mediator.verify(Mediator::uow, times(2));
            verify(uow).remove(adminUser);
            verify(uow).save();

            assertTrue(actual.isSuccess());
        }
    }

    @Test
    void execFail() {
        try (MockedStatic<Mediator> mediator = mockStatic(Mediator.class)) {
            when(Mediator.repositories()).thenReturn(supervisor);
            when(supervisor.findOne(any())).thenReturn(Optional.empty());

            val actual = assertThrows(KnownException.class, () -> handler.exec(request));

            mediator.verify(Mediator::repositories);
            verify(request, times(2)).getAdminUserId();
            verify(supervisor).findOne(any());
            verify(adminUser, never()).delete();
            verify(uow, never()).remove(adminUser);
            verify(uow, never()).save();

            assertTrue(actual.getMessage().contains("用户不存在"));
        }
    }

}
