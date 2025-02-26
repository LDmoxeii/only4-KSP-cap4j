package com.only4.domain.aggregates.star_comment_reply;

import com.only4._share.exception.KnownException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.netcorepal.cap4j.ddd.domain.event.DomainEventSupervisor;
import org.netcorepal.cap4j.ddd.domain.event.DomainEventSupervisorSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StarCommentReplyTest {


  @Spy
  private StarCommentReply starCommentReply;

  @Mock
  private StarCommentReplyStatistics starCommentReplyStatistics;

  @Mock
  private DomainEventSupervisor domainEventSupervisor;

  @Nested
  class CreateTests {
    @Test
    void testCreate() {
      try (MockedStatic<DomainEventSupervisorSupport> mockedStatic = mockStatic(DomainEventSupervisorSupport.class)) {
        mockedStatic.when(DomainEventSupervisorSupport::events).thenReturn(domainEventSupervisor);
        starCommentReply.create();
        verify(domainEventSupervisor).attach(any(), any());
        mockedStatic.verify(DomainEventSupervisorSupport::events, times(1));
      }
    }
  }

  @Nested
  class DeleteTests {
    @Test
    void testDelete() {
      try (MockedStatic<DomainEventSupervisorSupport> mockedStatic = mockStatic(DomainEventSupervisorSupport.class)) {
        mockedStatic.when(DomainEventSupervisorSupport::events).thenReturn(domainEventSupervisor);
        starCommentReply.delete();
        verify(domainEventSupervisor).attach(any(), any());
        mockedStatic.verify(DomainEventSupervisorSupport::events, times(1));
      }
    }
  }

  @Nested
  class UpdateInfoTests {
    @Test
    void testUpdateInfo() {
      Long memberId = 1L;
      String memberName = "New Author Name";

      doReturn(false).when(starCommentReply).isAuthor(memberId);

      starCommentReply.updateInfo(memberId, memberName);

      assertEquals(memberName, starCommentReply.getAuthorName());
    }

    @Test
    void testUpdateInfoNotAuthor() {
      Long memberId = 1L;
      String memberName = "New Author Name";

      doReturn(true).when(starCommentReply).isAuthor(memberId);

      KnownException exception = assertThrows(KnownException.class,
          () -> starCommentReply.updateInfo(memberId, memberName));
      assertEquals("不是作者，不能修改", exception.getMessage());
    }
  }

  @Nested
  class UpdateLikeCountTests {
    @Test
    void testUpdateLikeCount() {
      try (MockedStatic<DomainEventSupervisorSupport> mockStatic = mockStatic(DomainEventSupervisorSupport.class)) {
        mockStatic.when(DomainEventSupervisorSupport::events).thenReturn(domainEventSupervisor);

        doReturn(starCommentReplyStatistics).when(starCommentReply).getStarCommentReplyStatistics();

        starCommentReply.updateLikeCount(1);

        verify(starCommentReplyStatistics).updateLikeCount(1);
        verify(domainEventSupervisor).attach(any(), any());
        mockStatic.verify(DomainEventSupervisorSupport::events, times(1));
      }
    }
  }

  @Nested
  class UpdateReportCountTests {
    @Test
    void testUpdateReportCount() {

      doReturn(starCommentReplyStatistics).when(starCommentReply).getStarCommentReplyStatistics();
      starCommentReply.updateReportCount(1);
      verify(starCommentReplyStatistics).updateReportCount(1);
    }
  }
}
