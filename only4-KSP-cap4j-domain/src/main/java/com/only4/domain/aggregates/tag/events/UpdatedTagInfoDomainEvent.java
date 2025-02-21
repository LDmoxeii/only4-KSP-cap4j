package com.only4.domain.aggregates.tag.events;

import com.only4.domain.aggregates.tag.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.event.annotation.DomainEvent;

/**
 * Tag.UpdatedTagInfoDomainEvent领域事件
 * 标签信息已更新
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/14
 */
@DomainEvent(persist = false)
@Aggregate(aggregate = "Tag", name = "UpdatedTagInfoDomainEvent", type = Aggregate.TYPE_DOMAIN_EVENT, description = "")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdatedTagInfoDomainEvent {
    Tag entity;
}
