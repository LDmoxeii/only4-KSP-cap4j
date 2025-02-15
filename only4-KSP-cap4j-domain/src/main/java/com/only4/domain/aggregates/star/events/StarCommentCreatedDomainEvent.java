package com.only4.domain.aggregates.star.events;

import com.only4.domain.aggregates.star.Star;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.event.annotation.DomainEvent;

/**
 * Star.StarCommentCreatedDomainEvent领域事件
 * todo: 领域事件说明
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/14
 */
@DomainEvent(persist = false)
@Aggregate(aggregate = "Star", name = "StarCommentCreatedDomainEvent", type = Aggregate.TYPE_DOMAIN_EVENT, description = "")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StarCommentCreatedDomainEvent {
    Star entity;
}
