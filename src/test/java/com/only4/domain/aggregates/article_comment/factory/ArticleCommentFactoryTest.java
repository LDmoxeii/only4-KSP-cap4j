package com.only4.domain.aggregates.article_comment.factory;

import com.only4.domain.aggregates.article_comment.ArticleComment;
import com.only4.domain.aggregates.article_comment.ArticleCommentStatistics;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ArticleCommentFactoryTest {

    @InjectMocks
    private ArticleCommentFactory articleCommentFactory;

    @Mock
    private ArticleCommentPayload mockPayload;

    @Mock
    private ArticleCommentStatistics mockStatistics;

    @Test
    void create() {
        // Mock the behavior of the payload
        when(mockPayload.getArticleId()).thenReturn(1L);
        when(mockPayload.getAuthorId()).thenReturn(2L);
        when(mockPayload.getContent()).thenReturn("Test Comment Content");
        when(mockPayload.getStatistics()).thenReturn(mockStatistics);

        // Call the method under test
        ArticleComment actual = articleCommentFactory.create(mockPayload);

        // Verify the results
        assertEquals(1L, actual.getArticleId());
        assertEquals(2L, actual.getAuthorId());
        assertEquals("Test Comment Content", actual.getContent());
        assertNotNull(actual.getArticleCommentStatistics());
        assertEquals(1, actual.getArticleCommentStatistics().size());
        assertEquals(mockStatistics, actual.getArticleCommentStatistics().get(0));
    }
}

