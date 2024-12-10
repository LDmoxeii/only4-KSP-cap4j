package com.only4.domain.aggregates.favorites.factory;

import com.only4.domain.aggregates.favorites.Favorites;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * Favorites聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
@Aggregate(aggregate = "Favorites", name = "FavoritesFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class FavoritesFactory implements AggregateFactory<FavoritesFactory.Payload, Favorites> {

    @Override
    public Favorites create(Payload payload) {

        return Favorites.builder()
                .customerId(payload.getCustomerId())
                .title(payload.getTitle())
                .description(payload.getDescription())
                .def(payload.getDef())
                .build();
    }

    /**
     * Favorites工厂负载
     */
    @Aggregate(aggregate = "Favorites", name = "FavoritesPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload implements AggregatePayload<Favorites> {
        Long customerId;
        String title;
        String description;
        Boolean def;

    }
}
