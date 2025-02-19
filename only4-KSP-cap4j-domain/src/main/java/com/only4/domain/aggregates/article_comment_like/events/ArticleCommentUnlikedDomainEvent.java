package com.only4.domain.aggregates.article_comment_like.events;

import com.only4.domain.aggregates.article_comment_like.ArticleCommentLike;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.event.annotation.DomainEvent;

/**
 * ArticleCommentLike.ArticleCommentUnlikedDomainEvent领域事件
 * 已取消点赞文章评论
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/19
 */
@DomainEvent(persist = false)
@Aggregate(aggregate = "ArticleCommentLike", name = "ArticleCommentUnlikedDomainEvent", type = Aggregate.TYPE_DOMAIN_EVENT, description = "")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCommentUnlikedDomainEvent {
    ArticleCommentLike entity;
}
