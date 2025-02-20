package com.only4.domain.aggregates.category;

import com.only4._share.exception.KnownException;
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
class CategoryTest {

    @Spy
    private Category category;

    @Mock
    private DomainEventSupervisor eventSupervisor;

    @Nested
    class CreateTests {
        @Test
        void testCreate() {
            // Since the create method is empty, we just verify that it can be called without exceptions
            assertDoesNotThrow(() -> category.create());
        }
    }

    @Nested
    class UpdateInfoTests {
        @Test
        void testUpdateInfo() {
            try (MockedStatic<DomainEventSupervisorSupport> mockStatic = mockStatic(DomainEventSupervisorSupport.class)) {
                mockStatic.when(DomainEventSupervisorSupport::events).thenReturn(eventSupervisor);

                String newCategoryName = "New Category Name";
                category.updateInfo(newCategoryName);

                assertEquals(newCategoryName, category.getName());
                verify(eventSupervisor).attach(any(), any());
                mockStatic.verify(DomainEventSupervisorSupport::events, times(1));
            }
        }
    }

    @Nested
    class DeleteTests {
        @Test
        void testDelete() {
            doReturn(0).when(category).getRefCount();

            category.delete();

            assertTrue(category.getDelFlag());
        }

        @Test
        void testDeleteWithRefCount() {
            doReturn(1).when(category).getRefCount();

            KnownException exception = assertThrows(KnownException.class,
                    () -> category.delete());
            assertEquals("该分类已被引用，不能删除！", exception.getMessage());
        }
    }

    @Nested
    class UpdateRefCountTests {
        @Test
        void testUpdateRefCount() {
            int initialRefCount = 5;
            int delta = 3;
            doReturn(initialRefCount).when(category).getRefCount();

            category.updateRefCount(delta);

            assertEquals(initialRefCount + delta, category.refCount);
        }
    }
}
