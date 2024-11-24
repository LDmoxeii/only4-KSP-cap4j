package com.only4.domain.aggregates.favorites.factory;

import com.only4.domain.aggregates.favorites.Favorites;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * Favorites聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/24
 */
@Aggregate(aggregate = "favorites", name = "FavoritesFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class FavoritesFactory implements AggregateFactory<FavoritesPayload, Favorites> {

    @Override
    public Favorites create(FavoritesPayload payload) {

        return Favorites.builder()

                .build();
    }
}
