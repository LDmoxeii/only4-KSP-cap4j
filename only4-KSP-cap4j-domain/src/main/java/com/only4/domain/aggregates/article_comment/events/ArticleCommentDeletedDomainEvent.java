package com.only4.domain.aggregates.article_comment.events;

import com.only4.domain.aggregates.article_comment.ArticleComment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.event.annotation.DomainEvent;

/**
 * ArticleComment.ArticleCommentDeletedDomainEvent领域事件
 * 文章评论已删除
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/19
 */
@DomainEvent(persist = false)
@Aggregate(aggregate = "ArticleComment", name = "ArticleCommentDeletedDomainEvent", type = Aggregate.TYPE_DOMAIN_EVENT, description = "")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCommentDeletedDomainEvent {
    ArticleComment entity;
}
