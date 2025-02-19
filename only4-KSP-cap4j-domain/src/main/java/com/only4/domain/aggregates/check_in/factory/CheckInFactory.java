package com.only4.domain.aggregates.check_in.factory;

import com.only4.domain.aggregates.check_in.CheckIn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * CheckIn聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/17
 */
@Aggregate(aggregate = "CheckIn", name = "CheckInFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class CheckInFactory implements AggregateFactory<CheckInFactory.Payload, CheckIn> {

    @Override
    public CheckIn create(Payload payload) {

        return CheckIn.builder()
                .memberId(payload.getMemberId())
                .createAt(LocalDateTime.now())
                .build();
    }

    /**
     * CheckIn工厂负载
     */
    @Aggregate(aggregate = "CheckIn", name = "CheckInPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload implements AggregatePayload<CheckIn> {
        Long memberId;

    }
}
