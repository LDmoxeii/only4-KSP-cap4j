package com.only4.domain.aggregates.block.factory;

import com.only4.domain.aggregates.block.Block;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * Block聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
@Aggregate(aggregate = "Block", name = "BlockFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class BlockFactory implements AggregateFactory<BlockFactory.Payload, Block> {

    @Override
    public Block create(Payload payload) {

        return Block.builder()
                .blockId(payload.getBlockId())
                .blockedId(payload.getBlockedId())
                .build();
    }

    /**
     * Block工厂负载
     */
    @Aggregate(aggregate = "Block", name = "BlockPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload implements AggregatePayload<Block> {
        Long blockId;
        Long blockedId;

    }
}
