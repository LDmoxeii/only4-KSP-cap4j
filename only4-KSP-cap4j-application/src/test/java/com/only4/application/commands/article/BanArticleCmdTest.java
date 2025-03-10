package com.only4.application.commands.article;

import com.only4.domain.aggregates.article.Article;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.UnitOfWork;
import org.netcorepal.cap4j.ddd.domain.repo.RepositorySupervisor;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BanArticleCmdTest {

    @InjectMocks
    private BanArticleCmd.Handler handler;

    @Mock
    private UnitOfWork uow;

    @Mock
    private RepositorySupervisor repository;

    @Mock
    private Article article;

    @Mock
    private BanArticleCmd.Request request;

    @Test
    void testExec_ShouldBanArticleAndPersist_WhenRequestIsValid() {
        Long articleId = 1L;
        Integer banDuration = 30;
        try (
                MockedStatic<Mediator> mediator = mockStatic(Mediator.class)
        ) {
            when(request.getArticleId()).thenReturn(articleId);
            when(request.getBanDuration()).thenReturn(banDuration);
            mediator.when(Mediator::repositories).thenReturn(repository);
            mediator.when(Mediator::uow).thenReturn(uow);
            when(repository.findOne(any())).thenReturn(Optional.of(article));

            BanArticleCmd.Response response = handler.exec(request);

            assertTrue(response.isSuccess());
            verify(article).ban(request.getBanDuration());
            verify(uow).persist(article);
            verify(uow).save();

            /// 验证静态方法调用次数
            mediator.verify(
                    Mediator::repositories,
                    times(1)
            );
            mediator.verify(
                    Mediator::uow,
                    times(2) // persist 和 save 各一次
            );

            verifyNoMoreInteractions(repository, uow, article);
        }
    }
}
