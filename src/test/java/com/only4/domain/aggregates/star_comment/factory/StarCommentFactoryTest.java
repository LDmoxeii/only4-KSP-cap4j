package com.only4.domain.aggregates.star_comment.factory;

import com.only4.domain.aggregates.star_comment.StarComment;
import com.only4.domain.aggregates.star_comment.StarCommentStatistics;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StarCommentFactoryTest {

    @InjectMocks
    private StarCommentFactory starCommentFactory;

    @Mock
    private StarCommentPayload mockPayload;

    @Mock
    private StarComment result;

    @Mock
    private StarCommentStatistics mockStatistics;

    @Test
    void create() {
        when(mockPayload.getArticleId()).thenReturn(1L);
        when(mockPayload.getAuthorId()).thenReturn(2L);
        when(mockPayload.getContent()).thenReturn("this is test");
        when(mockPayload.getStarCommentStatistics()).thenReturn(mockStatistics);

        result = starCommentFactory.create(mockPayload);

        // 验证结果
        assertNotNull(result);
        assertEquals(1L, result.getArticleId());
        assertEquals(2L, result.getAuthorId());
        assertEquals("this is test", result.getContent());
        assertEquals(Collections.singletonList(mockStatistics), result.getStarCommentStatistics());
    }
}
