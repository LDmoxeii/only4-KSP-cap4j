package com.only4.domain.aggregates.article_comment_reply.events;

import com.only4.domain.aggregates.article_comment_reply.ArticleCommentReply;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.event.annotation.DomainEvent;

/**
 * ArticleCommentReply.ArticleCommentReplyCreatedDomainEvent领域事件
 * 文章评论回复已创建
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/19
 */
@DomainEvent(persist = false)
@Aggregate(aggregate = "ArticleCommentReply", name = "ArticleCommentReplyCreatedDomainEvent", type = Aggregate.TYPE_DOMAIN_EVENT, description = "")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCommentReplyCreatedDomainEvent {
    ArticleCommentReply entity;
}
