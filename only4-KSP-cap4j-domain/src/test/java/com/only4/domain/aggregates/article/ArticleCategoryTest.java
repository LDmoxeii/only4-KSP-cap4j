package com.only4.domain.aggregates.article;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArticleCategoryTest {

    private ArticleCategory articleCategory;

    @BeforeEach
    void setUp() {
        articleCategory = ArticleCategory.builder()
                .id(1L)
                .categoryId(1L)
                .categoryName("Category1")
                .build();
    }

    @Test
    void testUpdateInfo() {
        articleCategory.updateInfo("New Category Name");
        assertEquals("New Category Name", articleCategory.getCategoryName());
    }
}
