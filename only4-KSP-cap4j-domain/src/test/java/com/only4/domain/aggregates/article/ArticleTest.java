package com.only4.domain.aggregates.article;

import com.only4.common.exception.KnownException;
import com.only4.domain.aggregates.article.dto.CategoryDto;
import com.only4.domain.aggregates.article.dto.TagDto;
import com.only4.domain.aggregates.article.enums.ArticleVisibility;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.netcorepal.cap4j.ddd.domain.event.DomainEventSupervisor;
import org.netcorepal.cap4j.ddd.domain.event.DomainEventSupervisorSupport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ArticleTest {

    @Spy
    private Article article;

    @Mock
    private ArticleAuthor author;

    @Mock
    private ArticleStatistics articleStatistics;

    @Mock
    private ArticleCategory articleCategory;


    @Mock
    private ArticleTag articleTag;

    @Mock
    private DomainEventSupervisor eventSupervisor;

    @Nested
    class CreateTests {
        @Test
        void testCreate() {
            try (MockedStatic<DomainEventSupervisorSupport> mockStatic = mockStatic(DomainEventSupervisorSupport.class)) {
                mockStatic.when(DomainEventSupervisorSupport::events).thenReturn(eventSupervisor);

                article.create();

                verify(eventSupervisor).attach(any(), any());
                mockStatic.verify(DomainEventSupervisorSupport::events, times(1));
            }
        }
    }

    @Nested
    class UpdateLikeCountTests {
        @Test
        void testUpdateLikeCount() {
            try (MockedStatic<DomainEventSupervisorSupport> mockStatic = mockStatic(DomainEventSupervisorSupport.class)) {
                mockStatic.when(DomainEventSupervisorSupport::events).thenReturn(eventSupervisor);
                when(article.getArticleStatistics()).thenReturn(articleStatistics);

                article.updateLikeCount(1);

                verify(articleStatistics).updateLikeCount(1);
                verify(eventSupervisor).attach(any(), any());
                mockStatic.verify(DomainEventSupervisorSupport::events, times(1));
            }
        }
    }

    @Nested
    class UpdateVisibilityTests {
        @Test
        void testUpdateVisibility() {
            ArticleVisibility newVisibility = ArticleVisibility.PUBLISH;
            article.updateVisibility(newVisibility);

            assertEquals(newVisibility, article.getVisibility());
        }
    }

    @Nested
    class UpdateInfoTests {
        @Test
        void testUpdateInfo() {
            String newTitle = "New Title";
            String newDescription = "New Description";

            article.updateInfo(newTitle, newDescription);

            assertAll(
                    () -> assertEquals(newTitle, article.getTitle()),
                    () -> assertEquals(newDescription, article.getDescription())
            );
        }
    }

    @Nested
    class BanTests {
        @Test
        void testBan() {
            article.updateVisibility(ArticleVisibility.PUBLISH);
            Integer banDuration = 30;

            article.ban(banDuration);

            assertAll(
                    () -> assertEquals(ArticleVisibility.BANNED, article.getVisibility()),
                    () -> assertNotNull(article.getBannedAt()),
                    () -> assertEquals(banDuration, article.getBanDuration())
            );
        }

        @Test
        void testBanAlreadyBanned() {
            article.updateVisibility(ArticleVisibility.BANNED);
            Integer banDuration = 30;

            KnownException exception = assertThrows(KnownException.class, () -> article.ban(banDuration));
            assertEquals("文章已被封禁", exception.getMessage());
        }
    }

    @Nested
    class UpdateTagsTests {
        @Test
        void testUpdateTags() {
            try (MockedStatic<DomainEventSupervisorSupport> mockStatic = mockStatic(DomainEventSupervisorSupport.class)) {
                mockStatic.when(DomainEventSupervisorSupport::events).thenReturn(eventSupervisor);

                List<TagDto> tags = Arrays.asList(new TagDto(1L, "Tag1"), new TagDto(2L, "Tag2"));
                List<ArticleTag> articleTags = new ArrayList<>();
                articleTags.add(ArticleTag.builder().tagId(1L).tagName("TTT").build());

                when(article.getArticleTags()).thenReturn(articleTags);

                article.updateTags(tags);

                assertEquals(2, article.getArticleTags().size());
                assertTrue(article.getArticleTags().stream().anyMatch(at -> at.getTagName().equals("Tag2")));

                verify(eventSupervisor).attach(any(), any());
                mockStatic.verify(DomainEventSupervisorSupport::events, times(1));
            }
        }
    }

    @Nested
    class UpdateCategoryTests {
        @Test
        void testUpdateCategory() {
            try (MockedStatic<DomainEventSupervisorSupport> mockStatic = mockStatic(DomainEventSupervisorSupport.class)) {
                mockStatic.when(DomainEventSupervisorSupport::events).thenReturn(eventSupervisor);

                List<CategoryDto> categories = Arrays.asList(new CategoryDto(1L, "Category1"), new CategoryDto(2L, "Category2"));
                List<ArticleCategory> articleCategories = new ArrayList<>();
                articleCategories.add(ArticleCategory.builder().categoryId(1L).categoryName("TTT").build());
                when(article.getArticleCategories()).thenReturn(articleCategories);

                article.updateCategory(categories);

                assertEquals(2, article.getArticleCategories().size());
                assertTrue(article.getArticleCategories().stream().anyMatch(at -> at.getCategoryName().equals("Category2")));

                verify(eventSupervisor).attach(any(), any());
                mockStatic.verify(DomainEventSupervisorSupport::events, times(1));
            }
        }
    }

    @Nested
    class UpdateFavoriteCountTests {
        @Test
        void testUpdateFavoriteCount() {
            when(article.getArticleStatistics()).thenReturn(articleStatistics);

            article.updateFavoriteCount(1);

            verify(articleStatistics).updateFavoriteCount(1);
        }
    }

    @Nested
    class UpdateCommentCountTests {
        @Test
        void testUpdateCommentCount() {
            when(article.getArticleStatistics()).thenReturn(articleStatistics);

            article.updateCommentCount(1);

            verify(articleStatistics).updateCommentCount(1);
        }
    }

    @Nested
    class UpdateAuthorInfoTests {
        @Test
        void testUpdateAuthorInfo() {
            Long memberId = 1L;
            String memberName = "New Author Name";
            when(article.getArticleAuthors()).thenReturn(Collections.singletonList(author));
            when(author.getId()).thenReturn(memberId);

            article.updateAuthorInfo(memberId, memberName);

            verify(author).updateInfo(memberName);
        }

        @Test
        void testUpdateAuthorInfoNoAuthor() {
            Long memberId = 1L;
            String memberName = "New Author Name";
            when(article.getArticleAuthors()).thenReturn(Collections.emptyList());

            KnownException exception = assertThrows(KnownException.class, () -> article.updateAuthorInfo(memberId, memberName));
            assertEquals("文章没有作者", exception.getMessage());
        }

        @Test
        void testUpdateAuthorInfoNotAuthor() {
            Long memberId = 1L;
            String memberName = "New Author Name";
            when(article.getArticleAuthors()).thenReturn(Collections.singletonList(author));
            when(author.getId()).thenReturn(2L);

            KnownException exception = assertThrows(KnownException.class, () -> article.updateAuthorInfo(memberId, memberName));
            assertEquals("不是作者, 无法修改", exception.getMessage());
        }
    }

    @Nested
    class UpdateTagInfoTests {
        @Test
        void testUpdateTagInfo() {
            Long tagId = 1L;
            String tagName = "New Tag Name";
            when(article.getArticleTags()).thenReturn(Collections.singletonList(articleTag));
            when(articleTag.getId()).thenReturn(tagId);

            article.updateTagInfo(tagId, tagName);

            verify(articleTag).updateInfo(tagName);
        }

        @Test
        void testUpdateTagInfoNoTag() {
            Long tagId = 1L;
            String tagName = "New Tag Name";
            when(article.getArticleTags()).thenReturn(Collections.emptyList());

            KnownException exception = assertThrows(KnownException.class, () -> article.updateTagInfo(tagId, tagName));
            assertEquals("文章没有标签", exception.getMessage());
        }

        @Test
        void testUpdateTagInfoTagNotFound() {
            Long tagId = 1L;
            String tagName = "New Tag Name";
            when(article.getArticleTags()).thenReturn(Collections.singletonList(articleTag));
            when(articleTag.getId()).thenReturn(2L);

            KnownException exception = assertThrows(KnownException.class, () -> article.updateTagInfo(tagId, tagName));
            assertEquals("标签不存在", exception.getMessage());
        }
    }

    @Nested
    class UpdateCategoryInfoTests {
        @Test
        void testUpdateCategoryInfo() {
            Long categoryId = 1L;
            String categoryName = "New Category Name";
            when(article.getArticleCategories()).thenReturn(Collections.singletonList(articleCategory));
            when(articleCategory.getId()).thenReturn(categoryId);

            article.updateCategoryInfo(categoryId, categoryName);

            verify(articleCategory).updateInfo(categoryName);
        }

        @Test
        void testUpdateCategoryInfoNoCategory() {
            Long categoryId = 1L;
            String categoryName = "New Category Name";
            when(article.getArticleCategories()).thenReturn(Collections.emptyList());

            KnownException exception = assertThrows(KnownException.class, () -> article.updateCategoryInfo(categoryId, categoryName));
            assertEquals("文章没有分类", exception.getMessage());
        }

        @Test
        void testUpdateCategoryInfoCategoryNotFound() {
            Long categoryId = 1L;
            String categoryName = "New Category Name";
            when(article.getArticleCategories()).thenReturn(Collections.singletonList(articleCategory));
            when(articleCategory.getId()).thenReturn(2L);

            KnownException exception = assertThrows(KnownException.class, () -> article.updateCategoryInfo(categoryId, categoryName));
            assertEquals("分类不存在", exception.getMessage());
        }
    }

    @Nested
    class UpdateCommentFlagTests {
        @Test
        void testUpdateCommentFlag() {
            Boolean commentFlag = true;

            article.updateCommentFlag(commentFlag);

            assertEquals(commentFlag, article.getCommentFlag());
        }
    }

    @Nested
    class UpdatePriceTests {
        @Test
        void testUpdatePrice() {
            Long price = 100L;

            article.updatePrice(price);

            assertEquals(price, article.getPrice());
        }
    }

    @Nested
    class UpdateStickyTests {
        @Test
        void testUpdateSticky() {
            Boolean sticky = true;

            article.updateSticky(sticky);

            assertEquals(sticky, article.getStickyFlag());
        }
    }
}
