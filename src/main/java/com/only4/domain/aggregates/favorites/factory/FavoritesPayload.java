package com.only4.domain.aggregates.favorites.factory;

import com.only4.domain.aggregates.favorites.Favorites;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

/**
 * Favorites工厂负载
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/24
 */
@Aggregate(aggregate = "Favorites", name = "FavoritesPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FavoritesPayload implements AggregatePayload<Favorites> {
    Long customerId;
    String title;
    String description;
    Boolean def;

}
