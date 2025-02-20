package com.only4.domain.aggregates.view_history;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.netcorepal.cap4j.ddd.domain.event.DomainEventSupervisor;
import org.netcorepal.cap4j.ddd.domain.event.DomainEventSupervisorSupport;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ViewHistoryTest {

    @Spy
    private ViewHistory viewHistory;

    @Mock
    private DomainEventSupervisor eventSupervisor;

    @Test
    void testCreate() {
        try (MockedStatic<DomainEventSupervisorSupport> mockStatic = mockStatic(DomainEventSupervisorSupport.class)) {
            mockStatic.when(DomainEventSupervisorSupport::events).thenReturn(eventSupervisor);

            viewHistory.create();

            verify(eventSupervisor).attach(any(), any());
            mockStatic.verify(DomainEventSupervisorSupport::events, times(1));
        }
    }

}
