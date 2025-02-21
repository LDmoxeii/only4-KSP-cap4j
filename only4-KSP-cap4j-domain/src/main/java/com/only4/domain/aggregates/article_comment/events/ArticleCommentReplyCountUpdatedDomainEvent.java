package com.only4.domain.aggregates.article_comment.events;

import com.only4.domain.aggregates.article_comment.ArticleComment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.event.annotation.DomainEvent;

/**
 * ArticleComment.ArticleCommentReplyCountUpdatedDomainEvent领域事件
 * 文章评论回复数已更新
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/21
 */
@DomainEvent(persist = false)
@Aggregate(aggregate = "ArticleComment", name = "ArticleCommentReplyCountUpdatedDomainEvent", type = Aggregate.TYPE_DOMAIN_EVENT, description = "")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCommentReplyCountUpdatedDomainEvent {
    ArticleComment entity;

    Integer replyCount;
}
