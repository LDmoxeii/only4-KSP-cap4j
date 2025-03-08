package com.only4.domain.aggregates.star.events;

import com.only4.domain.aggregates.star.Star;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.event.annotation.DomainEvent;

/**
 * Star.StarDustCountUpdatedDomainEvent领域事件
 * 星尘数已更新
 *
 * @author cap4j-ddd-codegen
 * @date 2025/03/04
 */
@DomainEvent(persist = false)
@Aggregate(aggregate = "Star", name = "StarDustCountUpdatedDomainEvent", type = Aggregate.TYPE_DOMAIN_EVENT, description = "")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StarDustCountUpdatedDomainEvent {
    Star entity;
    Integer stardustCount;
}
