package com.only4.domain.aggregates.star_comment_like.factory;

import com.only4.domain.aggregates.star_comment_like.StarCommentLike;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

/**
 * StarCommentLike工厂负载
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/24
 */
@Aggregate(aggregate = "star_comment_like", name = "StarCommentLikePayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StarCommentLikePayload implements AggregatePayload<StarCommentLike> {
    Long customerId;
    Long commentId;

}
