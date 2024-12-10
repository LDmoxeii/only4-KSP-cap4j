package com.only4.domain.aggregates.favorite_article.factory;

import com.only4.domain.aggregates.favorite_article.FavoriteArticle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FavoriteArticleFactoryTest {

    @InjectMocks
    private FavoriteArticleFactory favoriteArticleFactory;

    @Mock
    private FavoriteArticleFactory.Payload mockPayload;

    @Test
    void create() {
        // Mock the behavior of the payload
        when(mockPayload.getFavoritesId()).thenReturn(1001L);
        when(mockPayload.getArticleId()).thenReturn(2002L);

        // Call the method under test
        FavoriteArticle actual = favoriteArticleFactory.create(mockPayload);

        // Verify the results
        assertEquals(1001L, actual.getFavoritesId());
        assertEquals(2002L, actual.getArticleId());
    }
}

