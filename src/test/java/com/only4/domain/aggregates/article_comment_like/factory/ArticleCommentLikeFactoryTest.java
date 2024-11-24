package com.only4.domain.aggregates.article_comment_like.factory;

import com.only4.domain.aggregates.article_comment_like.ArticleCommentLike;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ArticleCommentLikeFactoryTest {

    @InjectMocks
    private ArticleCommentLikeFactory articleCommentLikeFactory;

    @Mock
    private ArticleCommentLikePayload mockPayload;

    @Test
    void create() {
        // Mock the behavior of the payload
        when(mockPayload.getCustomerId()).thenReturn(123L);
        when(mockPayload.getCommentId()).thenReturn(456L);

        // Call the method under test
        ArticleCommentLike actual = articleCommentLikeFactory.create(mockPayload);

        // Verify the results
        assertEquals(123L, actual.getCustomerId());
        assertEquals(456L, actual.getComments());
    }
}

