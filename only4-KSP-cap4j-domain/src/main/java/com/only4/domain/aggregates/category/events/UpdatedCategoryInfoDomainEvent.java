package com.only4.domain.aggregates.category.events;

import com.only4.domain.aggregates.category.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.event.annotation.DomainEvent;

/**
 * Category.UpdatedCategoryInfoDomainEvent领域事件
 * todo: 领域事件说明
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/15
 */
@DomainEvent(persist = false)
@Aggregate(aggregate = "Category", name = "UpdatedCategoryInfoDomainEvent", type = Aggregate.TYPE_DOMAIN_EVENT, description = "")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdatedCategoryInfoDomainEvent {
    Category entity;
}
