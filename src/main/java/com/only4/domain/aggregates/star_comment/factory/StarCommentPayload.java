package com.only4.domain.aggregates.star_comment.factory;

import com.only4.domain.aggregates.star_comment.StarComment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

/**
 * StarComment工厂负载
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/24
 */
@Aggregate(aggregate = "StarComment", name = "StarCommentPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StarCommentPayload implements AggregatePayload<StarComment> {
    Long articleId;
    Long authorId;
    String content;

}
