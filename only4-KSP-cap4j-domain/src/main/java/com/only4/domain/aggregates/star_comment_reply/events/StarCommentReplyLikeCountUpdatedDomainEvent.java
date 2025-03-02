package com.only4.domain.aggregates.star_comment_reply.events;

import com.only4.domain.aggregates.star_comment_reply.StarCommentReply;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.event.annotation.DomainEvent;

/**
 * StarCommentReply.StarCommentReplyLikeCountUpdatedDomainEvent领域事件
 * 星球评论回复点赞数已更新
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/23
 */
@DomainEvent(persist = false)
@Aggregate(aggregate = "StarCommentReply", name = "StarCommentReplyLikeCountUpdatedDomainEvent", type = Aggregate.TYPE_DOMAIN_EVENT, description = "")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StarCommentReplyLikeCountUpdatedDomainEvent {
    StarCommentReply entity;

    Integer likeCount;
}
