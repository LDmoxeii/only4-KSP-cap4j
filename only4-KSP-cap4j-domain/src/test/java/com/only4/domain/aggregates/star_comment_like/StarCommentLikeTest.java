package com.only4.domain.aggregates.star_comment_like;

import com.only4.domain.aggregates.star_comment_like.events.StarCommentLikedDomainEvent;
import com.only4.domain.aggregates.star_comment_like.events.StarCommentUnlikedDomainEvent;
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
class StarCommentLikeTest {
    @Spy
    private StarCommentLike starCommentLike;


    @Mock
    private DomainEventSupervisor eventSupervisor;

    @Test
    void likeTest(){
        try (MockedStatic<DomainEventSupervisorSupport> mockStatic = mockStatic(DomainEventSupervisorSupport.class)) {
            mockStatic.when(DomainEventSupervisorSupport::events).thenReturn(eventSupervisor);

            starCommentLike.like();

            verify(eventSupervisor).attach(any(StarCommentLikedDomainEvent.class), any(StarCommentLike.class));
            mockStatic.verify(DomainEventSupervisorSupport::events, times(1));
        }
    }

    @Test
    void unlikeTest(){
        try (MockedStatic<DomainEventSupervisorSupport> mockStatic = mockStatic(DomainEventSupervisorSupport.class)) {
            mockStatic.when(DomainEventSupervisorSupport::events).thenReturn(eventSupervisor);

            starCommentLike.unlike();

            verify(eventSupervisor).attach(any(StarCommentUnlikedDomainEvent.class), any(StarCommentLike.class));
            mockStatic.verify(DomainEventSupervisorSupport::events, times(1));
        }
    }

}