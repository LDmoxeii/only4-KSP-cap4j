package com.only4.domain.aggregates.article_comment.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.event.annotation.DomainEvent;

/**
 * ArticleComment.ArticleCommentReportedDomainEvent领域事件
 * todo: 领域事件说明
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/24
 */
@DomainEvent(persist = false)
@Aggregate(aggregate = "ArticleComment", name = "ArticleCommentReportedDomainEvent", type = Aggregate.TYPE_DOMAIN_EVENT, description = "")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCommentReportedDomainEvent {
    Long id;
}