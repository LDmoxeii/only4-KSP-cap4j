package com.only4.domain.aggregates.star_comment.factory;

import com.only4.domain.aggregates.star_comment.StarComment;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * StarComment聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/24
 */
@Aggregate(aggregate = "star_comment", name = "StarCommentFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class StarCommentFactory implements AggregateFactory<StarCommentPayload, StarComment> {

    @Override
    public StarComment create(StarCommentPayload payload) {

        return StarComment.builder()
                .articleId(payload.getArticleId())
                .authorId(payload.getAuthorId())
                .content(payload.getContent())
                .starCommentStatistics(Collections.singletonList(payload.getStarCommentStatistics()))
                .build();
    }
}
