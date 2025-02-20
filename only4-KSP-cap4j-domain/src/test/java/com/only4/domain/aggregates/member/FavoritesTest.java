package com.only4.domain.aggregates.member;

import com.only4._share.exception.KnownException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class FavoritesTest {

    @Spy
    private Favorites favorites;

    @Mock
    private FavoritesArticle favoritesArticle;

    @Nested
    class UpdateInfoTests {
        @Test
        public void testUpdateInfo() {

            doReturn(false).when(favorites).isDef();

            favorites.updateInfo("newName", "newDesc");

            assertEquals("newName", favorites.getName());
            assertEquals("newDesc", favorites.getDescription());
        }

        @Test
        public void testUpdateInfoOnDefaultFavorites() {

            doReturn(true).when(favorites).isDef();

            KnownException exception = assertThrows(KnownException.class,
                    () -> favorites.updateInfo("newName", "newDesc"));

            assertEquals("默认收藏夹不能修改", exception.getMsg());
        }
    }

    @Nested
    class AddArticleTests {
        @Test
        public void testAddArticle() {
            doReturn(false).when(favorites).hasArticle(any());
            doReturn(new ArrayList<>()).when(favorites).getFavoritesArticles();

            favorites.addArticle(1L);

            assertEquals(1, favorites.getFavoritesArticles().size());
        }

        @Test
        public void testAddArticleHasArticle() {
            doReturn(true).when(favorites).hasArticle(any());

            KnownException exception = assertThrows(KnownException.class,
                    () -> favorites.addArticle(1L));

            assertEquals("该收藏夹已收藏该文章", exception.getMsg());

        }
    }

    @Nested
    class RemoveArticleTests {
        @Test
        public void testRemoveArticle() {
            ArrayList<FavoritesArticle> list = new ArrayList<>();
            list.add(FavoritesArticle.builder()
                    .articleId(1L)
                    .build());
            doReturn(list).when(favorites).getFavoritesArticles();

            assertEquals(1, favorites.getFavoritesArticles().size());

            favorites.removeArticle(1L);

            assertTrue(favorites.getFavoritesArticles().isEmpty());
        }

        @Test
        public void testRemoveArticleRecordNotFound() {
            doReturn(Collections.singletonList(favoritesArticle)).when(favorites).getFavoritesArticles();
            doReturn(2L).when(favoritesArticle).getArticleId();


            KnownException exception = assertThrows(KnownException.class,
                    () -> favorites.removeArticle(1L));

            assertEquals("文章收藏记录不存在", exception.getMsg());
        }
    }
}
