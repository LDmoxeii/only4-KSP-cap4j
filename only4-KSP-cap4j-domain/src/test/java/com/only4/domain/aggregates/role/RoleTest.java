package com.only4.domain.aggregates.role;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.netcorepal.cap4j.ddd.domain.event.DomainEventSupervisor;
import org.netcorepal.cap4j.ddd.domain.event.DomainEventSupervisorSupport;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoleTest {

    @Spy
    private Role role;

    @Mock
    private DomainEventSupervisor eventSupervisor;

    @Mock
    private RolePermission rolePermission;

    @Nested
    class CreateTests {
        @Test
        void testCreate() {
            // Since the create method is empty, we just verify that it can be called without exceptions
            assertDoesNotThrow(() -> role.create());
        }
    }

    @Nested
    class UpdateRoleInfoTests {
        @Test
        void testUpdateRoleInfo() {
            try (MockedStatic<DomainEventSupervisorSupport> mockStatic = mockStatic(DomainEventSupervisorSupport.class)) {
                mockStatic.when(DomainEventSupervisorSupport::events).thenReturn(eventSupervisor);

                String newName = "New Role Name";
                String newDescription = "New Role Description";

                role.updateRoleInfo(newName, newDescription);

                assertAll(
                        () -> assertEquals(newName, role.getName()),
                        () -> assertEquals(newDescription, role.getDescription())
                );

                verify(eventSupervisor).attach(any(), any());
                mockStatic.verify(DomainEventSupervisorSupport::events, times(1));
            }
        }
    }

    @Nested
    class UpdateRolePermissionTests {
        @Test
        void testUpdateRolePermission() {
            try (MockedStatic<DomainEventSupervisorSupport> mockStatic = mockStatic(DomainEventSupervisorSupport.class)) {
                mockStatic.when(DomainEventSupervisorSupport::events).thenReturn(eventSupervisor);

                List<RolePermission> newPermissions = new ArrayList<>();
                newPermissions.add(RolePermission.builder().permissionCode("PERMISSION_1").build());

                List<RolePermission> currentPermissions = new ArrayList<>();
                currentPermissions.add(RolePermission.builder().permissionCode("PERMISSION_2").build());
                doReturn(currentPermissions).when(role).getRolePermissions();

                role.updateRolePermission(newPermissions);

                assertEquals(1, role.getRolePermissions().size());
                assertEquals("PERMISSION_1", role.getRolePermissions().get(0).getPermissionCode());

                verify(eventSupervisor).attach(any(), any());
                mockStatic.verify(DomainEventSupervisorSupport::events, times(1));
            }
        }
    }

    @Nested
    class DeleteTests {
        @Test
        void testDelete() {
            // Since the delete method is empty, we just verify that it can be called without exceptions
            assertDoesNotThrow(() -> role.delete());
        }
    }
}
