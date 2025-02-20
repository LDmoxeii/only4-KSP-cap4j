package com.only4.domain.aggregates.article;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArticleStatisticsTest {

    private ArticleStatistics articleStatistics;

    @BeforeEach
    void setUp() {
        articleStatistics = ArticleStatistics.builder()
                .id(1L)
                .likeCount(10)
                .favoriteCount(5)
                .commentCount(3)
                .viewCount(100)
                .build();
    }

    @Test
    void testUpdateLikeCount() {
        articleStatistics.updateLikeCount(5);
        assertEquals(15, articleStatistics.getLikeCount());
    }

    @Test
    void testUpdateFavoriteCount() {
        articleStatistics.updateFavoriteCount(3);
        assertEquals(8, articleStatistics.getFavoriteCount());
    }

    @Test
    void testUpdateCommentCount() {
        articleStatistics.updateCommentCount(2);
        assertEquals(5, articleStatistics.getCommentCount());
    }
}
