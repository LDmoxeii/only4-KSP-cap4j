package com.only4.domain.aggregates.article_like.factory;

import com.only4.domain.aggregates.article_like.ArticleLike;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ArticleLikeFactoryTest {

    @InjectMocks
    private ArticleLikeFactory articleLikeFactory;

    @Mock
    private ArticleLikePayload mockPayload;

    @Test
    void create() {
        // Mock the behavior of the payload
        when(mockPayload.getCustomerId()).thenReturn(123L);
        when(mockPayload.getArticleId()).thenReturn(456L);

        // Call the method under test
        ArticleLike actual = articleLikeFactory.create(mockPayload);

        // Verify the results
        assertEquals(123L, actual.getCustomerId());
        assertEquals(456L, actual.getArticleId());
    }
}

