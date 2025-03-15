package com.only4.domain.aggregates.star_like.events;

import com.only4.domain.aggregates.star_like.StarLike;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.event.annotation.DomainEvent;

/**
 * StarLike.StarLikeDomainEvent领域事件
 * StarUnliked
 *
 * @author cap4j-ddd-codegen
 * @date 2025/03/11
 */
@DomainEvent(persist = false)
@Aggregate(aggregate = "StarLike", name = "StarLikeDomainEvent", type = Aggregate.TYPE_DOMAIN_EVENT, description = "")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StarLikeDomainEvent {
    StarLike entity;
}
