package com.only4.domain.aggregates.star;

import com.only4.domain.aggregates.member.FavoritesStatistics;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StarStatisticTest {
    @Test
    public void testUpdateLikeCount() {
        StarStatistic statistics = StarStatistic.builder()
                .likeCount(0)
                .build();

        statistics.updateLikeCount(5);
        assertEquals(5, statistics.getLikeCount());
    }
    @Test
    public void testUpdateStarDustCount() {
        StarStatistic statistics = StarStatistic.builder()
                .stardustCount(0)
                .build();

        statistics.updateStarDustCount(5);
        assertEquals(5, statistics.getStardustCount());
    }
    @Test
    public void testUpdateCommentCount() {
        StarStatistic statistics = StarStatistic.builder()
                .commentCount(0)
                .build();

        statistics.updateCommentCount(5);
        assertEquals(5, statistics.getCommentCount());
    }
}