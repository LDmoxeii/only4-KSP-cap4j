package com.only4.domain.aggregates.tag;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.netcorepal.cap4j.ddd.domain.event.DomainEventSupervisor;
import org.netcorepal.cap4j.ddd.domain.event.DomainEventSupervisorSupport;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TagTest {

    @Spy
    private Tag tag;

    @Mock
    private DomainEventSupervisor eventSupervisor;

    @Nested
    class CreateTests {
        @Test
        void testCreate() {
            // Since the create method is empty, we just verify that it can be called without exceptions
            assertDoesNotThrow(() -> tag.create());
        }
    }

    @Nested
    class UpdateInfoTests {
        @Test
        void testUpdateInfo() {
            try (MockedStatic<DomainEventSupervisorSupport> mockStatic = mockStatic(DomainEventSupervisorSupport.class)) {
                mockStatic.when(DomainEventSupervisorSupport::events).thenReturn(eventSupervisor);

                String newName = "New Tag Name";
                String newDescription = "New Tag Description";
                String newIcon = "New Tag Icon";

                tag.updateInfo(newName, newDescription, newIcon);

                assertAll(
                        () -> assertEquals(newName, tag.getName()),
                        () -> assertEquals(newDescription, tag.getDescription()),
                        () -> assertEquals(newIcon, tag.getIcon())
                );

                verify(eventSupervisor).attach(any(), any());
                mockStatic.verify(DomainEventSupervisorSupport::events, times(1));
            }
        }
    }

    @Nested
    class UpdateRefCountTests {
        @Test
        void testUpdateRefCount() {
            int initialRefCount = 5;
            int delta = 3;
            doReturn(initialRefCount).when(tag).getRefCount();

            tag.updateRefCount(delta);

            assertEquals(initialRefCount + delta, tag.refCount);
        }
    }

    @Nested
    class DeleteTests {
        @Test
        void testDelete() {
            // Since the delete method is empty, we just verify that it can be called without exceptions
            assertDoesNotThrow(() -> tag.delete());
        }
    }
}
