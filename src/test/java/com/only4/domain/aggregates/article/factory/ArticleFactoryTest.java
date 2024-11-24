package com.only4.domain.aggregates.article.factory;

import com.only4.domain.aggregates.article.Article;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ArticleFactoryTest {

    @InjectMocks
    private ArticleFactory articleFactory;

    @Mock
    private ArticlePayload mockPayload;

    @Test
    void create() {
        // Mock the behavior of the payload
        when(mockPayload.getAuthorId()).thenReturn(100L);
        when(mockPayload.getTitle()).thenReturn("Test Title");
        when(mockPayload.getDescription()).thenReturn("Test Description");
        when(mockPayload.getContent()).thenReturn("Test Content");
        when(mockPayload.getPrice()).thenReturn(9900L);

        // Call the method under test
        Article actual = articleFactory.create(mockPayload);

        // Verify the results
        assertEquals(100L, actual.getAuthorId());
        assertEquals("Test Title", actual.getTitle());
        assertEquals("Test Description", actual.getDescription());
        assertEquals("Test Content", actual.getContent());
        assertEquals(9900L, actual.getPrice());
    }
}

