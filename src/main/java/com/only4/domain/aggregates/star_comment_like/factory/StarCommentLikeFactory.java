package com.only4.domain.aggregates.star_comment_like.factory;

import com.only4.domain.aggregates.star_comment_like.StarCommentLike;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * StarCommentLike聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/24
 */
@Aggregate(aggregate = "star_comment_like", name = "StarCommentLikeFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class StarCommentLikeFactory implements AggregateFactory<StarCommentLikePayload, StarCommentLike> {

    @Override
    public StarCommentLike create(StarCommentLikePayload payload) {

        return StarCommentLike.builder()
                .customerId(payload.getCustomerId())
                .commentId(payload.getCommentId())
                .build();
    }
}
