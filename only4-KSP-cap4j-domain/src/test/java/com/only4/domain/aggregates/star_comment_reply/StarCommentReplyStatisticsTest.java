package com.only4.domain.aggregates.star_comment_reply;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class StarCommentReplyStatisticsTest {

@Spy
StarCommentReplyStatistics starCommentReplyStatistics;

  @Test
  void updateLikeCount() {
   doReturn(0).when(starCommentReplyStatistics).getLikeCount();
    starCommentReplyStatistics.updateLikeCount(1);
    assertEquals(1, starCommentReplyStatistics.likeCount);
  }

  @Test
  void updateReportCount() {
    doReturn(0).when(starCommentReplyStatistics).getReportCount();
    starCommentReplyStatistics.updateReportCount(1);
    assertEquals(1, starCommentReplyStatistics.reportCount);
  }
}