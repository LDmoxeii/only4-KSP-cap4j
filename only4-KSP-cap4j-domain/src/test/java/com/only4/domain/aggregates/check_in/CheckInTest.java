package com.only4.domain.aggregates.check_in;

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
class CheckInTest {

    @Spy
    private CheckIn article;

    @Mock
    private DomainEventSupervisor eventSupervisor;

    @Test
    public void testCheckInCreation() {
        try (MockedStatic<DomainEventSupervisorSupport> mockStatic = mockStatic(DomainEventSupervisorSupport.class)) {
            mockStatic.when(DomainEventSupervisorSupport::events).thenReturn(eventSupervisor);

            article.create();

            verify(eventSupervisor).attach(any(), any());
            mockStatic.verify(DomainEventSupervisorSupport::events, times(1));
        }

    }

}
