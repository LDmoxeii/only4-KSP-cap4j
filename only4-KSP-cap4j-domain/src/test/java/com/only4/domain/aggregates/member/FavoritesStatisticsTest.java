package com.only4.domain.aggregates.member;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FavoritesStatisticsTest {

    @Test
    public void testUpdateArticleCount() {
        FavoritesStatistics statistics = FavoritesStatistics.builder()
                .articleCount(0)
                .build();

        statistics.updateArticleCount(5);

        assertEquals(5, statistics.getArticleCount());
    }

    @Test
    public void testValidateArticleCount() {
        FavoritesStatistics statistics = FavoritesStatistics.builder()
                .articleCount(1)
                .build();

        assertTrue(statistics.validateArticleCount());
    }
}
