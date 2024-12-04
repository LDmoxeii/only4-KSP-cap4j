package com.only4.domain.aggregates.article_comment.factory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ArticleCommentFactoryTest {

    @InjectMocks
    private ArticleCommentFactory articleCommentFactory;

    @Mock
    private ArticleCommentPayload mockPayload;


    @Test
    void create() {
        // TODO 需要重新编写
    }
}

