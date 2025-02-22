package com.only4.application.commands.article;

import com.only4.domain.aggregates.article.Article;
import com.only4.domain.aggregates.article.ArticleAuthor;
import com.only4.domain.aggregates.article.factory.ArticleFactory;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.UnitOfWork;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactorySupervisor;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateArticleCmdTest {

    @InjectMocks
    private CreateArticleCmd.Handler handler;

    @Mock
    private AggregateFactorySupervisor factory;

    @Mock
    private UnitOfWork uow;

    @Mock
    private Article article;

    @Test
    void testExec_ShouldCreateArticleAndPersist_WhenRequestIsValid() {
        // 构建真实的 Request 对象
        CreateArticleCmd.Request request = CreateArticleCmd.Request.builder()
                .title("Test Title")
                .description("Test Description")
                .content("Test Content")
                .authors(Collections.singletonList(ArticleAuthor.builder()
                        .authorId(1L)
                        .authorName("Author")
                        .build())
                )
                .build();

        try (
                MockedStatic<Mediator> mediator = mockStatic(Mediator.class)
        ) {

            mediator.when(Mediator::factories).thenReturn(factory);
            mediator.when(Mediator::uow).thenReturn(uow);
            when(factory.create(any(ArticleFactory.Payload.class))).thenReturn(article);

            // 执行测试
            val response = handler.exec(request);

            // 验证响应
            assertTrue(response.isSuccess());

            // 验证Payload构建正确性
            ArgumentCaptor<ArticleFactory.Payload> payloadCaptor = ArgumentCaptor.forClass(ArticleFactory.Payload.class);
            verify(factory).create(payloadCaptor.capture());

            ArticleFactory.Payload payload = payloadCaptor.getValue();

            assertAll("Payload fields",
                    () -> assertEquals(request.getTitle(), payload.getTitle()),
                    () -> assertEquals(request.getDescription(), payload.getDescription()),
                    () -> assertEquals(request.getContent(), payload.getContent()),
                    () -> assertEquals(request.getAuthors(), payload.getAuthors())
            );

            // 验证领域操作
            verify(article).create();
            verify(uow).persist(article);
            verify(uow).save();

            /// 验证静态方法调用次数
            mediator.verify(
                    Mediator::factories,
                    times(1)
            );
            mediator.verify(
                    Mediator::uow,
                    times(2) // persist 和 save 各一次
            );

            verifyNoMoreInteractions(factory, uow, article);
        }
    }
}
