package com.only4.domain.aggregates.star_comment_reply.factory;

import com.only4.domain.aggregates.star_comment_reply.StarCommentReply;
import com.only4.domain.aggregates.star_comment_reply.StarCommentReplyStatistics;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;

/**
 * StarCommentReply聚合工厂
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/23
 */
@Aggregate(aggregate = "StarCommentReply", name = "StarCommentReplyFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class StarCommentReplyFactory implements AggregateFactory<StarCommentReplyFactory.Payload, StarCommentReply> {

  @Override
  public StarCommentReply create(Payload payload) {

    return StarCommentReply.builder()
        .starCommentId(payload.getStarCommentId())
        .authorId(payload.getMemberId())
        .authorName(payload.getMemberName())
        .content(payload.getContent())
        .createAt(LocalDateTime.now())
        .starCommentReplyStatistics(Collections.singletonList(new StarCommentReplyStatistics()))
        .build();
  }

  /**
   * StarCommentReply工厂负载
   */
  @Aggregate(aggregate = "StarCommentReply", name = "StarCommentReplyPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Payload implements AggregatePayload<StarCommentReply> {
    Long starCommentId;

    Long memberId;

    String memberName;

    String content;
  }
}