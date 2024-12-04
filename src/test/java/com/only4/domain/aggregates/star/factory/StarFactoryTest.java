package com.only4.domain.aggregates.star.factory;

import com.only4.domain.aggregates.star.Star;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StarFactoryTest {

    @InjectMocks
    private StarFactory starFactory;

    @Mock
    private StarFactory.Payload mockPayload;


    @Mock
    private Star star;



    @Test
    void create() {
        // 需要重新编写
    }
}
