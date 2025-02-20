package com.only4.domain.aggregates.article;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArticleAuthorTest {

    private ArticleAuthor articleAuthor;

    @BeforeEach
    void setUp() {
        articleAuthor = ArticleAuthor.builder()
                .id(1L)
                .authorId(1L)
                .authorName("Author1")
                .build();
    }

    @Test
    void testUpdateInfo() {
        articleAuthor.updateInfo("New Author Name");
        assertEquals("New Author Name", articleAuthor.getAuthorName());
    }
}
