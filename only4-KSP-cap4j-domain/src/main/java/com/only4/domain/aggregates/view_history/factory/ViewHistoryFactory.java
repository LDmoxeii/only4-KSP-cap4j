package com.only4.domain.aggregates.view_history.factory;

import com.only4.domain.aggregates.view_history.ViewHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * ViewHistory聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/17
 */
@Aggregate(aggregate = "ViewHistory", name = "ViewHistoryFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class ViewHistoryFactory implements AggregateFactory<ViewHistoryFactory.Payload, ViewHistory> {

    @Override
    public ViewHistory create(Payload payload) {

        return ViewHistory.builder()
                .memberId(payload.getMemberId())
                .articleId(payload.getArticleId())
                .build();
    }

    /**
     * ViewHistory工厂负载
     */
    @Aggregate(aggregate = "ViewHistory", name = "ViewHistoryPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload implements AggregatePayload<ViewHistory> {

        Long memberId;

        Long articleId;
    }
}
