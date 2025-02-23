package com.only4.domain.aggregates.star_comment.events;

import com.only4.domain.aggregates.star_comment.StarComment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.event.annotation.DomainEvent;

/**
 * StarComment.StarCommentReplyCountUpdatedDomainEvent领域事件
 * 星球回复数已更新
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/23
 */
@DomainEvent(persist = false)
@Aggregate(aggregate = "StarComment", name = "StarCommentReplyCountUpdatedDomainEvent", type = Aggregate.TYPE_DOMAIN_EVENT, description = "")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StarCommentReplyCountUpdatedDomainEvent {
    StarComment entity;
}
