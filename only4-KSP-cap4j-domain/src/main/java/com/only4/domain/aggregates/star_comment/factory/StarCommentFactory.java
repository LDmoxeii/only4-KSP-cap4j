package com.only4.domain.aggregates.star_comment.factory;

import com.only4.domain.aggregates.star_comment.StarComment;
import com.only4.domain.aggregates.star_comment.StarCommentStatistics;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * StarComment聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/23
 */
@Aggregate(aggregate = "StarComment", name = "StarCommentFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class StarCommentFactory implements AggregateFactory<StarCommentFactory.Payload, StarComment> {

    @Override
    public StarComment create(Payload payload) {

        return StarComment.builder()
                .starId(payload.getStarId())
                .authorId(payload.getAuthorId())
                .authorName(payload.getAuthorName())
                .content(payload.getContent())
                .createAt(LocalDateTime.now())
                .starCommentStatistics(List.of(StarCommentStatistics.builder().build()))
                .build();
    }

    /**
     * StarComment工厂负载
     */
    @Aggregate(aggregate = "StarComment", name = "StarCommentPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload implements AggregatePayload<StarComment> {

        Long starId;

        Long authorId;

        String authorName;

        String content;
    }
}
