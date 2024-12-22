package com.only4.domain.aggregates.tag.factory;

import com.only4.domain.aggregates.tag.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * Tag聚合工厂
 * 
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/15
 */
@Aggregate(aggregate = "Tag", name = "TagFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class TagFactory implements AggregateFactory<TagFactory.Payload, Tag> {

    @Override
    public Tag create(Payload payload) {

        return Tag.builder()
                .name(payload.name)
                .description(payload.description)
                .icon(payload.icon)
                .build();
    }
    
    /**
     * Tag工厂负载
     */
    @Aggregate(aggregate = "Tag", name = "TagPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload implements AggregatePayload<Tag> {
        String name;
        String description;
        String icon;
    }
}