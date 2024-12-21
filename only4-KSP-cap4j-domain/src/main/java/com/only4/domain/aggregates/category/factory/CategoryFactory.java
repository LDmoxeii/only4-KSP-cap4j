package com.only4.domain.aggregates.category.factory;

import com.only4.domain.aggregates.category.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * Category聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/15
 */
@Aggregate(aggregate = "Category", name = "CategoryFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class CategoryFactory implements AggregateFactory<CategoryFactory.Payload, Category> {

    @Override
    public Category create(Payload payload) {

        return Category.builder()
                .id(payload.id)
                .name(payload.getName())
                .build();
    }

    /**
     * Category工厂负载
     */
    @Aggregate(aggregate = "Category", name = "CategoryPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload implements AggregatePayload<Category> {
        String name;
        Long id;
    }
}
