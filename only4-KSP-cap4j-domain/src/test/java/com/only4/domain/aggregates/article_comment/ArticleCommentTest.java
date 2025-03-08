package com.only4.domain.aggregates.article_comment;

import com.only4.common.exception.KnownException;
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
class ArticleCommentTest {

    @Spy
    private ArticleComment articleComment;

    @Mock
    private ArticleCommentStatistics articleCommentStatistics;

    @Mock
    private DomainEventSupervisor eventSupervisor;

    @Nested
    class CreateTests {
        @Test
        void testCreate() {
            try (MockedStatic<DomainEventSupervisorSupport> mockStatic = mockStatic(DomainEventSupervisorSupport.class)) {
                mockStatic.when(DomainEventSupervisorSupport::events).thenReturn(eventSupervisor);

                articleComment.create();

                verify(eventSupervisor).attach(any(), any());
                mockStatic.verify(DomainEventSupervisorSupport::events, times(1));
            }
        }
    }

    @Nested
    class UpdateLikeCountTests {
        @Test
        void testUpdateLikeCount() {
            try (MockedStatic<DomainEventSupervisorSupport> mockStatic = mockStatic(DomainEventSupervisorSupport.class)) {
                mockStatic.when(DomainEventSupervisorSupport::events).thenReturn(eventSupervisor);

                doReturn(articleCommentStatistics).when(articleComment).getArticleCommentStatistics();

                articleComment.updateLikeCount(1);

                verify(articleCommentStatistics).updateLikeCount(1);
                verify(eventSupervisor).attach(any(), any());
                mockStatic.verify(DomainEventSupervisorSupport::events, times(1));
            }
        }
    }

    @Nested
    class UpdateStickyTests {
        @Test
        void testUpdateSticky() {
            Boolean sticky = true;

            articleComment.updateSticky(sticky);

            assertEquals(sticky, articleComment.getStickyFlag());
        }
    }

    @Nested
    class UpdateReplyCountTests {
        @Test
        void testUpdateReplyCount() {
            try (MockedStatic<DomainEventSupervisorSupport> mockStatic = mockStatic(DomainEventSupervisorSupport.class)) {
                mockStatic.when(DomainEventSupervisorSupport::events).thenReturn(eventSupervisor);

                doReturn(articleCommentStatistics).when(articleComment).getArticleCommentStatistics();

                articleComment.updateReplyCount(1);

                verify(articleCommentStatistics).updateReplyCount(1);

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
            doReturn(true).when(articleComment).isAuthor(memberId);

            articleComment.updateInfo(memberId, memberName);

            assertEquals(memberName, articleComment.getAuthorName());
        }

        @Test
        void testUpdateInfoNotAuthor() {
            Long memberId = 1L;
            String memberName = "New Author Name";

            doReturn(false).when(articleComment).isAuthor(memberId);

            KnownException exception = assertThrows(KnownException.class,
                    () -> articleComment.updateInfo(memberId, memberName));
            assertEquals("不是作者，不能修改", exception.getMessage());
        }
    }

    @Nested
    class ReportTests {
        @Test
        void testReport() {
            // Since the report method is empty, we just call it to ensure no exceptions are thrown
            assertDoesNotThrow(() -> articleComment.report());
        }
    }

    @Nested
    class DeleteTests {
        @Test
        void testDelete() {
            try (MockedStatic<DomainEventSupervisorSupport> mockStatic = mockStatic(DomainEventSupervisorSupport.class)) {
                mockStatic.when(DomainEventSupervisorSupport::events).thenReturn(eventSupervisor);

                articleComment.delete();

                verify(eventSupervisor).attach(any(), any());
                mockStatic.verify(DomainEventSupervisorSupport::events, times(1));
            }
        }
    }

    @Nested
    class testAddReportCount{
        @Test
        void testAddReportCount(){
            try (MockedStatic<DomainEventSupervisorSupport> mockStatic = mockStatic(DomainEventSupervisorSupport.class)) {
                mockStatic.when(DomainEventSupervisorSupport::events).thenReturn(eventSupervisor);

                doReturn(articleCommentStatistics).when(articleComment).getArticleCommentStatistics();

                articleComment.addReportCount(1);

                verify(articleCommentStatistics).addReportCount(1);

                verify(eventSupervisor).attach(any(), any());
                mockStatic.verify(DomainEventSupervisorSupport::events, times(1));





            }
        }
    }
}
