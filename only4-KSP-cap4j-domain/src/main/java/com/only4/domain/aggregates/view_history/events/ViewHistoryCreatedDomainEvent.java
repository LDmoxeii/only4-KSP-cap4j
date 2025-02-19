package com.only4.domain.aggregates.view_history.events;

import com.only4.domain.aggregates.view_history.ViewHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.event.annotation.DomainEvent;

/**
 * ViewHistory.ViewHistoryCreatedDomainEvent领域事件
 * 浏览记录已创建
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/19
 */
@DomainEvent(persist = false)
@Aggregate(aggregate = "ViewHistory", name = "ViewHistoryCreatedDomainEvent", type = Aggregate.TYPE_DOMAIN_EVENT, description = "")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViewHistoryCreatedDomainEvent {
    ViewHistory entity;
}
