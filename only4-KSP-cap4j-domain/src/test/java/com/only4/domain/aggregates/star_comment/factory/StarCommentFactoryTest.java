package com.only4.domain.aggregates.star_comment.factory;

import com.only4.domain.aggregates.star_comment.StarComment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StarCommentFactoryTest {

    @InjectMocks
    private StarCommentFactory starCommentFactory;

    @Mock
    private StarCommentFactory.Payload mockPayload;

    @Mock
    private StarComment result;


    @Test
    void create() {
        // TODO 需要重新编写
    }
}
