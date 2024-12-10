package com.only4.domain.aggregates.star_comment_like.factory;

import com.only4.domain.aggregates.star_comment_like.StarCommentLike;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StarCommentLikeFactoryTest {

    @InjectMocks
    private StarCommentLikeFactory starCommentLikeFactory;

    @Mock
    private StarCommentLikeFactory.Payload mockPayload;

    @Mock
    private StarCommentLike starCommentLike;




    @Test
    void create() {
        // 模拟 StarCommentLikePayload 对象
        when(mockPayload.getCustomerId()).thenReturn(1L);
        when(mockPayload.getCommentId()).thenReturn(2L);

        // 调用 StarCommentLikeFactory 的 create 方法
        starCommentLike = starCommentLikeFactory.create(mockPayload);

        // 验证返回的 StarCommentLike 对象是否符合预期
        assertEquals(1L, starCommentLike.getCustomerId().longValue());
        assertEquals(2L, starCommentLike.getCommentId().longValue());
    }
}
