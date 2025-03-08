package com.only4.domain.aggregates.article_comment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArticleCommentStatisticsTest {

    private ArticleCommentStatistics articleCommentStatistics;
    @BeforeEach
    void setUp() {
        articleCommentStatistics = ArticleCommentStatistics.builder()
                .id(1L)
                .likeCount(10)
                .replyCount(3)
                .reportCount(1)
                .build();
    }

    @Test
    void testUpdateLikeCount() {
        articleCommentStatistics.updateLikeCount(5);
        assertEquals(15, articleCommentStatistics.getLikeCount());
    }

    @Test
    void testUpdateReplyCount() {
        articleCommentStatistics.updateReplyCount(2);
        assertEquals(5, articleCommentStatistics.getReplyCount());
    }

    @Test
    void addUpdateReportCount() {
        articleCommentStatistics.addReportCount(1);
        assertEquals(2, articleCommentStatistics.getReportCount());

    }
}
