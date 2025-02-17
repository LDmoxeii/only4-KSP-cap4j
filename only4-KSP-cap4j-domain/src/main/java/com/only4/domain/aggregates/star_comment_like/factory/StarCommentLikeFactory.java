package com.only4.domain.aggregates.star_comment_like.factory;

import com.only4.domain.aggregates.star_comment_like.StarCommentLike;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * StarCommentLike聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/17
 */
@Aggregate(aggregate = "StarCommentLike", name = "StarCommentLikeFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class StarCommentLikeFactory implements AggregateFactory<StarCommentLikeFactory.Payload, StarCommentLike> {

    @Override
    public StarCommentLike create(Payload payload) {

        return StarCommentLike.builder()

                .build();
    }

    /**
     * StarCommentLike工厂负载
     */
    @Aggregate(aggregate = "StarCommentLike", name = "StarCommentLikePayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload implements AggregatePayload<StarCommentLike> {
        String name;

    }
}
