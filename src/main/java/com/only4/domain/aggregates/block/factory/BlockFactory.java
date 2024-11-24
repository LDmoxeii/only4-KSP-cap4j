package com.only4.domain.aggregates.block.factory;

import com.only4.domain.aggregates.block.Block;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * Block聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/24
 */
@Aggregate(aggregate = "block", name = "BlockFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class BlockFactory implements AggregateFactory<BlockPayload, Block> {

    @Override
    public Block create(BlockPayload payload) {

        return Block.builder()
                .blockId(payload.getBlockId())
                .blockedId(payload.getBlockedId())
                .build();
    }
}
