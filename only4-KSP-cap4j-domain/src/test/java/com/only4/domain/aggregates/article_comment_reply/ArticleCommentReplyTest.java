package com.only4.domain.aggregates.article_comment_reply;

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
class ArticleCommentReplyTest {

    @Spy
    private ArticleCommentReply articleCommentReply;

    @Mock
    private ArticleCommentReplyStatistics articleCommentReplyStatistics;

    @Mock
    private DomainEventSupervisor eventSupervisor;

    @Nested
    class CreateTests {
        @Test
        void testCreate() {
            try (MockedStatic<DomainEventSupervisorSupport> mockStatic = mockStatic(DomainEventSupervisorSupport.class)) {
                mockStatic.when(DomainEventSupervisorSupport::events).thenReturn(eventSupervisor);

                articleCommentReply.create();

                verify(eventSupervisor).attach(any(), any());
                mockStatic.verify(DomainEventSupervisorSupport::events, times(1));
            }
        }
    }

    @Nested
    class DeleteTests {
        @Test
        void testDelete() {
            try (MockedStatic<DomainEventSupervisorSupport> mockStatic = mockStatic(DomainEventSupervisorSupport.class)) {
                mockStatic.when(DomainEventSupervisorSupport::events).thenReturn(eventSupervisor);

                articleCommentReply.delete();

                verify(eventSupervisor).attach(any(), any());
                mockStatic.verify(DomainEventSupervisorSupport::events, times(1));
            }
        }
    }

    @Nested
    class UpdateInfoTests {
        @Test
        void testUpdateInfo() {
            Long memberId = 1L;
            String memberName = "New Author Name";

            doReturn(false).when(articleCommentReply).isAuthor(memberId);

            articleCommentReply.updateInfo(memberId, memberName);

            assertEquals(memberName, articleCommentReply.getAuthorName());
        }

        @Test
        void testUpdateInfoNotAuthor() {
            Long memberId = 1L;
            String memberName = "New Author Name";

            doReturn(true).when(articleCommentReply).isAuthor(memberId);

            KnownException exception = assertThrows(KnownException.class,
                    () -> articleCommentReply.updateInfo(memberId, memberName));
            assertEquals("不是作者，不能修改", exception.getMessage());
        }
    }

    @Nested
    class UpdateLikeCountTests {
        @Test
        void testUpdateLikeCount() {
            try (MockedStatic<DomainEventSupervisorSupport> mockStatic = mockStatic(DomainEventSupervisorSupport.class)) {
                mockStatic.when(DomainEventSupervisorSupport::events).thenReturn(eventSupervisor);

                doReturn(articleCommentReplyStatistics).when(articleCommentReply).getArticleCommentReplyStatistics();

                articleCommentReply.updateLikeCount(1);

                verify(articleCommentReplyStatistics).updateLikeCount(1);
                verify(eventSupervisor).attach(any(), any());
                mockStatic.verify(DomainEventSupervisorSupport::events, times(1));
            }
        }
    }

    @Nested
    class ReportTests {
        @Test
        void testReport() {
            articleCommentReply.report();

            // Since the report method is empty, we just verify that it can be called without exceptions
            assertDoesNotThrow(() -> articleCommentReply.report());
        }
    }
}
