package com.only4.domain.aggregates.star_like;

import com.only4.domain.aggregates.star_like.events.StarLikeDomainEvent;
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
class StarLikeTest {

    @Spy
    StarLike starLike;

    @Mock
    private DomainEventSupervisor eventSupervisor;

    @Test
    void like() {
        try (MockedStatic<DomainEventSupervisorSupport> mockStatic = mockStatic(DomainEventSupervisorSupport.class)) {
            mockStatic.when(DomainEventSupervisorSupport::events).thenReturn(eventSupervisor);

            starLike.like();

            verify(eventSupervisor).attach(any(StarLikeDomainEvent.class), any(StarLike.class));
            mockStatic.verify(DomainEventSupervisorSupport::events, times(1));
        }
    }

    @Test
    void unlike() {
        try (MockedStatic<DomainEventSupervisorSupport> mockStatic = mockStatic(DomainEventSupervisorSupport.class)) {
            mockStatic.when(DomainEventSupervisorSupport::events).thenReturn(eventSupervisor);

            starLike.unlike();

            verify(eventSupervisor).attach(any(StarLikeDomainEvent.class), any(StarLike.class));
            mockStatic.verify(DomainEventSupervisorSupport::events, times(1));
        }
    }
}