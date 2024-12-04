package com.only4.domain.aggregates.stardust.factory;

import com.only4.domain.aggregates.stardust.Stardust;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StardustFactoryTest {

    @InjectMocks
    private StardustFactory stardustFactory;

    @Mock
    private StardustFactory.Payload mockPayload;

    @Test
    void create() {
        when(mockPayload.getStarId()).thenReturn(1L);
        when(mockPayload.getCustomerId()).thenReturn(2L);

        Stardust actual = stardustFactory.create(mockPayload);

        assertEquals(1L, actual.getStarId());
        assertEquals(2L, actual.getCustomerId());
    }
}
