package com.only4.domain.aggregates.star_comment.events;

import com.only4.domain.aggregates.star_comment.StarComment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.event.annotation.DomainEvent;

/**
 * StarComment.StarCommentCreatedDomainEvent领域事件
 * 星球评论已创建
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/23
 */
@DomainEvent(persist = false)
@Aggregate(aggregate = "StarComment", name = "StarCommentCreatedDomainEvent", type = Aggregate.TYPE_DOMAIN_EVENT, description = "")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StarCommentCreatedDomainEvent {
    StarComment entity;
}
