package com.only4.domain.aggregates.favorites.factory;

import com.only4.domain.aggregates.favorites.Favorites;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FavoritesFactoryTest {

    @InjectMocks
    private FavoritesFactory favoritesFactory;

    @Mock
    private FavoritesPayload mockPayload;

    @Test
    void create() {
        // Mock the behavior of the payload
        when(mockPayload.getCustomerId()).thenReturn(123L);
        when(mockPayload.getTitle()).thenReturn("Test Title");
        when(mockPayload.getDescription()).thenReturn("Test Description");
        when(mockPayload.getDef()).thenReturn(true);

        // Call the method under test
        Favorites actual = favoritesFactory.create(mockPayload);

        // Verify the results
        assertEquals(123L, actual.getCustomerId());
        assertEquals("Test Title", actual.getTitle());
        assertEquals("Test Description", actual.getDescription());
        assertTrue(actual.getDef());
    }
}

