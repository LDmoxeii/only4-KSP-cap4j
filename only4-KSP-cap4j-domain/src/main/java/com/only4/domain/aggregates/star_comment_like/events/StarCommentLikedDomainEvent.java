package com.only4.domain.aggregates.star_comment_like.events;

import com.only4.domain.aggregates.star_comment_like.StarCommentLike;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.event.annotation.DomainEvent;

/**
 * StarCommentLike.StarCommentLikedDomainEvent领域事件
 * 已点赞星球评论
 *
 * @author cap4j-ddd-codegen
 * @date 2025/03/08
 */
@DomainEvent(persist = false)
@Aggregate(aggregate = "StarCommentLike", name = "StarCommentLikedDomainEvent", type = Aggregate.TYPE_DOMAIN_EVENT, description = "")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StarCommentLikedDomainEvent {
    StarCommentLike entity;
}
