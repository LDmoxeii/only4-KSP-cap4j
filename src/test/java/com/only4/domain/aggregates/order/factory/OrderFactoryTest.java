package com.only4.domain.aggregates.order.factory;

import com.only4.domain.aggregates.order.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderFactoryTest {

    @InjectMocks
    private OrderFactory orderFactory;

    @Mock
    private OrderPayload mockPayload;

    @Test
    void create() {
        // Mock the behavior of the payload
        when(mockPayload.getCustomerId()).thenReturn(123L);
        when(mockPayload.getName()).thenReturn("Test Order");
        when(mockPayload.getPrice()).thenReturn(10000L);
        when(mockPayload.getActualPrice()).thenReturn(9000L);

        // Call the method under test
        Order actual = orderFactory.create(mockPayload);

        // Verify the results
        String expectedSerial = String.valueOf(123L + 10000L + 9000L);
        assertEquals(expectedSerial, actual.getSerial());
        assertEquals(123L, actual.getCustomerId());
        assertEquals("Test Order", actual.getName());
        assertEquals(10000L, actual.getPrice());
        assertEquals(9000L, actual.getActualPrice());
        assertFalse(actual.getIsPaid());
    }
}

