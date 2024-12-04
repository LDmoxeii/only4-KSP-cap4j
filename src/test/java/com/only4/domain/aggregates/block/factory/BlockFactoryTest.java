package com.only4.domain.aggregates.block.factory;

import com.only4.domain.aggregates.block.Block;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BlockFactoryTest {

    @InjectMocks
    private BlockFactory blockFactory;

    @Mock
    private BlockFactory.Payload mockPayload;

    @Test
    void create() {
        // Mock the behavior of the payload
        when(mockPayload.getBlockId()).thenReturn(1001L);
        when(mockPayload.getBlockedId()).thenReturn(2002L);

        // Call the method under test
        Block actual = blockFactory.create(mockPayload);

        // Verify the results
        assertEquals(1001L, actual.getBlockId());
        assertEquals(2002L, actual.getBlockedId());
    }
}

