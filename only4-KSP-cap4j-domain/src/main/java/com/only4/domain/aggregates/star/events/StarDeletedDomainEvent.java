package com.only4.domain.aggregates.star.events;

import com.only4.domain.aggregates.star.Star;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.event.annotation.DomainEvent;

/**
 * Star.StarDeletedDomainEvent领域事件
 * 星球已删除
 *
 * @author cap4j-ddd-codegen
 * @date 2025/03/04
 */
@DomainEvent(persist = false)
@Aggregate(aggregate = "Star", name = "StarDeletedDomainEvent", type = Aggregate.TYPE_DOMAIN_EVENT, description = "")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StarDeletedDomainEvent {
    Star entity;
}
