package com.only4.domain.aggregates.member;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FavoritesArticleTest {

    @Test
    public void testFavoritesArticleCreation() {
        FavoritesArticle favoritesArticle = FavoritesArticle.builder()
                .articleId(1L)
                .createAt(LocalDateTime.now())
                .build();

        assertNotNull(favoritesArticle.getArticleId());
        assertNotNull(favoritesArticle.getCreateAt());
    }
}
