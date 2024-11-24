package com.only4.domain.aggregates.follow.factory;

import com.only4.domain.aggregates.follow.Follow;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FollowFactoryTest {

    @InjectMocks
    private FollowFactory followFactory;

    @Mock
    private FollowPayload mockPayload;

    @Test
    void create() {
        // Mock the behavior of the payload
        when(mockPayload.getFollowerId()).thenReturn(101L);
        when(mockPayload.getFollowedId()).thenReturn(202L);

        // Call the method under test
        Follow actual = followFactory.create(mockPayload);

        // Verify the results
        assertEquals(101L, actual.getFollowerId());
        assertEquals(202L, actual.getFollowedId());
    }
}

