package com.only4.domain.aggregates.star.factory;

import com.only4.domain.aggregates.star.Star;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StarFactoryTest {

    @InjectMocks
    private StarFactory starFactory;

    @Mock
    private StarPayload mockPayload;

    @Mock
    private Star star;



    @Test
    void create() {
        // 模拟 StarPayload 对象
        when(mockPayload.getMasterId()).thenReturn(1L);
        when(mockPayload.getName()).thenReturn("Test Star");
        when(mockPayload.getDescription()).thenReturn("This is a test star");

        // 调用 StarFactory 的 create 方法
        star = starFactory.create(mockPayload);

        // 验证返回的 Star 对象是否符合预期
        assertEquals(1L, star.getMasterId().longValue());
        assertEquals("Test Star", star.getName());
        assertEquals("This is a test star", star.getDescription());
    }
}
